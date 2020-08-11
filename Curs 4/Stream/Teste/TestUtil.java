package Stream.Teste;

public class TestUtil {

    public static String generateMessage(boolean value, int nr) {
        return value ? "Exercise " + nr + " completed! :)" : "Exercise " + nr + " failed.. :(";
    }
}
