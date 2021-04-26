/**
 * Explanations.java
 * Contains fields and methods relating to the educational explanations given in the game. Stores the explanation
 * and the int value of the text that should be displayed next.
 *
 * @since 3/30/21
 * @author Dominic Hupp, Wyatt Fisher and Will Klepinger
 */

public class Explanations extends Block{
    private int next;
    private String string;

    private String imagePath;

    /**
     * Constructor of the Explanations class.
     * @param next The int of the next item to be displayed after the explanation.
     * @param string The string containing the actual explanation text.
     */
    public Explanations(int next, String string, String imagePath) {
        this.next = next;
        this.string = string;
        this.imagePath = imagePath;
    }

    /**
     * Getter for the main text of the explanation.
     * @return The string containing the actual explanation text.
     */
    public String getMainText() {
        return string;
    }

    /**
     * Getter for the int of the next item to be displayed after the explanation.
     * @return The int value of the next section of text to be displayed.
     */
    public int getFirstNext() {
        return next;
    }

    /**
     * Getter for the int of the next item to be displayed after the explanation.
     * @return The int value of the next section of text to be displayed.
     */
    public int getSecondNext() {
        return next;
    }

    /**
     * Getter for the image of the scenario.
     * @return The string containing the actual scenario text.
     */
    public String getImagePath() {
        return imagePath;
    }
}