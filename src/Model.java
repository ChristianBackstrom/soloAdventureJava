import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Model {
    private View view;
    private Story currentStory;
    private database db;

    public Model() {
        this.view = new View();
        this.db = new database();
        this.currentStory = db.getData(1);

        view.addButton1Listener(new nextStory1());
        view.addButton2Listener(new nextStory2());
        view.addButton3Listener(new nextStory3());
        view.addButton4Listener(new nextStory4());

        view.addEditorListener(new enableEditor());
        view.addPlayerListener(new enablePlayer());
        view.addDbListener(new dbLoader());
        view.addUpdateListener(new updateDatabase());
        view.addSaveListener(new saveToDatabase());

        view.setStory(currentStory);
    }

    private class nextStory1 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            currentStory = db.getData(currentStory.getTargetID()[0]);
            view.setStory(currentStory);
        }
    }

    private class nextStory2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            currentStory = db.getData(currentStory.getTargetID()[1]);
            view.setStory(currentStory);
        }
    }

    private class nextStory3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            currentStory = db.getData(currentStory.getTargetID()[2]);
            view.setStory(currentStory);
        }
    }

    private class nextStory4 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            currentStory = db.getData(currentStory.getTargetID()[3]);
            view.setStory(currentStory);
        }
    }

    private class enableEditor implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.enableEditorMode();
            view.setEditStory(currentStory);
        }
    }

    private class enablePlayer implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.enablePlayerMode(currentStory);
        }
    }

    private class dbLoader implements ActionListener{
        public void actionPerformed(ActionEvent e){
            currentStory = db.getData(Integer.parseInt(JOptionPane.showInputDialog("write storyId of story and links you want to edit")));
            view.setEditStory(currentStory);
        }
    }
    private class saveToDatabase implements ActionListener{
        public void actionPerformed(ActionEvent e){
            currentStory = view.getSaveStory();
            db.saveToDatabase(currentStory);
        }
    }
    private class updateDatabase implements ActionListener{
        public void actionPerformed(ActionEvent e){
            currentStory = view.getUpdateStory();
            Story story = new Story(currentStory.getText(), currentStory.getChoices(), currentStory.getTargetID(), currentStory.getStoryID());
            db.updateDatabase(story);
        }
    }
}
