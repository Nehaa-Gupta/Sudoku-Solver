import java.util.*;
class Sudoku{
    
    // }
    // public static void printBoard(char board[][]){
    //     System.out.println("--------------------------------------------------------");
    //     for(int i=0;i<board.length;i++){
    //         for (int j=0;j<board.length;j++){
    //             System.out.print(board[i][j]+" ");
    //         }
    //         System.out.println();
    //     }

    // }
    // public static int gridways(int i, int j, int n, int m){ //O(2^(n+m))
    //     //base
    //     if(i==n-1 && j==m-1){
    //         return 1;
    //     }
    //     else if(i==n || j==m){
    //         return 0;
    //     }

    //     //kaam
    //     //return (gridways(i+1, j, n, m))+(gridways(i, j+1, n, m));
    //     int w1=gridways(i+1, j, n, m);
    //     int w2=gridways(i, j+1, n, m);
    //     return w1+w2;
    // }
    public static boolean isSafe(int s[][],int r,int c,int digit){
        //row
        for (int i=0;i<s.length;i++){
            if(s[i][c]==digit){
                return false;
            }
        }
        //col
        for (int i=0;i<s.length;i++){
            if(s[r][i]==digit){
                return false;
            }
        }
        int sc=(c/3)*3;
        int sr=(r/3)*3;
        for(int i=sr;i<sr+3;i++){
            for (int j=sc;j<sc+3;j++){
                if(s[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudoku(int s[][], int row, int col){
        //base
        if(row==9){
            return true;
        }
        //kaam
        int newrow=row, newcol=col+1;
        if(col==8){
            newrow=row+1;
            newcol=0;
        }
        if(s[row][col]!=0){
            return sudoku(s, newrow, newcol);
        }
        
        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(s, row, col, digit)) {
                s[row][col] = digit;
                if (sudoku(s, newrow, newcol)) {
                    return true;
                }
                s[row][col] = 0;
            }
        }
        return false;
    }
    public static void print(int s[][]){
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for(int i=0;i<s.length;i++){
            for (int j=0;j<s.length;j++){
                System.out.print(s[i][j]+" ");
                if(j==2||j==5){
                    System.out.print("| ");
                }
            }
            System.err.println();
            if(i==2||i==5){
                for (int k=0;k<21;k++){
                    System.out.print("_");
                }
                System.out.println();
            }
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    static int count;
    public static void main(String args[]){
          //subset("abc", "", 0);
          //subset("abc",new StringBuilder(""),0);
          //permutations("ab", "");
        //   Scanner sc=new Scanner(System.in);
        //   int n=sc.nextInt();
        //   char board[][]=new char[n][n];
        //   sc.close();
        //   for(int i=0;i<board.length;i++){
        //     for (int j=0;j<board.length;j++){
        //         board[i][j]='X';
        //     }
        //   }   
        //   queens(board, 0);
        //   System.out.println("no of ways="+count);
        //System.out.println(gridways(0, 0, 3,3));
        Scanner sc=new Scanner(System.in);
        int board[][]=new int[9][9];
        String ch;
        System.out.print("This is a 9x9 sudoku solver. Enter the row and column number along with the digit to input your sudoku. Once done with all inputs, press 0 to lock in the sudoku. ");
        System.out.println(" The sudoku question will be displayed on the screen for you to check, if something's wrong make the changes in the input and if it's coorect. We'll solve the grid for you.");
        System.out.println();
        do{
            while(0<1){
                System.out.println("Enter the row(1-9), column(1-9) and the digit(1-9) for input. To display the input, enter -1");
                int r,c,digit;
                r=sc.nextInt();
                while((r>9||r<1)&&r!=-1){
                    System.out.println("Invalid row. Enter a valid row(1-9)");
                    r=sc.nextInt();
                }
                if(r==-1){ break;} 
                c=sc.nextInt();
                while((c>9||c<1)&&c!=-1){
                    System.out.println("Invalid column. Enter a valid column(1-9)");
                    c=sc.nextInt();
                }
                if(c==-1){ break;}
                digit=sc.nextInt();
                while((digit>9||digit<1)&&digit!=-1){
                    System.out.println("Invalid digit. Enter a valid digit(1-9)");
                    digit=sc.nextInt();
                }
                if(digit==-1){break;}
                board[r-1][c-1]=digit;
                
            }
            print(board);
            System.out.println("If you are satisfied with the input, press 'Y'or to keep entering press 'N'");
            ch=sc.next();
        }while(!ch.equalsIgnoreCase("Y"));
        System.out.println("Sudoku solution");
        boolean flag=sudoku(board, 0, 0);
        print(board);
        if(flag){
            print(board);
        }else{
            System.out.println("Invalid grid entered");
        }
        sc.close();
        
        // Scanner sc=new Scanner(System.in);
        // int board[][]=new int[9][9];
        // for(int i=0;i<9;i++){
        //     System.out.println("Enter row "+(i+1));
        //     String s=sc.nextLine();
        //     for(int j=0;j<9;j++){
        //         board[i][j]=s.charAt(j)-'0';
        //     }
        // }
        // System.out.println("Input Grid");
        // print(board);
        // System.out.println("Sudoku solution");
        // boolean flag=sudoku(board, 0, 0);
        // if(flag){
        //     print(board);
        // }else{
        //     System.out.println("Invalid grid entered");
        // }
        // sc.close();
          
        // int board[][] = {
        //     {5, 3, 0, 0, 7, 0, 0, 0, 0},
        //     {6, 0, 0, 1, 9, 5, 0, 0, 0},
        //     {0, 9, 8, 0, 0, 0, 0, 6, 0},
        //     {8, 0, 0, 0, 6, 0, 0, 0, 3},
        //     {4, 0, 0, 8, 0, 3, 0, 0, 1},
        //     {7, 0, 0, 0, 2, 0, 0, 0, 6},
        //     {0, 6, 0, 0, 0, 0, 2, 8, 0},
        //     {0, 0, 0, 4, 1, 9, 0, 0, 5},
        //     {0, 0, 0, 0, 8, 0, 0, 7, 9}
        // };

        // System.out.println("Input Sudoku:");
        // print(board);

        // boolean flag = sudoku(board, 0, 0);
        // if (flag) {
        //     System.out.println("Solved Sudoku:");
        //     print(board);
        // } else {
        //     System.out.println("Invalid grid entered");
        // }
          
    }

}