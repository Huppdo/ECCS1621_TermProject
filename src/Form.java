import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form {
    private JTextArea Explanation;
    private JTextArea Scen1;
    private JTextArea Scen2;
    private JButton option1Button;
    private JButton option2Button;
    private JPanel panel1;

    private static Block[] options;
    private static int current;
    private static final int ENDING_RESOURCES = 9;

    public Form() {
        option1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current = options[current].getFirstNext();

                updateText();

                setButtonText();
            }
        });
        option2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (current == 100) {
                    current = 0;
                } else {
                    if (current == -1) {
                        current = 0;
                    } else {
                        current = options[current].getSecondNext();
                    }
                }
                updateText();

                setButtonText();
            }
        });
    }

    private void updateText() {
        if (current > -1) {

            Explanation.setText(options[current].getMainText());

            if (options[current] instanceof Scenario) {
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

    private void setButtonText() {
        if (current == -1) {
            option1Button.setVisible(false);
            option1Button.setEnabled(false);
            option2Button.setVisible(true);
            option2Button.setEnabled(true);
            option2Button.setText("Reset");
        } else {
            if (options[current] instanceof Scenario) {
                option1Button.setText("Option 1");
                option1Button.setVisible(true);
                option1Button.setEnabled(true);
                option2Button.setText("Option 2");
            } else {
                option1Button.setText("");
                option2Button.setText("Continue");
                option1Button.setVisible(false);
                option1Button.setEnabled(false);
            }
        }
    }


    public static void main(String[] args) {
        options = new Block[ENDING_RESOURCES + 1];
        current = 100;

        options[ENDING_RESOURCES] = new Explanations(0, "Call the National Suicide Prevention Lifeline (Lifeline) at 1-800-273-TALK (8255), or text the Crisis Text Line (text HELLO to 741741)\n" +
                "Call 911 in an emergency \n" +
                "Visit https://adaa.org/ for guidance on treatment and management of anxiety");

        options[0] = new Scenario("At school, you notice your friend Katy has become irritable lately and is struggling to focus."
                +" You have never seen her act like this. She seems nervous, but you can’t think of anything going on at school "
                +" that would be contributing to these behaviors. You know she always seems to stress about things, but it seems worse than before."+
                " As her friend, what should you do?",
                "Ignore it. Maybe she is just nervous about a test coming up in a few weeks. ",
                1,
                "Approach her and ask if everything is going okay, as you’ve noticed she seems to be on edge. ",
                5);

        options[1] = new Explanations(2, "Individuals may begin to act differently than normal and begin to "+
                "display symptoms that could stem from a mental health problem."
                +" Recognizing early symptoms is an important first step in helping someone who is struggling with their mental health.");

        options[2] = new Scenario("The next day, Katy again appears to be struggling to focus in class "+
                "and looks like she has not slept. You are still unable to come up with a reason for her "+
                "behaviors and begin to worry that something is wrong. What should you do now?",
                "Ask Katy if she wants to hang out after school and be prepared to let her know you are concerned"
                        +" about her and offer some resources that might help.",
                3,
                "Hope that Katy comes to you to talk. You do not want to be the one to start the conversation on her behavioral changes.",
                4
        );

        options[3] = new Explanations(ENDING_RESOURCES, "Good job! Approaching someone with your concerns might allow them"
                + " to open up about the way they’ve been feeling and start the process of getting them help."
                + "Offering resources is a great way to get the person the appropriate help.");

        options[4] = new Explanations(ENDING_RESOURCES, "People who are struggling with a mental illness may not be willing to search for help "
                +"on their own. It is important that you initiate the conversation. "
                + "Being a good mental health first aider and approaching the person and offering possible resources can lead to a better outcome.");

        options[5] = new Explanations(6, "Good job! You noticed that something appears to be affecting Katy’s"+
                " mental health and noticed how the symptoms have worsened as of late. As a mental health first aider," +
                " it is important to approach the person to let them know you are concerned. Be willing to listen, judgement free.");

        options[6] = new Scenario("You approach Katy and ask if it is okay if you talk to her about what you’ve"+
                " noticed. She is a close friend of yours so she is willing to open up about what she has been"+
                " experiencing. Katy reminds you that she has always been worrisome, but lately it seems to have gotten"+
                " worse. She says she feels like she can not control her thoughts or feelings of worry and feels"+
                " anxious most of the time. What is your next step?",
                "Tell her to relax. She has nothing to worry about. ",
                7,
                "Offer to look up resources that will guide her to get help for the issues she is struggling with.",
                8);

        options[7] = new Explanations(ENDING_RESOURCES, "Sometimes it is difficult to understand the thoughts and feelings"+
                " of someone struggling with a mental illness. Reaching out first would be the better option. Guiding"+
                " them in the right direction using resources would be the best option to make sure someone like"+
                "Katy gets the help they need. \n");

        options[8] = new Explanations(ENDING_RESOURCES, "Good job! Using resources to find the necessary help for"+
                " someone like Katy can be very beneficial to their mental health.\n");

        JFrame myFrame = new JFrame("Mental Health Resources Simulation"); //Makes the frame
        myFrame.setContentPane(new Form().panel1); //attaches the panel1 to the frame

        //sets up what happens when the frame is closed
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.setPreferredSize(new Dimension(450, 450));

        myFrame.pack(); //put everything in the frame
        myFrame.setVisible(true); //allows us to see the frame
    }
}
