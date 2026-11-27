/*
 * ImagePixeler                                             27/11/2026
 * Jules ROUMEJON                            no copyright nor copyleft
 */
package asciivisuals.image;

import java.io.IOException;


/**
 * Defines a contract for extracting pixels ARGB data from an image file.
 *
 * @author Jules Roumejon
 */
public interface ImagePixeler {

    /**
     * Get the set image's file's path
     *
     * @return The set path
     */
    String getPath();

    /**
     * Change the actual image's file's path by a new one
     *
     * @param imagePath The new image's file's path
     */
    void changePath(String imagePath) throws IllegalArgumentException;

    /**
     * Get all pixels of the set image in the int ARGB format
     *
     * @return the pixels of the image row by row
     * @throws IOException if the file at the set path can't be read as an image
     */
    int[] getPixels() throws IOException;
}
