package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import product.Media;

/**
 * Represents an Unlimited account that allows unlimited access to media without point deduction.
 * 
 * @author Vikash Mall
 * @version 1.0
 * @since 1.0
 */
public class Unlimited extends Account {

    /**
     * Constructs an Unlimited account with a unique account number.
     * Calls the superclass constructor to initialize the account.
     * 
     * @since 1.0
     */
    public Unlimited() {
        super();
    }

    /**
     * Constructs an Unlimited account by reading values from a BufferedReader.
     * Calls the superclass constructor to initialize the account fields.
     *
     * @param br BufferedReader object for reading the account fields.
     * @throws IOException if an I/O error occurs
     * @since 1.0
     */
    public Unlimited(BufferedReader br) throws IOException {
        super(br);
    }

    /**
     * Saves the Unlimited account fields to a file using the provided BufferedWriter.
     * Calls the superclass save method to handle the base fields.
     *
     * @param bw BufferedWriter object for writing the account fields.
     * @throws IOException if an I/O error occurs
     * @since 1.0
     */
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
    }

    /**
     * Plays the media for an Unlimited account without deducting any points.
     * 
     * @param media the media to be played
     * @return a string indicating the media is being played
     * @since 1.0
     */
    @Override
    public String play(Media media) {
        return "Playing " + media.toString();
    }
}
