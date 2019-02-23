package com.me.ready.graph;

public class MatrixNDG {

    public char[] vexs;
    public char[][] matrix;

    public MatrixNDG(char[] vexs, char[][] matrix) {
        this.vexs = vexs;
        this.matrix = matrix;
    }

    public static void init() {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F'};
        char[][] matrix = new char[][]{
                {'A', 'C'},
                {'A', 'D'},
                {'A', 'D'},
                {'A', 'D'},
                {'A', 'D'},
                {'A', 'D'},
                {'A', 'D'},
                {'A', 'D'},
                {'A', 'D'},
                {'A', 'D'}
        };
        MatrixNDG matrixNDG = new MatrixNDG(vexs, matrix);
    }
}
