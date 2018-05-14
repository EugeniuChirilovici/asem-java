package app;

import java.util.Arrays;

public class Main {
    public static Object dog = new Object();
    public static volatile int counter = 0;

    public static int[][] matrix = new int[][]{
            {0,0,0,0,0,0,0},
            {0,1,2,3,2,1,0},
            {0,2,3,4,3,2,0},
            {0,3,4,5,4,3,0},
            {0,4,5,6,5,4,0},
            {0,5,6,7,6,5,0},
            {0,0,0,0,0,0,0}
    };

    public static void main(String[] args) throws InterruptedException {
        for(int i = 1 ; i<6 ; i++){
            for (int j = 1 ; j<6 ; j++) {
                Thread myThread = new Other(i,j);
                myThread.start();
            }
        }

        while (counter<25){
            Thread.sleep(10);
        }

        while (counter>0){
            synchronized (dog) {
                dog.notify();
            }
            counter--;
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
