public class Purse {
    public static void main(String[] args) {
        Coin[] purse = new Coin[] {
            new Coin(Denomination.PENNY, 1850),
            new Coin(Denomination.NICKEL, 1862),
            new Coin(Denomination.DIME, 1905),
            new Coin(Denomination.QUARTER, 1803),
            new Coin(Denomination.NICKEL, 1915),
        };

        double sumCoins = 0.0;
        int earliestYear = Integer.MAX_VALUE;
        int latestYear = Integer.MIN_VALUE;

        for(Coin coin : purse) {
            sumCoins += coin.getValue();

            if(coin.getYear() < earliestYear) {
                earliestYear = coin.getYear();
            } 
            if(coin.getYear() > latestYear) {
                latestYear = coin.getYear();
            }
        }
    }
}