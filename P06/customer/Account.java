package customer;

import product.Media;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

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
     * Constructs an Account object by reading values from a BufferedReader.
     * Reads the account number and next account number in that order.
     *
     * @param br BufferedReader object for reading the account fields.
     * @throws IOException if an I/O error occurs
     * @since 1.0
     */
    public Account(BufferedReader br) throws IOException {
        this.accountNumber = Integer.parseInt(br.readLine());
        nextAccountNumber = Integer.parseInt(br.readLine());
    }

    /**
     * Saves the account fields to a file using the provided BufferedWriter.
     * Writes the account number and the static next account number to separate lines.
     *
     * @param bw BufferedWriter object for writing the account fields.
     * @throws IOException if an I/O error occurs
     * @since 1.0
     */
    public void save(BufferedWriter bw) throws IOException {
        bw.write(Integer.toString(accountNumber) + "\n");
        bw.write(Integer.toString(nextAccountNumber) + "\n");
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