package customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import product.Media;

/**
 * Represents an Alacarte account where media access is based on points.
 * Users must have enough points to play media, and points are deducted upon use.
 * 
 * @author Vikash Mall
 * @version 1.0
 * @since 1.0
 */
public class Alacarte extends Account {
    private int pointsRemaining = 0;

    /**
     * Constructs an Alacarte account with a unique account number and initial points.
     * Calls the superclass constructor to initialize the account.
     * 
     * @since 1.0
     */
    public Alacarte() {
        super();
    }

    /**
     * Constructs an Alacarte account by reading values from a BufferedReader.
     * Calls the superclass constructor to initialize the account fields and reads pointsRemaining.
     *
     * @param br BufferedReader object for reading the account fields.
     * @throws IOException if an I/O error occurs
     * @since 1.0
     */
    public Alacarte(BufferedReader br) throws IOException {
        super(br);
        this.pointsRemaining = Integer.parseInt(br.readLine());
    }

    /**
     * Saves the Alacarte account fields to a file using the provided BufferedWriter.
     * Calls the superclass save method to handle the base fields and then writes pointsRemaining.
     *
     * @param bw BufferedWriter object for writing the account fields.
     * @throws IOException if an I/O error occurs
     * @since 1.0
     */
    public void save(BufferedWriter bw) throws IOException {
        super.save(bw);
        bw.write(Integer.toString(pointsRemaining) + "\n");
    }

    /**
     * Adds points to the Alacarte account.
     * 
     * @param points the number of points to add to the account
     * @since 1.0
     */
    public void buyPoints(int points) {
        pointsRemaining += points;
    }

    /**
     * Returns the number of points remaining in the Alacarte account.
     * 
     * @return the number of points remaining
     * @since 1.0
     */
    public int getPointsRemaining() {
        return pointsRemaining;
    }

    /**
     * Plays the media if there are enough points in the account.
     * Deducts the required points from the account.
     * 
     * @param media the media to be played
     * @return a message indicating whether the media is being played or if more points are needed
     * @since 1.0
     */
    @Override
    public String play(Media media) {
        int mediaPoints = media.getPoints();

        if (pointsRemaining >= mediaPoints) {
            pointsRemaining -= mediaPoints;
            return "Playing " + media.toString();
        } else {
            return "Buy more points: Requires " + mediaPoints + " points, you have " + pointsRemaining;
        }
    }
}