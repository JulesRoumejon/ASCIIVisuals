/*
 * FormattedImagePixeler                                     27/11/2026
 * Jules ROUMEJON                            no copyright nor copyleft
 */
package asciivisuals.image;

/**
 * Extends {@link ImagePixeler} for implementations limited
 * to specific image file formats or extensions.
 *
 * @author Jules Roumejon
 */
public interface FormattedImagePixeler extends ImagePixeler {

    /**
     * Verify if a filepath has a certain extension
     *
     * @param imagePath the file's path we want to verify the extension of
     * @return <ul>
     *             <li><b>true</b> if the file extension matches the expected type</li>
     *             <li><b>false</b> if it doesn't</li>
     *         </ul>
     */
    boolean isPathMatching(String imagePath);
}