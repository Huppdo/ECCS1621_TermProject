/**
 * Block.java
 * Abstract parent class for the blocks of text that are displayed by the program.
 *
 * @since 3/30/21
 * @author Dominic Hupp, Wyatt Fisher and Will Klepinger
 */
public abstract class Block {
    /**
     * Getter for the next integer of the first option of the text block.
     * @return The int value of the next text block to be displayed.
     */
    public abstract int getFirstNext();

    /**
     * Getter for the next integer of the second option of the text block.
     * @return The int value of the next text block to be displayed.
     */
    public abstract int getSecondNext();

    /**
     * Getter for the main text of the text block.
     * @return The string containing the main text of the block.
     */
    public abstract String getMainText();
}