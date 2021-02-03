import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class View extends JFrame {

    private JPanel panel;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private int[] targetID;

    View(){
        this.panel = new JPanel();
        this.textArea1 = new JTextArea(2,88);
        this.button1 = new JButton();
        this.button2 = new JButton();
        this.button3 = new JButton();
        this.button4 = new JButton();

        this.textArea1.setLineWrap(true);
        this.button1.setVisible(false);
        this.button2.setVisible(false);
        this.button3.setVisible(false);
        this.button4.setVisible(false);

        this.panel.add(this.textArea1);

        this.panel.add(this.button1);
        this.panel.add(this.button2);
        this.panel.add(this.button3);
        this.panel.add(this.button4);

        this.disableButton();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);

        this.add(this.panel);
        this.setVisible(true);
    }

    public void choices(Story story){
        for (int i = 0; i < story.getChoices().length; i++){
            if (i == 0){
                this.button1.setVisible(true);
                this.button1.setText(story.getChoice(i));
            }
            if (i == 1) {
                this.button2.setVisible(true);
                this.button2.setText(story.getChoice(i));
            }
            if (i == 2){
                this.button3.setVisible(true);
                this.button3.setText(story.getChoice(i));
            }
            if (i == 3){
                this.button4.setVisible(true);
                this.button4.setText(story.getChoice(i));
            }
        }
    }

    public void disableButton(){
        this.button1.setVisible(false);
        this.button2.setVisible(false);
        this.button3.setVisible(false);
        this.button4.setVisible(false);
    }

    public void setStory(Story story){
        this.disableButton();

        this.textArea1.setText(story.getText());
        this.choices(story);
        this.targetID = story.getTargetID();
    }

    public Story getStory(){
        String story = this.textArea1.getText();
        ArrayList<String> choices = new ArrayList<String>();


        if (this.button1.isVisible()){
            choices.add(this.button1.getText());

            if (this.button2.isVisible()){
                choices.add(this.button2.getText());

                if (this.button3.isVisible()){
                    choices.add(this.button3.getText());

                    if (this.button4.isVisible()){
                        choices.add(this.button4.getText());

                    }
                }
            }
        }

        String[] choice = getStringArray(choices);

        return new Story(story, choice);
    }

    public static String[] getStringArray(ArrayList<String> arr)
    {

        // declaration and initialise String Array
        String str[] = new String[arr.size()];

        // ArrayList to Array Conversion
        for (int j = 0; j < arr.size(); j++) {

            // Assign each value to String array
            str[j] = arr.get(j);
        }

        return str;
    }

    void addButton1Listener(ActionListener listenForLoadListener) { this.button1.addActionListener(listenForLoadListener); }
    void addButton2Listener(ActionListener listenForLoadListener) { this.button2.addActionListener(listenForLoadListener); }
    void addButton3Listener(ActionListener listenForLoadListener) { this.button3.addActionListener(listenForLoadListener); }
    void addButton4Listener(ActionListener listenForLoadListener) { this.button4.addActionListener(listenForLoadListener); }
}