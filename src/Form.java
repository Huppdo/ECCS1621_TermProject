/**
 * Form.java
 * Contains fields and methods relating to the GUI of the simulation. Also contains the main method for the program.
 *
 * @since 3/30/21
 * @author Dominic Hupp, Wyatt Fisher and Will Klepinger
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form {
    // fields from the Form.form GUI
    private JTextArea Explanation;
    private JTextArea Scen1;
    private JTextArea Scen2;
    private JButton option1Button;
    private JButton option2Button;
    private JPanel panel1;

    // variable declarations
    private static Block[] options;
    private static int current;
    private static final int ENDING_RESOURCES = 9;

    /**
     * Constructor of the Form class.
     */
    public Form() {

        // set margins for textAreas
        Explanation.setMargin(new Insets(15,15,15,15));
        Scen1.setMargin(new Insets(15,15,15,15));
        Scen2.setMargin(new Insets(15,15,15,15));



        option1Button.addActionListener(new ActionListener() {
            @Override
            /**
             * Action listener of the option1Button of the GUI.
             */
            public void actionPerformed(ActionEvent e) {
                // get the next section of text to display and update the current variable and main/button texts
                current = options[current].getFirstNext();
                updateText();
                setButtonText();
            }
        });
        option2Button.addActionListener(new ActionListener() {
            @Override
            /**
             * Action listener of the option2Button of the GUI.
             */
            public void actionPerformed(ActionEvent e) {
                if (current == 100) {
                    // if the simulation is just starting up, move it to the first scenario
                    current = 0;
                } else {
                    if (current == -1) {
                        // if the simulation is at the end, let the user restart it
                        current = 0;
                    } else {
                        // if the user chose Option 2 of the scenario, go to where that option says to send the program
                        current = options[current].getSecondNext();
                    }
                }

                // update the main/button texts
                updateText();
                setButtonText();
            }
        });
    }

    /**
     * updateText method gets the text from the object at the current index of the Blocks array and sets this to the
     * scenario text that is set visible on the GUI.
     */
    private void updateText() {
        if (current > -1) {
            // if the simulation is not on the ending page, display the main text of the current Block
            Explanation.setText(options[current].getMainText());

            if (options[current] instanceof Scenario) {
                // if the current Block is a Scenario, show the options that a player can choose to use to respond
                Scen1.setText(((Scenario) options[current]).getOption1());
                Scen2.setText(((Scenario) options[current]).getOption2());
                Scen1.setVisible(true);
                Scen2.setVisible(true);
            } else {
                Scen1.setVisible(false);
                Scen2.setVisible(false);
            }
        }
    }

    /**
     * setButtonText method changes the enable and visibility of the buttons based on the value of the current variable
     * and the type of the object in the options array at the current index.
     */
    private void setButtonText() {
        if (current == -1) {
            // this occurs at the end of the simulation and allows it to be reset
            option1Button.setVisible(false);
            option1Button.setEnabled(false);
            option2Button.setVisible(true);
            option2Button.setEnabled(true);
            option2Button.setText("Reset");
        } else {
            if (options[current] instanceof Scenario) {
                // if a scenario is being displayed, the option buttons should display the option text and be enabled
                option1Button.setText("Option 1");
                option1Button.setVisible(true);
                option1Button.setEnabled(true);
                option2Button.setText("Option 2");
            } else {
                // if a scenario is not being shown, set Option 1 button invisible and show "Continue" on other button
                option1Button.setText("");
                option2Button.setText("Continue");
                option1Button.setVisible(false);
                option1Button.setEnabled(false);
            }
        }
    }

    public static void main(String[] args) {
        // variable initialization
        options = new Block[ENDING_RESOURCES + 1];
        current = 100;

        // initialize options array with different scenarios, explanations, options and resources of simulation
        options[ENDING_RESOURCES] = new Explanations(0, "Call the National Suicide Prevention Lifeline " +
                "(Lifeline) at 1-800-273-TALK (8255), or text the Crisis Text Line (text HELLO to 741741).\n" +
                "Call 911 in an emergency.\nVisit https://adaa.org/ for guidance on treatment and management of " +
                "anxiety.\n\nPress \"Continue\" to restart the simulation.");

        options[0] = new Scenario("At school, you notice your friend Katy has become irritable lately and is " +
                "struggling to focus. You have never seen her act like this. She seems nervous, but you can’t think " +
                "of anything going on at school that would be contributing to these behaviors. You know she always " +
                "seems to stress about things, but it seems worse than before. As her friend, what should you do?",
                "Ignore it. Maybe she is just nervous about a test coming up in a few weeks. ",
                1,
                "Approach her and ask if everything is going okay, as you’ve noticed she seems to be on edge.",
                5);

        options[1] = new Explanations(2, "Individuals may begin to act differently than normal and begin " +
                "to display symptoms that could stem from a mental health problem. Recognizing early symptoms is an " +
                "important first step in helping someone who is struggling with their mental health.");

        options[2] = new Scenario("The next day, Katy again appears to be struggling to focus in class " +
                "and looks like she has not slept. You are still unable to come up with a reason for her " +
                "behaviors and begin to worry that something is wrong. What should you do now?",
                "Ask Katy if she wants to hang out after school and be prepared to let her know you " +
                        "are concerned about her and offer some resources that might help.",
                3,
                "Hope that Katy comes to you to talk. You do not want to be the one to start the " +
                        "conversation on her behavioral changes.",
                4);

        options[3] = new Explanations(ENDING_RESOURCES, "Good job! Approaching someone with your concerns " +
                "might allow them to open up about the way they’ve been feeling and start the process of getting " +
                "them help. Offering resources is a great way to get the person the appropriate help.");

        options[4] = new Explanations(ENDING_RESOURCES, "People who are struggling with a mental illness " +
                "may not be willing to search for help on their own. It is important that you initiate the " +
                "conversation. Being a good mental health first aider and approaching the person and " +
                "offering possible resources can lead to a better outcome.");

        options[5] = new Explanations(6, "Good job! You noticed that something appears to be " +
                "affecting Katy’s mental health and noticed how the symptoms have worsened as of late. As " +
                "a mental health first aider, it is important to approach the person to let them know you " +
                "are concerned. Be willing to listen, judgement free.");

        options[6] = new Scenario("You approach Katy and ask if it is okay if you talk to her about what " +
                "you’ve noticed. She is a close friend of yours so she is willing to open up about what she " +
                "has been experiencing. Katy reminds you that she has always been worrisome, but lately it seems " +
                "to have gotten worse. She says she feels like she can not control her thoughts or feelings of " +
                "worry and feels anxious most of the time. What is your next step?",
                "Tell her to relax. She has nothing to worry about.",
                7,
                "Offer to look up resources that will guide her to get help for the issues she is struggling with.",
                8);

        options[7] = new Explanations(ENDING_RESOURCES, "Sometimes it is difficult to understand the thoughts " +
                "and feelings of someone struggling with a mental illness. Reaching out first would be the better " +
                "option. Guiding them in the right direction using resources would be the best option to make sure " +
                "someone like Katy gets the help they need.\n");

        options[8] = new Explanations(ENDING_RESOURCES, "Good job! Using resources to find the necessary help " +
                "for someone like Katy can be very beneficial to their mental health.\n");

        // makes the frame and attach the panel to it
        JFrame myFrame = new JFrame("Mental Health Resources Simulation");
        myFrame.setContentPane(new Form().panel1);

        // sets up what happens when the frame is closed
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the dimensions of the frame
        myFrame.setPreferredSize(new Dimension(500, 450));

        // put everything in the frame and make it visible
        myFrame.pack();
        myFrame.setVisible(true);
    }
}