public class TestAccount {
    public static void main(String[] args) {
        Account account1 = new Account();
        Account account2 = new Account();

        if (account1.getAccountNumber() != 1) {
            System.out.println("FAIL: First account number is incorrect.");
            System.exit(1);
        }

        if (account2.getAccountNumber() != 2) {
            System.out.println("FAIL: Second account number is incorrect.");
            System.exit(1);
        }

        System.exit(0);
    }
}
