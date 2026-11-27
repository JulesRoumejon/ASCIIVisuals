/*
 * JPEGPixeler                                              27/11/2026
 * Jules ROUMEJON                            no copyright nor copyleft
 */
package asciivisuals.image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Extracts pixels ARGB data from JPEG format images.
 *
 * @author Jules Roumejon
 */
public class JPEGPixeler extends AbstractImagePixeler implements FormattedImagePixeler {

    /**
     * Create a new JPEGPixeler with the specified image's file's path
     *
     * @param imagePath the image's file's path
     * @throws IllegalArgumentException if the file isn't a .jpeg or a .jpg
     */
    public JPEGPixeler(String imagePath) throws IllegalArgumentException {
        super(imagePath);
        if (!isPathMatching(imagePath)) {
            throw new IllegalArgumentException("Image file set was not a .jpeg or .jpg file : " + imagePath);
        }
    }

    /**
     * {@inheritDoc}
     * @throws IllegalArgumentException if the file isn't a .jpeg or a .jpg
     */
    public void changePath(String imagePath) throws IllegalArgumentException {
        if (isPathMatching(imagePath)) {
            super.setPath(imagePath);
        } else {
            throw new IllegalArgumentException("Image file set was not a .jpeg or .jpg file : " + imagePath);
        }

    }

    /**
     * {@inheritDoc}
     * @throws IOException if the file at the set path can't be read as an image
     */
    public int[] getPixels() throws IOException {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(super.getPath()));
            if (image == null) {
                throw new IOException("Image file set can't be read : " + super.getPath());
            }
        } catch (IOException e) {
            throw new IOException("Image file set was not found : " + super.getPath());
        }

        int width,
                height;
        int[] pixels;
        width = image.getWidth();
        height = image.getHeight();
        pixels = new int[width*height];

        return image.getRGB(0, 0, width, height, pixels, 0, width);
    }

    public boolean isPathMatching(String imagePath) {
        return imagePath.toLowerCase().matches(".*\\.jpe?g$");
    }

    /**
     * Get a String from a JPEGPixeler
     *
     * @return the format of the Pixeler plus superclass' .toString()
     */
    @Override
    public String toString() {
        return "jpeg/jpg format " + super.toString();
    }
}
