package com.bridgelabz.searching;

public class SearchInSortedMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = rows * cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols, col = mid % cols;
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5}, {7, 9, 11}, {13, 15, 17}};
        int target = 9;
        System.out.println(searchMatrix(matrix, target));
    }
}
