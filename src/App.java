import java.util.Random;
import java.util.Scanner;

public class App {
    private static final Scanner STDIN = new Scanner(System.in);

    private static final int MAX_RANDOM_NUMBER_AMOUNT = 1000;
    private static final int RESPONSE_LIMIT = 10;
    private static final int START_COUNT = 1;
    private static final int DISTANCE_UNIT = 10;

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
            } else {
                showMessageWithNewLine(Messages.SMALLER_TIPS);
            }
            if (isAway(randomNumber, inputNumber)) {
                showFormattedMessage(Messages.AWAY_TIPS, DISTANCE_UNIT);
                showNewLine();
            } else {
                showFormattedMessage(Messages.NEAREST_TIPS, DISTANCE_UNIT);
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

    private static boolean isAway(int number1, int number2) {
        int distance = Math.abs(number1 - number2);
        return distance >= DISTANCE_UNIT;
    }

    private static void showMessageWithNewLine(String message) {
        System.out.println(message);
    }

    private static void showNewLine() {
        System.out.println();
    }

    private static void showFormattedMessage(String message, int number) {
        System.out.format(message, number);
    }
}
