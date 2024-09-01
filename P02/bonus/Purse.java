public class Purse {
    public static void main(String[] args) {
        Coin[] purse = new Coin[] {
                new Coin(Denomination.PENNY, 1910),
                new Coin(Denomination.NICKEL, 1938),
                new Coin(Denomination.DIME, 1946),
                new Coin(Denomination.QUARTER, 1967),
                new Coin(Denomination.NICKEL, 2017),
        };

        double sumCoins = 0.0;
        int earliestYear = Integer.MAX_VALUE;
        int latestYear = Integer.MIN_VALUE;

        for (Coin coin : purse) {
            System.out.println(coin);
            sumCoins += coin.getValue();

            if (coin.getYear() < earliestYear) {
                earliestYear = coin.getYear();
            }
            if (coin.getYear() > latestYear) {
                latestYear = coin.getYear();
            }
        }
        System.out.println("Total value of coins in the purse: $" + sumCoins);
        System.out.println("Earliest Year: " + earliestYear);
        System.out.print("Latest Year: " + latestYear);
    }
}