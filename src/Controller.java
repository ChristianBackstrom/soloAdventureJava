import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller {
    private View view;
    private Model model;

    public Controller() {
        this.view = new View();
        this.model = new Model();

        view.addButton1Listener(new nextStory1());
        view.addButton2Listener(new nextStory2());
        view.addButton3Listener(new nextStory3());
        view.addButton4Listener(new nextStory4());

        view.addEditorListener(new enableEditor());
        view.addPlayerListener(new enablePlayer());
        view.addDbListener(new dbLoader());
        view.addUpdateListener(new updateDatabase());
        view.addSaveListener(new saveToDatabase());

        view.setStory(model.getCurrentStory());
    }

    private class nextStory1 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.setStory(model.nextStory(0));
        }
    }

    private class nextStory2 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.setStory(model.nextStory(1));
        }
    }

    private class nextStory3 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.setStory(model.nextStory(2));
        }
    }

    private class nextStory4 implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.setStory(model.nextStory(3));
        }
    }

    private class enableEditor implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.enableEditorMode();
            view.setEditStory(model.getStory(1));
        }
    }

    private class enablePlayer implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.enablePlayerMode(model.getStory(1));
        }
    }

    private class dbLoader implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.setEditStory(model.getStory(Integer.parseInt(JOptionPane.showInputDialog("write storyId of story and links you want to edit"))));
        }
    }
    private class saveToDatabase implements ActionListener{
        public void actionPerformed(ActionEvent e){
            model.setCurrentStory(view.getSaveStory());
            model.saveToDB();
        }
    }
    private class updateDatabase implements ActionListener{
        public void actionPerformed(ActionEvent e){
            model.setCurrentStory(view.getUpdateStory());
            model.updateToDB();
        }
    }
}
