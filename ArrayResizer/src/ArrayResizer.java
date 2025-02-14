import java.util.Arrays;

public class ArrayResizer {

    public static boolean isNonZeroRow(int[][] array2D, int r) {
        for (int j = 0; j < array2D[r].length; j++) {
            if (array2D[r][j] == 0) {
                return false;
            }
        }
        return true;

    }

    public static int numNonZeroRows(int[][] array2D) {
        int count = 0;
        for (int i = 0; i < array2D.length; i++) {
            if (isNonZeroRow(array2D, i)) {
                count++;
            }
        }
        return count;

    }

    public static int[][] resize(int[][] array2D) {
        int[][] newArray = new int[numNonZeroRows(array2D)][array2D[0].length];
        int rowNum=0;
        for (int i = 0; i < array2D.length; i++) {
            if (isNonZeroRow(array2D, i)) {
                for(int j=0;j<array2D[i].length;j++)
                {
                    newArray[rowNum][j]=array2D[i][j];

                }
                rowNum++;
            }
        }
        return newArray;
    }

    public static void main(String[] args)
    {
        int[][] arr={{2,1,0},
                {1,3,2},
                {0,0,0},
                {4,5,6}

        };
        int[][] smaller = ArrayResizer.resize(arr);
        System.out.println(Arrays.deepToString(smaller));
    }

}