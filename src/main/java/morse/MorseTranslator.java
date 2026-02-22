package morse;

import java.util.HashMap;
import java.util.Map;

public class MorseTranslator {

    private final Map<Character, String> morseMap = new HashMap<>();




    private final Map<String, Character> reverseMap = new HashMap<>();
    //Ny variabel, Morse - bokstav (för decode). För engelska delen. reverse istället för att skriva om igen




    public MorseTranslator() {
        morseMap.put('A', ".-");
        morseMap.put('B', "-...");
        morseMap.put('C', "-.-.");
        morseMap.put('D', "-..");
        morseMap.put('E', ".");
        morseMap.put('F', "..-.");
        morseMap.put('G', "--.");
        morseMap.put('H', "....");
        morseMap.put('I', "..");
        morseMap.put('J', ".---");
        morseMap.put('K', "-.-");
        morseMap.put('L', ".-..");
        morseMap.put('M', "--");
        morseMap.put('N', "-.");
        morseMap.put('O', "---");
        morseMap.put('P', ".--.");
        morseMap.put('Q', "--.-");
        morseMap.put('R', ".-.");
        morseMap.put('S', "...");
        morseMap.put('T', "-");
        morseMap.put('U', "..-");
        morseMap.put('V', "...-");
        morseMap.put('W', ".--");
        morseMap.put('X', "-..-");
        morseMap.put('Y', "-.--");
        morseMap.put('Z', "--..");

        for (Map.Entry<Character, String> entry : morseMap.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
            //för engelska delen
        }



    }

    public String toMorse(String text) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char letter = Character.toUpperCase(text.charAt(i));

            if (!morseMap.containsKey(letter)) {
                throw new IllegalArgumentException("Invalid character: " + letter);
            }

            result.append(morseMap.get(letter));

            if (i < text.length() - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public String toEnglish(String morse) {
        String[] parts = morse.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            Character letter = reverseMap.get(part);

            if (letter == null) {
                throw new IllegalArgumentException("Invalid morse sequence: " + part);
            }

            result.append(letter);
        }

        return result.toString();
    }


}