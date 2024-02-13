import java.util.Random;
import java.util.Scanner;

public class KingdomAdventure {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();
    private static final String[] RIDDLES = {
            "What has to be broken before you can use it?",
            "I'm tall when I'm young, and I'm short when I'm old. What am I?",
            "What has keys but can't open locks?",
            "What has a heart that doesn’t beat?",
            "I speak without a mouth and hear without ears. I have no body, but I come alive with wind. What am I?",
            "I am taken from a mine, and shut up in a wooden case, from which I am never released, and yet I am used by almost every person. What am I?",
            "I am not alive, but I grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I?",
            "I am a word of letters three; add two and fewer there will be. What am I?",
            "I am a five letter word, and I am a programming language that starts with a 'J'. What am I?",
            "I am a seven letter word containing thousands of letters. What am I?"
    };

    private static final String[][] OPTIONS = {
            {"Glowstick", "Treasure", "Egg"},
            {"A tree", "A candle", "A mountain"},
            {"A map", "A piano", "A book"},
            {"An apple", "A clock", "A car"},
            {"A ghost", "An echo", "A cloud"},
            {"Gold", "Coal", "Pencil lead"},
            {"Fire", "A plant", "A fish"},
            {"Few", "One", "All"},
            {"Jumpy", "Jolly", "Java"},
            {"Mailbox", "Postman", "Envelope"}
    };

    private static final int[] CORRECT_ANSWERS = {3, 2, 2, 1, 2, 3, 1, 1, 3, 1};

    private static final String[] MISFORTUNES = {
            "May you always step on a wet spot after putting on fresh socks.",
            "May your tea always be too hot when you receive it and too cold by the time you remember it’s there.",
            "May your grocery bag always break when you’re carrying it up the stairs.",
            "May your phone always run out of battery just as you need to make an important call.",
            "May you always get a popcorn kernel stuck in your teeth during a movie.",
            "May your Wi-Fi disconnect every time you’re about to win an online game.",
            "May you always forget your password when you need it the most.",
            "May your favorite song come on the radio just as you reach your destination.",
            "May you always feel a phantom vibration in your pocket, but find no new notifications on your phone.",
            "May your pen always run out of ink during an important meeting.",
            "May you always hit every red light when you’re running late.",
            "May your toast always fall butter-side down.",
            "May you always forget an important ingredient after starting to cook.",
            "May your shoelaces always come undone when your hands are full.",
            "May you always sneeze just as you take a big sip of your drink.",
            "May your alarm clock always fail to go off on the most important day.",
            "May you always miss the bus by a few seconds.",
            "May your earphones always get tangled in your pocket.",
            "May you always forget the name of the person you’re introducing.",
            "May you always find a spoiler online just before you watch the movie."
    };


    public static void main(String[] args) {
        System.out.println("Welcome to the AB Kingdom Adventure!");
        System.out.println("In this game, you will face 10 doors, each with its own riddle.");
        System.out.println("Choose the correct door and you may proceed to your ultimate desire.");
        System.out.println("But BEWARE, for choosing incorrectly may lead to a GREAT misfortune.");
        System.out.print("Are you sure you want to join this game? (yes/no): ");
        String response = scanner.nextLine();

        if (!response.trim().equalsIgnoreCase("yes")) {
            System.out.println("Maybe next time. Farewell!");
            return;
        }

        for (int level = 0; level < RIDDLES.length; level++) {
            if (!attemptLevel(level)) {
                int misfortuneIndex = random.nextInt(MISFORTUNES.length);
                System.out.println(MISFORTUNES[misfortuneIndex]);
                System.out.println("Game over.");
                return;
            }
            System.out.println("Congratulations on passing Level " + (level + 1) + "!");
        }

        System.out.println("You have opened the final door to reveal a kingdom of gold and all your desires fulfilled!");
    }

    private static boolean attemptLevel(int level) {
        System.out.println("\nYou are at Level " + (level + 1) + ". Before you are 3 doors, each with a riddle.");
        System.out.println("Riddle: " + RIDDLES[level]);
        for (int i = 0; i < OPTIONS[level].length; i++) {
            System.out.println((i + 1) + ": " + OPTIONS[level][i]);
        }

        System.out.print("Choose your door (1-3): ");
        int chosenDoor = scanner.nextInt();
        scanner.nextLine(); // Clear the scanner buffer

        if (chosenDoor < 1 || chosenDoor > 3) {
            System.out.println("Invalid door. Choose a door between 1 and 3.");
            return false; // If the player chooses an invalid door, they fail the level.
        }

        if (chosenDoor == CORRECT_ANSWERS[level]) {
            System.out.println("Correct! You may pass to the next level.");
            return true; // The player guessed correctly and can move on to the next level.
        } else {
            System.out.println("Incorrect. The correct answer was " + OPTIONS[level][CORRECT_ANSWERS[level] - 1]);
            return false; // The player guessed incorrectly, ending the game.
        }
    }
}

