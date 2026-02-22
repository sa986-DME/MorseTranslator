package morse;

import java.util.Scanner;

public class application {

    public static void main(String[] args) {

        MorseTranslator translator = new MorseTranslator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Morse Translator ===");
        System.out.println("1: English -> Morse");
        System.out.println("2: Morse -> English");

        System.out.print("Choose (1 or 2): ");
        String choice = scanner.nextLine();

        try {
            if (choice.equals("1")) {
                System.out.print("Enter English text: ");
                String input = scanner.nextLine();
                String result = translator.toMorse(input);
                System.out.println("Morse: " + result);
            }
            else if (choice.equals("2")) {
                System.out.print("Enter Morse code (separate with spaces): ");
                String input = scanner.nextLine();
                String result = translator.toEnglish(input);
                System.out.println("English: " + result);
            }
            else {
                System.out.println("Invalid choice.");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}