package xogame;

import java.util.Scanner;

public class Xogame {

    public static Scanner obj = new Scanner(System.in);
    public static int num = obj.nextInt();

    public static int[][] Uiarr = new int[num][num];
    public static int row = 0;
    public static int col = 0;
    public static boolean player = true;
    public static int counter = 0;

    public static void printUi() {
        for (int i = 1; i <= Uiarr.length; i++) {
            System.out.print("\t[" + i + "]");
        }
        System.out.println("");
        for (int i = 0; i < Uiarr.length; i++) {
            System.out.print("[" + (i + 1) + "]\t");

            for (int j = 0; j < Uiarr.length; j++) {
                if (Uiarr[i][j] == 0) {
                    System.out.print("---\t");
                } else if (Uiarr[i][j] == 1) {
                    System.out.print(" X\t");
                } else if (Uiarr[i][j] == 10) {
                    System.out.print(" O\t");
                }
            }
            System.out.println("");
            System.out.println("");
        }
    }

    public static void getInPut() {
        do {
            do {
                System.out.println("enter row:");
                row = (obj.nextInt() - 1);

            } while (row < 0 || row > num);

            do {
                System.out.println("enter col:");
                col = (obj.nextInt() - 1);

            } while (col < 0 || col > num);

        } while (Uiarr[row][col] != 0);

    }

    public static void setArr() {
        if (player == true) {
            Uiarr[row][col] = 1;

        } else {
            Uiarr[row][col] = 10;

        }
    }
//--------------------------winner--------------

    public static boolean winner() {
        int sum = 0;
        for (int i = 0; i < Uiarr.length; i++) {
            for (int j = 0; j < Uiarr.length; j++) {
                sum = sum + Uiarr[i][j];
                if (sum == (10 * num)) {

                    return true;
                }
            }
            sum = 0;
        }
        for (int i = 0; i < Uiarr.length; i++) {
            for (int j = 0; j < Uiarr.length; j++) {
                sum = sum + Uiarr[i][j];
                if (sum == (1 * num)) {

                    return true;
                }
            }
            sum = 0;
        }
        for (int i = 0; i < Uiarr.length; i++) {
            for (int j = 0; j < Uiarr.length; j++) {
                sum = sum + Uiarr[j][i];
                if (sum == (1 * num)) {
                    System.out.println("you win");
                    return true;
                }
            }
            sum = 0;
        }
        for (int i = 0; i < Uiarr.length; i++) {
            for (int j = 0; j < Uiarr.length; j++) {
                sum = sum + Uiarr[j][i];
                if (sum == (1 * num)) {
                    return true;
                }
            }
            sum = 0;
        }

        for (int i = 0; i < Uiarr.length; i++) {
            sum = sum + Uiarr[i][i];
            if (sum == (1 * num)) {

                return true;
            }
        }
        sum = 0;

        for (int i = 0; i < Uiarr.length; i++) {
            sum = sum + Uiarr[i][i];
            if (sum == (10 * num)) {
                return true;
            }
        }
        sum = 0;

        int j = num - 1;
        for (int i = 0; i < Uiarr.length; i++) {
            sum = sum + Uiarr[i][j];
            j--;
            if (sum == (1 * num)) {
                return true;
            }
        }
        sum = 0;

        j = num - 1;
        for (int i = 0; i < Uiarr.length; i++) {
            sum = sum + Uiarr[i][j];
            j--;
            if (sum == (10 * num)) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) 
    {

        boolean flag = winner();
        while (flag == false && counter != (num * num))
        {

            printUi();
            getInPut();
            setArr();

            flag = winner();
            player = !player;
            counter++;

        }
        printUi();
        player = !player;
        printResult(flag);

    }

    public static void printResult(boolean flag)
    {
        if (player == true && flag == true) 
        {
            System.out.println("Player One win !");
        
        } 
        else if (player == false && flag == true) 
        {
            System.out.println("Player Two win !");

        } 
        else
        {
            System.out.println("drawn");
        }
    }
}
