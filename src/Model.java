import java.sql.DatabaseMetaData;

public class Model {
    private database db;
    private Story currentStory;

    public Model() {
        this.db = new database();
        this.currentStory = db.getData(1);
    }

    public void setCurrentStory(Story currentStory) {
        this.currentStory = currentStory;
    }

    public void setCurrentStory(int i){
        currentStory = db.getData(i);
    }

    public Story getCurrentStory() {
        return currentStory;
    }

    public Story getStory(int i){
        return db.getData(i);
    }

    public Story nextStory(int i) {
        currentStory = db.getData(currentStory.getTargetID()[i]);
        return currentStory;
    }

    public void saveToDB(){
        db.saveToDatabase(currentStory);
    }

    public void updateToDB(){
        db.updateDatabase(currentStory);
    }
}
