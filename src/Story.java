public class Story {
    private String text;
    private String[] choices;
    private int[] targetID;
    private int storyID;

    public Story(String text, String[] choices, int targetID) {
        this.text = text;
        this.choices = choices;
        this.targetID[0] = targetID;
    }

    public Story(String text, String[] choices, int[] targetID) {
        this.text = text;
        this.choices = choices;
        this.targetID = targetID;
    }

    public Story(String text, String[] choices, int[] targetID, int storyID) {
        this.text = text;
        this.choices = choices;
        this.targetID = targetID;
        this.storyID = storyID;
    }

    public int[] getTargetID() {
        return targetID;
    }

    public int getTargetID(int i) {
        return targetID[i];
    }

    public int getStoryID() {
        return this.storyID;
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
