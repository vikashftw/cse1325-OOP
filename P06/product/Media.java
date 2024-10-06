package product;

/**
 * Represents media content that can be accessed by accounts, 
 * such as movies or videos, with associated title, URL, and points.
 * Ensures that the URL provided is valid at the time of object creation.
 * 
 * @author Vikash Mall
 * @version 0.2
 * @since 1.0
 */
public class Media {
    private String title;
    private String url;
    private int points;

    /**
     * Constructs a Media object with a specified title, URL, and points required for access.
     * Validates the URL to ensure it is properly formatted and can be converted to a valid URI.
     *
     * @param title  the title of the media
     * @param url    the URL where the media can be accessed; must be a valid, well-formed URL.
     * @param points the points required to access the media
     * @throws RuntimeException if the URL is not a valid URI or cannot be converted to a URL
     * @since 1.0
     */
    public Media(String title, String url, int points) {
        this.title = title;
        this.url = url;
        this.points = points;

        try {
            new java.net.URI(url).toURL();
        } catch(Exception e) {
            throw new RuntimeException(url + " is invalid", e);
        }
    }

    /**
     * Returns the number of points required to access the media.
     * 
     * @return the points required for access
     * @since 1.0
     */
    public int getPoints() {
        return points;
    }

    /**
     * Returns a string representation of the media object, 
     * including the title, URL, and points required.
     * 
     * @return a string representation of the media object
     * @since 1.0
     */
    @Override
    public String toString() {
        return title + " (" + url + ", " + points + " points)";
    }
}
