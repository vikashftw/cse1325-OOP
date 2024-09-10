import java.net.URI;
import java.net.URISyntaxException;

public class Media {
    private String title;
    private String url;

    // Constructor
    public Media(String title, String url) {
        this.title = title;
        validateURL(url);
        this.url = url;
    }

    // Validate the URL using URI (no deprecated methods)
    private void validateURL(String url) {
        try {
            URI uri = new URI(url);
            // Ensure the URL has a scheme and is either a file or has a host
            if (uri.getScheme() == null || (uri.getHost() == null && !url.startsWith("file://"))) {
                throw new IllegalArgumentException("Invalid URL: " + url);
            }
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Invalid URL: " + url);
        }
    }

    // toString method as specified in the UML
    @Override
    public String toString() {
        return title + " (" + url + ")";
    }
}
