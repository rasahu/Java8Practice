package example1;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class URLShortener {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int SHORT_URL_LENGTH = 7;
    private static final Map<String, String> urlMap = new HashMap<>();
    private static final Random random = new Random();

    public static String shortenURL(String longURL) {
        if (urlMap.containsKey(longURL)) {
            return urlMap.get(longURL);
        }

        String shortURL = generateShortURL(longURL);
        urlMap.put(longURL, shortURL);
        return shortURL;
    }

    private static String generateShortURL(String longURL) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(longURL.getBytes());
            StringBuilder shortURL = new StringBuilder();

            for (int i = 0; i < SHORT_URL_LENGTH; i++) {
                int index = (hash[i] & 0xFF) % ALPHABET.length();
                shortURL.append(ALPHABET.charAt(index));
            }

            return shortURL.toString();

        } catch (NoSuchAlgorithmException e) {
            // Handle exception (e.g., use a fallback method)
            return generateRandomShortURL();
        }
    }

    private static String generateRandomShortURL() {
        StringBuilder shortURL = new StringBuilder();
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            int index = random.nextInt(ALPHABET.length());
            shortURL.append(ALPHABET.charAt(index));
        }
        System.out.println();
        return shortURL.toString();
    }

    public static String getLongURL(String shortURL) {
        for (Map.Entry<String, String> entry : urlMap.entrySet()) {
            if (entry.getValue().equals(shortURL)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String longURL = "https://www.example.com/very/long/path";
        String shortURL = shortenURL(longURL);
        System.out.println("Short URL: " + shortURL);
        System.out.println("Long URL: " + getLongURL(shortURL));
    }
}