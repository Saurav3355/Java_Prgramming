import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Test test = new Test();  // Create an instance of Test
        test.inputAnswer();  // Start the test
    }
}

class Test {
    private int correctAnswers = 0;
    private int incorrectAnswers = 0;
    private final String[] questions = {
            "In which year did Sun Microsystems fund an internal corporate research project led by James Gosling, which resulted in a C++-based object-oriented programming language that Sun called Java?",
            "Which of the following editions of Java contains the capabilities needed to develop desktop and server applications?",
            "Which of the following components does a Java application need to have at least one of?",
            "Which one of the following symbols indicates a multi-line comment in Java application source code?",
            "Class variables must be declared as___________."
    };

    private final String[][] options = {
            {"1999", "1991", "1998", "1990"},
            {"Java Micro Edition (Java ME)", "Java Enterprise Edition 2 (Java 2 EE)", "Java Standard Edition 8 (Java SE 8)", "Java Enterprise Edition (Java EE)"},
            {"Non-static Method", "Class", "Local variable", "Instance variable"},
            {"/* */", "//", "##", "||"},
            {"const", "static", "var", "final"}
    };

    private final int[] correctAnswersIndices = {1, 2, 1, 0, 1}; // Indices of correct answers

    public void inputAnswer() {
        Scanner scanner = new Scanner(System.in); // Create a scanner to read input
        for (int i = 0; i < questions.length; i++) {
            boolean validAnswer = false; // Flag to check if the answer is valid
            while (!validAnswer) { // Loop until a valid answer is provided
                simulateQuestion(i, scanner);
                validAnswer = checkUserAnswer(scanner, i); // Validate the answer
            }
        }
        displayResults();
        scanner.close(); // Close the scanner
    }

    public void simulateQuestion(int questionIndex, Scanner scanner) {
        // Format the options for display
        System.out.println(questions[questionIndex]);
        char optionLabel = 'a';
        for (String option : options[questionIndex]) {
            System.out.println(optionLabel + ") " + option);
            optionLabel++;
        }
        System.out.print("Your answer (a/b/c/d): ");
    }

    public boolean checkUserAnswer(Scanner scanner, int questionIndex) {
        String userAnswer = scanner.nextLine().toLowerCase(); // Read user input
        if (userAnswer.length() == 1 && userAnswer.charAt(0) >= 'a' && userAnswer.charAt(0) < 'a' + options[questionIndex].length) {
            int answerIndex = userAnswer.charAt(0) - 'a'; // Convert 'a' to index 0, 'b' to index 1, etc.
            checkAnswer(answerIndex, questionIndex); // Check the answer
            return true; // Valid answer provided
        } else {
            System.out.println("Invalid answer. Please try again.");
            return false; // Invalid answer
        }
    }

    public void checkAnswer(int userAnswerIndex, int questionIndex) {
        if (userAnswerIndex == correctAnswersIndices[questionIndex]) {
            correctAnswers++;
            System.out.println(generateMessage(true));
        } else {
            incorrectAnswers++;
            System.out.println(generateMessage(false) + "\nCorrect answer: " + options[questionIndex][correctAnswersIndices[questionIndex]]);
        }
    }

    public String generateMessage(boolean isCorrect) {
        Random randomObject = new Random();
        int messageIndex = randomObject.nextInt(4); // Generates a random number between 0 and 3

        String[] correctMessages = {
                "Excellent!", "Good!", "Keep up the good work!", "Nice work!"
        };
        String[] incorrectMessages = {
                "No. Please try again.", "Wrong. Try once more.", "Don't give up!", "No. Keep trying."
        };

        return isCorrect ? correctMessages[messageIndex] : incorrectMessages[messageIndex];
    }

    public void displayResults() {
        int totalQuestions = questions.length;
        double percentageCorrect = ((double) correctAnswers / totalQuestions) * 100;

        System.out.println("Test completed!");
        System.out.println("Correct Answers: " + correctAnswers);
        System.out.println("Incorrect Answers: " + incorrectAnswers);
        System.out.printf("Percentage: %.2f%%\n", percentageCorrect); // Formatting to 2 decimal places
    }
}
