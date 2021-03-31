/**
 * Scenario.java
 * Contains fields and methods relating to the different options given in the game. Stores the two different option
 * strings and the resulting next steps after one of them is chosen.
 *
 * @since 3/30/21
 * @author Dominic Hupp, Wyatt Fisher and Will Klepinger
 */
public class Scenario extends Block{
    private String scenario;
    private String option1;
    private int goTo1;
    private String option2;
    private int goTo2;

    /**
     * Constructor of the Scenario class.
     * @param scenario The string containing the text describing the scenario.
     * @param option1 The string containing the first option the user can choose.
     * @param goTo1 The int index of the Block array that the simulator should navigate to if Option 1 is chosen.
     * @param option2 The string containing the second option the user can choose.
     * @param goTo2 The int index of the Block array that the simulator should navigate to if Option 2 is chosen.
     */
    public Scenario(String scenario, String option1, int goTo1, String option2, int goTo2) {
        this.scenario = scenario;
        this.option1 = option1;
        this.goTo1 = goTo1;
        this.option2 = option2;
        this.goTo2 = goTo2;
    }

    /**
     * Getter for the next integer of the first option of the scenario.
     * @return The int value of the next section of text to be displayed.
     */
    public int getFirstNext() {
        return goTo1;
    }

    /**
     * Getter for the next integer of the second option of the scenario.
     * @return The int value of the next section of text to be displayed.
     */
    public int getSecondNext() {
        return goTo2;
    }

    /**
     * Getter for the main text of the scenario.
     * @return The string containing the actual scenario text.
     */
    public String getMainText() {
        return scenario;
    }

    /**
     * Getter for the text of the first option of the scenario.
     * @return The string containing the text for the first option of the scenario.
     */
    public String getOption1() {
        return option1;
    }

    /**
     * Getter for the text of the second option of the scenario.
     * @return The string containing the text for the second option of the scenario.
     */
    public String getOption2() {
        return option2;
    }
}