package test;

import customer.Student;
import customer.Alacarte;
import product.Media;

public class TestStudent {
    public static void main(String[] args) {

        int points = 0;
        
        Student student = new Student("Prof Rice", 1001234567, "george.rice@uta.edu", true);
        String expected = "Prof Rice (1001234567, george.rice@uta.edu, Account #1)";
        String actual = student.toString();

        if (!expected.equals(actual)) {
            System.out.println("FAIL: Student toString() returned incorrect value.");
            System.exit(1);
        }

        try {
            new Student("John Doe", 1007654321, "john.doe@gmail.com", false);
            System.out.println("FAIL: IllegalArgumentException not thrown for invalid email.");
            System.exit(1);
        } catch (IllegalArgumentException e) {
            if (!e.getMessage().equals("Non-UTA email address: john.doe@gmail.com")) {
                System.out.println("FAIL: Incorrect exception message: " + e.getMessage());
                System.exit(1);
            }
        }

        Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", points);
        String playResult = student.requestMedia(media);
        String expectedPlayResult = "Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0), " + points + " points";

        if (!expectedPlayResult.equals(playResult)) {
            System.out.println("FAIL: Student requestMedia() returned incorrect value.");
            System.exit(1);
        }

        // New Tests Below for Alacarte and Unlimited account:

        Media unlimitedMedia = new Media("Unlimited Media", "https://example.com/unlimitedmedia", 5);
        String unlimitedPlayResult = student.requestMedia(unlimitedMedia);
        String expectedUnlimitedResult = "Playing Unlimited Media (https://example.com/unlimitedmedia), 5 points";
        if (!unlimitedPlayResult.equals(expectedUnlimitedResult)) {
            System.out.println("FAIL: Unlimited account's requestMedia() did not return the expected value.");
            System.exit(1);
        }

        Student alacarteStudent = new Student("John Doe", 1007654321, "john.doe@mavs.uta.edu", false);
        
        ((Alacarte) alacarteStudent.getAccount()).buyPoints(10);
        
        Media alacarteMedia = new Media("Test Media with 5 points", "https://example.com/testmedia", 5);
        String alacartePlayResult = alacarteStudent.requestMedia(alacarteMedia);
        String expectedAlacarteResult = "Playing Test Media with 5 points (https://example.com/testmedia), 5 points";
        
        if (!alacartePlayResult.equals(expectedAlacarteResult)) {
            System.out.println("FAIL: Alacarte account's requestMedia() did not return correct result when sufficient points were available.");
            System.exit(1);
        }

        Media expensiveMedia = new Media("Expensive Media", "https://example.com/expensivemedia", 10); // Media requires 10 points
        String alacarteInsufficientResult = alacarteStudent.requestMedia(expensiveMedia);
        String expectedInsufficientResult = "Buy more points: Requires 10 points, you have 5";
        
        if (!alacarteInsufficientResult.equals(expectedInsufficientResult)) {
            System.out.println("FAIL: Alacarte account did not return correct result when insufficient points were available.");
            System.exit(1);
        }

        System.exit(0);
    }
}
