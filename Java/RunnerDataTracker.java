public class RunnerData {
    public static void main(String[] args) {

        // Given runner lap data:
        double[][] times = {
                { 64.791, 75.972, 68.950, 79.039, 73.006, 74.157 },
                { 67.768, 69.334, 70.450, 67.667, 75.686, 76.298 },
                { 72.653, 77.649, 74.245, 62.121, 63.379, 79.354 }
        };
        double lapTime = 0.0;

        for (int outer = 0; outer < times[0].length; outer++) {

            lapTime = 0.0;
            for (int inner = 0; inner < times.length; inner++) {
                System.out.println("Lap index: " + outer + ", Time index: " + inner);

                // Sums up the values in each column using the variable lapTime
                lapTime += times[inner][outer];

            }

            double averageVal = lapTime / times.length;

            System.out.println("\nSum of lap " + outer + " times: " + lapTime);
            System.out.println("Average time for lap " + outer + ": " + averageVal
                    + "\n-------------------------------------------\n");
        }
    }
}