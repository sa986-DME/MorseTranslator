package morse;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class MorseTranslatorTest {



    @Test
    void encode_singleLetter_E_shouldReturnDot() {
        MorseTranslator mt = new MorseTranslator();
        assertEquals(".", mt.toMorse("E"));
    }



    @Test
    void encode_SOS_shouldReturnCorrectMorse() {
        MorseTranslator mt = new MorseTranslator();
        assertEquals("... --- ...", mt.toMorse("SOS"));
    }



    @Test
    void decode_HEJ_fromAssignmentExample() {
        MorseTranslator mt = new MorseTranslator();
        assertEquals("HEJ", mt.toEnglish(".... . .---"));
    }


    @Test
    void decode_HELLOWORLD_fromAssignment() {
        MorseTranslator mt = new MorseTranslator();
        assertEquals("HELLOWORLD",
                mt.toEnglish(".... . .-.. .-.. --- .-- --- .-. .-.. -.."));
    }



    @Test
    void decode_invalidMorse_shouldThrowException() {
        MorseTranslator mt = new MorseTranslator();

        assertThrows(IllegalArgumentException.class, () -> {
            mt.toEnglish(".... ....-.-");
        });
    }
}


