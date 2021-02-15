import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View extends JFrame {

    private JMenuBar menuBar;
    private JMenuItem player;
    private JMenuItem editor;

    private JPanel panel;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextField linkDes1;
    private JTextField linkDes2;
    private JTextField linkDes3;
    private JTextField linkDes4;
    private JTextField linkDescriptions;
    private JTextField storyDescription;
    private JTextField targetId1;
    private JTextField targetId2;
    private JTextField targetId3;
    private JTextField targetId4;
    private Dimension dimension;

    View(){
        this.dimension = new Dimension(900, 26);

        this.panel = new JPanel();

        menuAdder();
        this.panel.add(menuBar);
        this.setJMenuBar(menuBar);

        this.textArea1 = new JTextArea(2,88);
        this.button1 = new JButton();
        this.button2 = new JButton();
        this.button3 = new JButton();
        this.button4 = new JButton();

        this.button1.setPreferredSize(dimension);
        this.button2.setPreferredSize(dimension);
        this.button3.setPreferredSize(dimension);
        this.button4.setPreferredSize(dimension);

        this.linkDes1 = new JTextField(70);
        this.linkDes2 = new JTextField(70);
        this.linkDes3 = new JTextField(70);
        this.linkDes4 = new JTextField(70);

        this.targetId1 = new JTextField(10);
        this.targetId2 = new JTextField(10);
        this.targetId3 = new JTextField(10);
        this.targetId4 = new JTextField(10);

        this.linkDescriptions = new JTextField("here are your choices", 80);
        this.storyDescription = new JTextField("this is where the story describes", 80);
        this.linkDescriptions.setEditable(false);
        this.storyDescription.setEditable(false);

        this.textArea1.setLineWrap(true);
        this.textArea1.setEditable(false);

        this.panel.add(this.storyDescription);
        this.panel.add(this.textArea1);
        this.panel.add(this.button1);
        this.panel.add(this.button2);
        this.panel.add(this.button3);
        this.panel.add(this.button4);
        this.panel.add(this.linkDescriptions);
        this.panel.add(this.linkDes1);
        this.panel.add(this.targetId1);
        this.panel.add(this.linkDes2);
        this.panel.add(this.targetId2);
        this.panel.add(this.linkDes3);
        this.panel.add(this.targetId3);
        this.panel.add(this.linkDes4);
        this.panel.add(this.targetId4);

        this.ButtonVisible(false);
        this.TextfieldVisible(false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);

        this.add(this.panel);
        this.setVisible(true);
    }

    private void menuAdder(){
        this.menuBar = new JMenuBar();
        this.editor = new JMenuItem("editor");
        this.player = new JMenuItem("player");

        this.menuBar.add(this.editor);
        this.menuBar.add(this.player);
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

    public void ButtonVisible(boolean b){
        this.button1.setVisible(b);
        this.button2.setVisible(b);
        this.button3.setVisible(b);
        this.button4.setVisible(b);
    }

    public void TextfieldVisible(boolean b){
        this.linkDes1.setVisible(b);
        this.linkDes2.setVisible(b);
        this.linkDes3.setVisible(b);
        this.linkDes4.setVisible(b);
        this.linkDescriptions.setVisible(b);
        this.storyDescription.setVisible(b);
        this.targetId1.setVisible(b);
        this.targetId2.setVisible(b);
        this.targetId3.setVisible(b);
        this.targetId4.setVisible(b);
    }

    public void setStory(Story story){
        this.ButtonVisible(false);

        this.textArea1.setText(story.getText());
        this.choices(story);
    }

    public Story getStory(){
        String story = this.textArea1.getText();
        ArrayList<String> choices = new ArrayList<>();
        ArrayList<Integer> targetId = new ArrayList<>();


        if (this.button1.isVisible()){
            choices.add(this.linkDes1.getText());
            targetId.add(Integer.parseInt(this.targetId1.getText()));

            if (this.button2.isVisible()){
                choices.add(this.linkDes2.getText());
                targetId.add(Integer.parseInt(this.targetId2.getText()));

                if (this.button3.isVisible()){
                    choices.add(this.linkDes3.getText());
                    targetId.add(Integer.parseInt(this.targetId3.getText()));

                    if (this.button4.isVisible()){
                        choices.add(this.linkDes4.getText());
                        targetId.add(Integer.parseInt(this.targetId4.getText()));

                    }
                }
            }
        }

        String[] choice = getStringArray(choices);
        int[] targetiD = getIntArray(targetId);

        return new Story(story, choice, targetiD);
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

    public static int[] getIntArray(ArrayList<Integer> arr)
    {

        // declaration and initialise String Array
        int str[] = new int[arr.size()];

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
    void addEditorListener(ActionListener listenForLoadListener) { this.editor.addActionListener(listenForLoadListener); }
    void addPlayerListener(ActionListener listenForLoadListener) { this.player.addActionListener(listenForLoadListener); }

    public void enableEditorMode(){
        this.textArea1.setEditable(true);
        ButtonVisible(false);

        TextfieldVisible(true);
    }

    public void enablePlayerMode(Story story){
        this.textArea1.setEditable(true);
        choices(story);

        TextfieldVisible(false);
    }
}