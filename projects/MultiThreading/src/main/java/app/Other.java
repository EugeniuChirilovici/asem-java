package app;

public class Other extends Thread {

    int A[][] = Main.matrix;
    private int row;
    private int column;

    public Other(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public void run(){
        int sum = sumElemet();
        synchronized (Main.dog){
            try {
                Main.counter++;
                Main.dog.wait();
                A[row][column] = sum;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int sumElemet(){
        int i =row,j=column;
        return A[i-1][j-1]+A[i-1][j]+A[i-1][j+1]+
                A[i][j-1]+A[i][j+1]+A[i][j]+
                A[i+1][j-1]+A[i+1][j]+A[i+1][j+1];
    }
}
