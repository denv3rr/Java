//save as Test.java

import java.util.*;

public class Test {
    String positive_responses[] = { "Excellent!", "Very good!", "Nice work!", "Way to go!", "Keep up the good work!" };
    String negative_responses[] = { "That is incorrect!", "No. Please try again!", "Wrong, Try once more!",
            "No. Don't give up!", "Incorrect. Keep trying!" };

    Random num = new Random();

    Scanner ans = new Scanner(System.in);
    int numlimit = 10;

    public void questions() {
        int a = num.nextInt(numlimit);
        int b = num.nextInt(numlimit);
        int i = 1;

        System.out.println("How much " + a + " times " + b);
        int input = ans.nextInt();

        while (input != a * b) {
            System.out.println(negative_responses[i % 5]);
            System.out.println("How much " + a + " times " + b);
            input = ans.nextInt();
            i++;
        }
        System.out.println(positive_responses[i % 5] + "\n");
    }

    public void test() {
        String choice = "y";
        int i = 0;

        while (choice.equals("y")) {
            i++;
            questions();

            if (i >= 5) {
                System.out.print("Do you want to continue(y/n)?: ");
                choice = ans.next();
            }
        }
    }
}