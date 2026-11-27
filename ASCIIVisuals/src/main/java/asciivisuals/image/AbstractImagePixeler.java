/*
 * AbstractImagePixeler                                     27/11/2026
 * Jules ROUMEJON                            no copyright nor copyleft
 */
package asciivisuals.image;

/**
 * Provides a base implementation of {@link ImagePixeler} that manages the image file path.
 * Subclasses must implement the actual pixel extraction logic.
 *
 * @author Jules Roumejon
 */
public abstract class AbstractImagePixeler implements ImagePixeler {

    /** The image's file's path */
    private String path;

    /**
     * Create a new ImagePixeler with the specified image's file's path
     * @param imagePath the image's file's path
     */
    public AbstractImagePixeler(String imagePath) {
        this.path = imagePath;
    }

    public String getPath() {
        return path;
    }

    /**
     * Change the actual image's file's path by a new one
     *
     * @param imagePath The new image's file's path
     */
    protected void setPath(String imagePath) {
        this.path = imagePath;
    }

    /**
     * Get a String from an ImagePixeler
     *
     * @return The name of the object plus its path
     */
    @Override
    public String toString() {
        return "ImagePixeler, path: " + path;
    }
}