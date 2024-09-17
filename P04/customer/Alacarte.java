package customer;

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