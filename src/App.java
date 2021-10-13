import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static final int MAX_RANDOM_NUMBER_AMOUNT = 100;
    private static final int RESPONSE_LIMIT = 5;

    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_RANDOM_NUMBER_AMOUNT);

        System.out.println(Messages.GAME_DESCRIPTION);
        System.out.println();
        System.out.printf(Messages.ANSWER_LIMIT_DESCRIPTION, RESPONSE_LIMIT);
        System.out.println();

        try {
            boolean isComplete = false;
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < RESPONSE_LIMIT; i++) {
                System.out.printf(Messages.ANSWER_COUNT, i + 1);
                Integer inputNumber = scanner.nextInt();

                if (randomNumber == inputNumber) {
                    System.out.printf(Messages.COMPLETE_GAME, i + 1);
                    isComplete = true;
                    break;
                } else if (randomNumber > inputNumber) {
                    System.out.println(Messages.BIGGER_TIPS);
                } else if (randomNumber < inputNumber) {
                    System.out.println(Messages.SMALLER_TIPS);
                }
            }

            if (!isComplete) {
                System.out.printf(Messages.GAME_OVER, randomNumber);
            }

            scanner.close();

        } catch (InputMismatchException e) {
            System.out.println(Messages.ENTER_NUMBER_WARN);
        }
    }
}
