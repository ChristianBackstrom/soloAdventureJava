import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class database {

    private Connection conn;

    database(){
        try {
            this.conn = DriverManager.getConnection(
                    "jdbc:mysql://" + databaseConfig.DBURL + ":" + databaseConfig.port + "/" + databaseConfig.DBname +
                            "? allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    databaseConfig.user, databaseConfig.password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Story getData(int i){
        try {
            Story story;

            String text;
            String[] choices;

            // Setup statement
            Statement stmt = this.conn.createStatement();
            Scanner tgb = new Scanner(System.in);
            int currentRoom = 1;
                // Create query and execute
                String strSelect = "select body from story where id = " + i;

                ResultSet rset = stmt.executeQuery(strSelect);

                // Loop through the result set and print
                while (rset.next()) {
                    String body = rset.getString("body");
                    System.out.println(body);
                }

                strSelect = "select description, targetId from links where storyId = " + currentRoom;

                rset = stmt.executeQuery(strSelect);
                ArrayList<Integer> storyLinks = new ArrayList();

                // Loop through the result set and print
                int rowCount = 0;
                while (rset.next()) {
                    String description = rset.getString("description");
                    int storyLink = rset.getInt("targetId");
                    storyLinks.add(storyLink);
                    System.out.println(++rowCount + " " + description);
                }

                if (rowCount == 0) {
                    System.out.println("Thanks for playing...");
                    currentRoom = 0;
                } else {
                    System.out.println("Make your choice: ");
                    int input = tgb.nextInt();
                    while (input < 1 || input > storyLinks.size()) {
                        System.out.println("Illegal choice, try again");
                        input = tgb.nextInt();
                    }
                    currentRoom = storyLinks.get(input - 1);
                }
            // Close conn and stmt
            conn.close();
            stmt.close();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

}