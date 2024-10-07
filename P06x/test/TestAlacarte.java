package test;

import customer.Alacarte;
import product.Media;

public class TestAlacarte {
    public static void main(String[] args) {
        Alacarte alacarteAccount = new Alacarte();
        alacarteAccount.buyPoints(10);
        if (alacarteAccount.getPointsRemaining() != 10) {
            System.out.println("FAIL: Buying points did not update pointsRemaining correctly.");
            System.exit(1);
        }

        Media media1 = new Media("Test Media", "https://example.com/testmedia", 5);
        String playResult1 = alacarteAccount.play(media1);
        if (!playResult1.equals("Playing Test Media (https://example.com/testmedia), 5 points")) {
            System.out.println("FAIL: play() did not return correct value when sufficient points were available.");
            System.exit(1);
        }

        if (alacarteAccount.getPointsRemaining() != 5) {
            System.out.println("FAIL: Points remaining were not updated correctly after playing media.");
            System.exit(1);
        }

        Media media2 = new Media("Expensive Media", "https://example.com/expensivemedia", 10);
        String playResult2 = alacarteAccount.play(media2);
        String expectedResult = "Buy more points: Requires 10 points, you have 5";
        if (!playResult2.equals(expectedResult)) {
            System.out.println("FAIL: play() did not return correct value when insufficient points were available.");
            System.exit(1);
        }

        System.exit(0);
    }
}
