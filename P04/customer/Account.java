package customer;

import product.Media;

/**
 * Represents an abstract account for managing media access.
 * Each account has a unique account number and must define how media is played.
 * 
 * @author Vikash Mall
 * @version 1.0
 * @since 1.0
 */
public abstract class Account {

    private int accountNumber;
    private static int nextAccountNumber = 1;

    /**
     * Constructs a new Account with a unique account number.
     * 
     * @since 1.0
     */
    public Account() {
        this.accountNumber = nextAccountNumber++;
    }

    /**
     * Returns the account number of the account.
     * 
     * @return the account number
     * @since 1.0
     */
    public int getAccountNumber() {
        return accountNumber;
    }

    /**
     * Abstract method to play media.
     * Each subclass must implement how media is played.
     * 
     * @param media the media to be played
     * @return the result of playing the media
     * @since 1.0
     */
    public abstract String play(Media media);
}