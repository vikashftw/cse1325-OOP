package product;

import java.net.MalformedURLException;
import java.net.URL;

public class Media {
    private String title;
    private String url;
    private int points;

    public Media(String title, String url, int points) {
        this.title = title;
        this.url = validateURL(url);
        this.points = points;
    }

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

    public int getPoints() {
        return points;
    }
    @Override
    public String toString() {
        return title + " (" + url + ")" + ", " + points + " points";
    }
}
