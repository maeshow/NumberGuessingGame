import java.util.Random;
import java.util.Scanner;

public class App {
    private static final Scanner STDIN = new Scanner(System.in);

    private static final int MAX_RANDOM_NUMBER_AMOUNT = 100;
    private static final int RESPONSE_LIMIT = 5;
    private static final int START_COUNT = 1;

    public static void main(String[] args) throws Exception {
        int randomNumber = getRandomNum(MAX_RANDOM_NUMBER_AMOUNT);

        showMessageWithNewLine(Messages.GAME_DESCRIPTION);
        showNewLine();
        showFormattedMessage(Messages.ANSWER_LIMIT_DESCRIPTION, RESPONSE_LIMIT);
        showNewLine();

        int count = START_COUNT;
        boolean isComplete = false;
        while (isResponseLimitRange(count)) {
            int inputNumber = getPlayerInput(count);

            if (isEqualNumber(randomNumber, inputNumber)) {
                showFormattedMessage(Messages.COMPLETE_GAME, count);
                isComplete = true;
                break;
            }
            if (isBigger(randomNumber, inputNumber)) {
                showMessageWithNewLine(Messages.BIGGER_TIPS);
                showNewLine();
            } else {
                showMessageWithNewLine(Messages.SMALLER_TIPS);
                showNewLine();
            }
            count++;
        }

        if (!isComplete) {
            showFormattedMessage(Messages.GAME_OVER, randomNumber);
        }

        STDIN.close();
    }

    private static int getRandomNum(int maxNumberAmount) {
        Random random = new Random();
        return random.nextInt(maxNumberAmount);
    }

    private static int getPlayerInput(int count) {
        try {
            showFormattedMessage(Messages.ANSWER_COUNT, count);
            String input = STDIN.next();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            showMessageWithNewLine(Messages.ENTER_NUMBER_WARN);
            showNewLine();
            return getPlayerInput(count);
        }
    }

    private static boolean isResponseLimitRange(int count) {
        return count <= RESPONSE_LIMIT;
    }

    private static boolean isEqualNumber(int number1, int number2) {
        return number1 == number2;
    }

    private static boolean isBigger(int number1, int number2) {
        return number1 > number2;
    }

    private static void showMessageWithNewLine(String message) {
        System.out.println(message);
    }

    private static void showMessageWithoutNewLine(String message) {
        System.out.printf(message);
    }

    private static void showNewLine() {
        System.out.println();
    }

    private static void showFormattedMessage(String message, int number) {
        System.out.format(message, number);
    }
}
