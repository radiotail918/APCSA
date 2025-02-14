public class Position()
{
    public Position(int r, int c)
    {

    }
    public static Position findPosition(int c, int[][] ar)
    {

        for(int i=0; i<ar.length;i++)
        {
            for(int j=0;j<ar[i].length;j++)
            {
                if(ar[i][j]==c)
                {
                    Position result = new Position(i,j);
                    return result;
                }
            }
        }
        return null;

    }
    public static Position[][] getSuccessorArray(int[][] ar)
    {
        Position[][] result= new Position[ar.length][ar[0].length]
        int min= ar[0][0];
        for(int i =0;i<ar.length;i++)
        {
            for(int j=0;j<ar[i].length;j++)
            {
                if(ar[i][j]<min)
                {
                    min=ar[i][j];
                    if(i==ar.length-1&&j==ar[i].length-1)
                    {
                        Position minP=new Position(i,j);
                        result[i][j]=minP;
                    }
                }
            }
        }
        for(int i=0;i<ar.length*ar[0].length;i++)
        {
            Position temp=findPosition(++min,ar);


        }


    }

}