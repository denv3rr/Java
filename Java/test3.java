import java.util.Arrays;

public class TwoDMtrxModEx {
    public static void main(String[] args) {
        // Create 2D array
        int[][] intMatrix = {
                { 1, 1, 1, 1, 1 },
                { 2, 4, 6, 8, 0 },
                { 9, 8, 7, 6, 5 }
        };

        // Replace the number 4 in the 2D array with the number 0
        intMatrix[1][1] = 0;

        // Testing that the array was created
        // System.out.println(Arrays.deepToString(intMatrix));

        // Declare and initialize a new empty 2x2 integer 2D array called subMatrix
        int[][] subMatrix = new int[2][2];

        // Set integers in subMatrix by grabbing the 4 integers of the top left corner
        // of intMatrix and multiplying them by 5.
        subMatrix[0][0] = intMatrix[0][0] * 5;
        subMatrix[0][1] = intMatrix[0][1] * 5;
        subMatrix[1][0] = intMatrix[1][0] * 5;
        subMatrix[1][1] = intMatrix[1][1] * 5;

        System.out.println(Arrays.deepToString(subMatrix));
    }
}