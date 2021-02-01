public class Story {
    private String text;
    private String[] choices;

    public Story(String text, String[] choices) {
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
