import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TSP {
    private int N;
    private Point[] points;
    private boolean[] marked;
    private LinkedList<Integer> cycle;
    private double[][] d0istMatrix; // Precomputed distance matrix
    private List<Integer>[] nearestNeighbors; // Pre-sorted nearest neighbors for each point
    public double lengthOfCycle = 0;

    public TSP(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner sc = new Scanner(file);

        N = sc.nextInt();
        points = new Point[N];
        marked = new boolean[N];
        cycle = new LinkedList<>();
        distMatrix = new double[N][N];
        nearestNeighbors = (List<Integer>[]) new List[N];

        for (int i = 0; i < N; i++) {
            int tempX = sc.nextInt();
            int tempY = sc.nextInt();
            points[i] = new Point(tempX, tempY);
        }

        // Precompute distance matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                distMatrix[i][j] = points[i].distance(points[j]);
            }
        }

        // Pre-sort neighbors for each point
        for (int j = 0; j < N; j++) {
            List<Integer> neighbors = new ArrayList<>();
            Arr<String> iad = new ArrayList<>();
            for (int k = 0; k < N; k++) {
                if (k != j) {
                    neighbors.add(k);
                }
            }
            neighbors.sort(Comparator.comparingDouble(k -> distMatrix[j][k]));
            nearestNeighbors[j] = neighbors;
        }

        sc.close();
    }

    public double distance(int i, int j) {
        return distMatrix[i][j];
    }

    public int findUnmarkedPointClosestToPoint(int j) {
        for (int k : nearestNeighbors[j]) {
            if (!marked[k]) {
                return k;
            }
        }
        return -1; // Should not occur if all points are processed correctly
    }

    public void applyDoubleNeighborHeuristic() {
        int A = 0;
        int B = findUnmarkedPointClosestToPoint(A);
        int unmarkCount = 2;
        marked[A] = true;
        marked[B] = true;

        cycle.add(A);
        cycle.add(B);
        lengthOfCycle += distance(A, B);

        while (unmarkCount < N) {
            int p1 = findUnmarkedPointClosestToPoint(A);
            int p2 = findUnmarkedPointClosestToPoint(B);
            double s = distance(A, p1);
            double t = distance(B, p2);

            if (s < t) {
                A = p1;
                cycle.addFirst(A);
                marked[A] = true;
                lengthOfCycle += s;
                unmarkCount++;
            } else {
                B = p2;
                cycle.addLast(B);
                marked[B] = true;
                lengthOfCycle += t;
                unmarkCount++;
            }
        }
        lengthOfCycle += distance(A, B);

        // Output remains the same as before
        System.out.println("+++++++++++++++++++++++++++++++\n" +
                "+Traveling Salesperson Problem+\n" +
                "+++++++++++++++++++++++++++++++\n" +
                "+  Double Neighbor Heuristic  +\n" +
                "+++++++++++++++++++++++++++++++\n" +
                "\n");
        System.out.println("N= " + N + " Points");
        System.out.println(" -------|------------\n" +
                " index  |  point\n" +
                " -------|------------\n");
        for (int i = 0; i < N; i++) {
            System.out.println(i + "    |  " + points[i].toString() + "\n" +
                    " -------|------------\n");
        }
        System.out.println("\n" +
                "+++++++++++++++\n" +
                "+ Cycle found +\n" +
                "+++++++++++++++\n");
        for (int i = 0; i < N - 1; i++) {
            System.out.println(points[cycle.get(i)].toString() + " ->- " + distance(cycle.get(i), cycle.get(i + 1)));
        }
        System.out.println("->- " + points[cycle.get(N - 1)].toString() + " ->- " + distance(cycle.get(N - 1), cycle.get(0)) + " ->- " + points[cycle.get(0)]);

        System.out.println("++++++++++++++++++++++\n" +
                "+ Total Cycle Length +\n" +
                "++++++++++++++++++++++\n");
        System.out.println(lengthOfCycle);
        System.out.println(cycle.toString());
        System.out.println(lengthOfCycle);
    }

    public static void main(String[] args) throws FileNotFoundException {
        TSP tsp = new TSP("tspTest.txt");
        tsp.applyDoubleNeighborHeuristic();
    }
}


