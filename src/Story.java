public class Story {
    private String text;
    private String[] choices;
    private int[] storyID;

    public Story(String text, String[] choices, int storyID) {
        this.text = text;
        this.choices = choices;
        this.storyID[0] = storyID;
    }

    public Story(String text, String[] choices, int[] storyID) {
        this.text = text;
        this.choices = choices;
        this.storyID = storyID;
    }

    public Story(String text, String[] choices){
        this.text = text;
        this.choices = choices;
    }

    public String getText() {
        return text;
    }

    public String[] getChoices() {
        return choices;
    }

    public String getChoice(int i) {
        return choices[i];
    }
}
