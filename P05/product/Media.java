package product;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Represents media content that can be accessed by accounts, 
 * such as movies or videos, with associated title, URL, and points.
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
     * Constructs a Media object with a title, URL, and points required for access.
     * 
     * @param title  the title of the media
     * @param url    the URL of the media
     * @param points the points required to access the media
     * @throws IllegalArgumentException if the URL is invalid
     * @since 1.0
     */
    public Media(String title, String url, int points) {
        this.title = title;
        this.url = validateURL(url);
        this.points = points;
    }

    /**
     * Validates the media URL and ensures it is either a valid URL or a file URL.
     * 
     * @param url the URL to validate
     * @return the validated URL if valid
     * @throws IllegalArgumentException if the URL is invalid
     * @since 1.0
     */
    private String validateURL(String url) {
        try {
            URL validUrl = new URL(url);
            if (validUrl.getProtocol().equals("file") || validUrl.getHost() != null) {
                return url;
            } else {
                throw new IllegalArgumentException("Invalid URL: " + url);
            }
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid URL: " + url);
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
