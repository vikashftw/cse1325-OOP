package test;

import customer.Student;
import product.Media;

public class TestStudent {
    public static void main(String[] args) {

        int points = 0;
        
        Student student = new Student("Prof Rice", 1001234567, "george.rice@uta.edu");
        String expected = "Prof Rice (1001234567, george.rice@uta.edu, Account #1)";
        String actual = student.toString();

        if (!expected.equals(actual)) {
            System.out.println("FAIL: Student toString() returned incorrect value.");
            System.exit(1);
        }

        try {
            new Student("John Doe", 1007654321, "john.doe@gmail.com");
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
        String expectedPlayResult = "Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0), "+ points + " points";

        if (!expectedPlayResult.equals(playResult)) {
            System.out.println("FAIL: Student requestMedia() returned incorrect value.");
            System.exit(1);
        }

        System.exit(0);
    }
}
