import java.util.Random;
import javax.swing.JOptionPane;

public class NumberGame {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int minRange = 1;
        int maxRange = 100;
        int maxAttempts = 5;
        int score = 0;

        Random random = new Random();
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        JOptionPane.showMessageDialog(null, "Welcome to Guess the Number game!");

        while (true) {
            String userInput = JOptionPane.showInputDialog("Guess the number between " + minRange + " and " + maxRange +
                    "\nAttempts remaining: " + maxAttempts + "\nScore: " + score);

            if (userInput == null) {
                JOptionPane.showMessageDialog(null, "Game exited. Your final score: " + score);
                break;
            }

            int userGuess = Integer.parseInt(userInput);
            maxAttempts--;

            if (userGuess == randomNumber) {
                score += maxAttempts + 1;
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed the number!\nYour score: " + score);
                int option = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    maxAttempts = 5;
                    randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                } else {
                    JOptionPane.showMessageDialog(null, "Game exited. Your final score: " + score);
                    break;
                }
            } else if (userGuess < randomNumber) {
                JOptionPane.showMessageDialog(null, "Too low! Try again.");
            } else if (userGuess > randomNumber) {
                JOptionPane.showMessageDialog(null, "Too high! Try again.");
            }

            if (maxAttempts == 0) {
                JOptionPane.showMessageDialog(null, "Out of attempts! The number was: " + randomNumber + "\nYour final score: " + score);
                int option = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    maxAttempts = 5;
                    score = 0;
                    randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
                } else {
                    JOptionPane.showMessageDialog(null, "Game exited. Your final score: " + score);
                    break;
                }
            }
}
}
}