package pages;
import java.util.UUID;


public class TestDataRandom {

    public static String getRandomEmail() {
        return "user" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
    }

    public static String getRandomString(int length) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, length);
    }

}
