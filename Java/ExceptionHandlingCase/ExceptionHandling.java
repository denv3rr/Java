
public class Exam3ExceptionQuestion {
    public static void main(String[] args) {
        Exam3ExceptionQuestion obj = new Exam3ExceptionQuestion();
        obj.throwExceptionOne();
    }

    public void throwExceptionOne() throws Exam3Exception {
        String message = null;
        try {
            throwExceptionTwo();
        } catch (Exception exception) {
            if (exception != null) {
                message = exception.getMessage();
                System.err.println("Exception handled in method throwExceptionOne. " + message);
            }
        }
    }

    public void throwExceptionTwo() throws Exam3Exception {
        try {
            throw new Exam3Exception();
        } finally {
            System.out.println("Finally executed in throwExceptionTwo");
        }
    }
}

public class Exam3Exception extends RuntimeException {
    public Exam3Exception() {
        this("Invalid score.");
    }

    public Exam3Exception(String message) {
        super(message);
    }
}