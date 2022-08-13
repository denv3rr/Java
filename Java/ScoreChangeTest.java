import java.util.Arrays;

public class Scores {
    public static void main(String[] args) {

        // Declare and initialize a 4x3 2D array of doubles called `scores` which
        // will contain the exam data for four students. The rows will represent the
        // student and the columns will represent the exam number. You already know the
        // first exam scores (80.4, 96.2, 100.0, 78.9). Use initializer lists to store
        // the first exam scores in the first column and -1 for the remaining exams.

        double[][] scores = { { 80.4, -1, -1 }, { 96.2, -1, -1 }, { 100.0, -1, -1 }, { 78.9, -1, -1 } };

        System.out.println("************************\n\nInitial score data:\n" + Arrays.deepToString(scores) + "\n");

        // The next set of exams have occurred. Manually entered
        // the scores (89.7, 90.5, 93.6, 88.1) for the second exam (column 1).
        scores[0][1] = 89.7;
        scores[1][1] = 90.5;
        scores[2][1] = 93.6;
        scores[3][1] = 88.1;

        System.out.println("New score data:\n" + Arrays.deepToString(scores) + "\n");

        // If you realized that you will now only be keeping track of 2 exam grades
        // instead of 3, declare and initialize an empty 4x2 2D array of double values
        // called newScores
        double[][] newScores = new double[4][2];

        // Using loops, copy all of the scores for exam 1 and 2 into the new 2D array.
        // (do not include the -1 values)
        for (int i = 0; i < newScores.length; i++) {
            for (int j = 0; j < newScores[i].length; j++) {
                newScores[i][j] = scores[i][j];
            }
        }

        System.out.println("Score data reformatted into a 4x2 to drop the no longer needed third value (-1):\n"
                + Arrays.deepToString(newScores) + "\n");

        // If you have allowed the students to complete an extra credit activity to
        // contribute towards their scores, for all exam grades less than 90, add 2
        // additional points to the grade in `newScores`
        for (int i = 0; i < newScores.length; i++) {
            for (int j = 0; j < newScores[i].length; j++) {
                if (newScores[i][j] < 90) {
                    newScores[i][j] += 2;
                }
            }
        }

        System.out.println(
                "Any grades below 90 were given an extra 2 points to assist their grade:\n"
                        + Arrays.deepToString(newScores) + "\n\n************************");
    }
}