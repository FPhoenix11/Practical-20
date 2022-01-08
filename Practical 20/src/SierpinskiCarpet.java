public class SierpinskiCarpet
{
    //declares the variables, so they can be accessed at any point in the code
    static int size;
    static char[][] board;

    // this is the main method and is barely used in the code. It sets original size of the carpet to 3 and then calls
    //upon the carpet function
    public static void main (String[] args)
    {
        size = 3;
        Carpet();
    }

    //this function will find the value to store in each part of the array (does 1 value at a time)
    public static char inCarpet (int x, int y)
    {

        //this means it will keep checking while x and y are both non-zero values
        while ((x!=0)&&(y!=0))
        {

            //this uses the modulus operator to check the remainder, and if both are 1, then it will return the ' '
            if ((x % 3 == 1) && (y % 3 == 1)) {

                return ' ';

            }

            //will divide by 3 to lower the number, so it can keep checking to see if the space should be a ' '
            x /= 3;
            y /= 3;
        }

        //if the above while loop doesn't return a value at all because it exhausted itself, then this will return
        //to carpet, setting the variable as '*'
        return '*';

    }


    //this function creates the board to be used based on the size then outputs what the
    //Sierpinski Carpet should look like
    public static void Carpet ()
    {

        //overwrites or creates a new version of the board variable to fill
        board = new char[size][size];

        //this for is for the row being looked at the time
        for (int i = 0; i<size; i++)
        {

            //this for is for the column being looked at the time
            for (int j = 0;j<size;j++)
            {

                //this will find out what the value will be stored in that exact spot in the array then out put it
                //without creating a new line
                board[i][j] = inCarpet(i,j);
                System.out.print(board[i][j]);

            }
            //creates a new line to use for the next row
            System.out.println();
        }

        //Create a new line for the next set of Sierpinski Carpet
        System.out.println();

        //increases the size of the carpet by 3 times. This is because the carpet is 3^(n-1)x3(n-1)
        size = size * 3;

        //since the requirements cap at 243, it will check the size and if its 243 or smaller, it will recurse this
        //function until the size is greater than 243
        if (size <= 243)
        {
            Carpet();
        }

    }

}
