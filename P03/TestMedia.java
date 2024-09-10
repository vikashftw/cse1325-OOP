public class TestMedia {
    public static void main(String[] args) {
        Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0");
        String expected = "The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)";
        String actual = media.toString();

        if (!expected.equals(actual)) {
            System.out.println("FAIL: toString() returned incorrect value.");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            System.exit(1);
        }

        String[] validURLs = {
            "https://youtube.com",
            "file://media/lib/garp.mp4"
        };
        
        for (String url : validURLs) {
            try {
                new Media("Test", url);
            } catch (Exception e) {
                System.out.println("FAIL: Valid URL was rejected: " + url);
                System.exit(1);
            }
        }

        String[] invalidURLs = {
            "hello.world",
            "htt://badurl.com",
            "flub://badurl.com"
        };

        for (String url : invalidURLs) {
            try {
                new Media("Test", url);
                System.out.println("FAIL: Invalid URL was accepted: " + url);
                System.exit(1);
            } catch (IllegalArgumentException e) {
                if (!e.getMessage().equals("Invalid URL: " + url)) {
                    System.out.println("FAIL: Incorrect exception message for URL: " + url);
                    System.exit(1);
                }
            }
        }

        System.exit(0);
    }
}
