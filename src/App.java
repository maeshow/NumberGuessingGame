import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static final int MAX_RANDOM_NUMBER_AMOUNT = 100;
    private static final int RESPONSE_LIMIT = 5;

    public static void main(String[] args) throws Exception {
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_RANDOM_NUMBER_AMOUNT);

        System.out.println("数字を当ててみてね");
        System.out.println();
        System.out.printf("答えられるのは%d回までだよ", RESPONSE_LIMIT);
        System.out.println();

        try {
            boolean isComplete = false;
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < RESPONSE_LIMIT; i++) {
                System.out.printf("%d回目: ", i + 1);
                Integer inputNumber = scanner.nextInt();

                if (randomNumber == inputNumber) {
                    System.out.printf("すごい！！%d回で当てられちゃった！", i + 1);
                    isComplete = true;
                    break;
                } else if (randomNumber > inputNumber) {
                    System.out.println("もっと大きい数だよ");
                } else if (randomNumber < inputNumber) {
                    System.out.println("もっと小さい数だよ");
                }
            }

            if (!isComplete) {
                System.out.printf("残念！！正解は %d でした！", randomNumber);
            }

            scanner.close();

        } catch (InputMismatchException e) {
            System.out.println("数字を入力してください");
        }
    }
}
