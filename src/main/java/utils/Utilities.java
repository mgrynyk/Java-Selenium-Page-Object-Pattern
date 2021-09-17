package utils;

import java.util.UUID;

public class Utilities {
    public String generateRandomName() {
        return UUID.randomUUID().toString().substring(0, 5);
    }

    public String generateRandomEmail() {
        return System.currentTimeMillis() + "random@email.pl";
    }

}

