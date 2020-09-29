package model;

public class Matrix {
    
    public Matrix() {

    }

    public int[][] projMatMul(double[][] tB2, int[][] oB3) {
        int[][] result = new int[tB2.length][oB3[0].length];
        for (int i = 0; i < tB2.length; i++) {
            int d = 0;
            for (int j = 0; j < oB3.length; j++) {
                d += (int) oB3[j][0] * tB2[i][j];
            }
            result[i][0] = d;
        }

        return result;
    }

    public int[][] oB3Matrix(int x, int y, int z) {
        int[][] result = new int[3][1];
        result [0][0] = x;
        result [1][0] = y;
        result [2][0] = z;
        return result;
    }
}
