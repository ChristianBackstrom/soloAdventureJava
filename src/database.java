import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class database {

    private Connection conn;
    private Statement stmt;

    database(){
    }

    public Story getData(int i){
        Story story = null;

        String text = "";
        String[] choices;
        int[] targetID;
        int storyID = 1;

        try {

            try {
                this.conn = DriverManager.getConnection(
                        "jdbc:mysql://" + databaseConfig.DBURL + ":" + databaseConfig.port + "/" + databaseConfig.DBname +
                                "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        databaseConfig.user, databaseConfig.password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            this.stmt = this.conn.createStatement();

            // Setup statement
                // Create query and execute
                String strSelect = "select body from story where id = " + i;

                ResultSet rset = stmt.executeQuery(strSelect);

                // Loop through the result set and print
            while (rset.next())
                    text = rset.getString("body");

                strSelect = "select description, target_id, story_id from links where story_id = " + i;

                rset = stmt.executeQuery(strSelect);
                ArrayList<Integer> targetLinks = new ArrayList();
                ArrayList<String> storyDescription = new ArrayList();

                // Loop through the result set and print
                int rowCount = 0;
                while (rset.next()) {
                    String description = rset.getString("description");
                    int storyLink = rset.getInt("target_id");
                    int storyid = rset.getInt("story_id");
                    targetLinks.add(storyLink);
                    storyDescription.add(description);
                    storyID = storyid;
                }


                choices = getStringArray(storyDescription);
                targetID = getIntArray(targetLinks);

                story = new Story(text, choices, targetID, storyID);

            // Close conn and stmt
            this.conn.close();
            stmt.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return story;
    }

    public void updateDatabase(Story story){

        String text = story.getText();
        String[] choices = story.getChoices();
        int[] targetID = story.getTargetID();
        int storyID = story.getStoryID();

        try {

            try {
                this.conn = DriverManager.getConnection(
                        "jdbc:mysql://" + databaseConfig.DBURL + ":" + databaseConfig.port + "/" + databaseConfig.DBname +
                                "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                        databaseConfig.user, databaseConfig.password);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            this.stmt = this.conn.createStatement();

            // Setup statement
            // Create query and execute
            String strSelect = "UPDATE `te18`.`story` SET `id` = '" + storyID + "', `body` = '" + text + "' WHERE `id` = '" + storyID + "';";

            stmt.executeUpdate(strSelect);

            for (int i = 0; i < choices.length; i++){
                strSelect = "UPDATE `te18`.`links` SET `description` = '" + choices[i] + "', `target_id` = '" + targetID[i] + "' WHERE `story_id` = '1';";
                stmt.executeUpdate(strSelect);
            }

            // Close conn and stmt
            this.conn.close();
            stmt.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
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

    public static int[] getIntArray(ArrayList<Integer> arr){
        int inte[] = new int[arr.size()];

        for (int j = 0; j < arr.size(); j++){

            inte[j] = arr.get(j);
        }
        return inte;
    }

}