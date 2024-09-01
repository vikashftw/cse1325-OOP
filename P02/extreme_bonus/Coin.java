public class Coin {
    private Denomination denomination;
    private int year;

    public Coin(Denomination denomination, int year) {
        this.denomination = denomination;
        this.year = year;
    }

    public double getValue() {
        return denomination.getValue();
    }

    public double getWeight() {
        switch(denomination) {
            case PENNY:
                return year < 1983 ? 3.110 : 2.500;
            case NICKEL:
                return 5.000;
            case DIME:
                return year < 1965 ? 2.500 : 2.268;
            case QUARTER:
                return year < 1965 ? 6.250 : 5.670;
            default:
                return 0.000;
        }
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return year + " " + denomination.toString();
    }
}