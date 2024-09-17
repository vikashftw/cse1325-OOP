package customer;

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
