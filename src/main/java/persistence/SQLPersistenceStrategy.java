package persistence;

import entities.HighScore;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLPersistenceStrategy implements PersistenceStrategy {

    private Connection connection;

    public SQLPersistenceStrategy(String url, String login, String password) {
        try {
            this.connection = DriverManager.getConnection(url, login, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void persist(int score) {

    }

    @Override
    public void load() {
        String request = "SELECT * FROM HighScore";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet set = statement.executeQuery(request);
            List<Integer> scores = new ArrayList<>();
            while (set.next()) {
                scores.add(set.getInt("score"));
            }
            HighScore.getInstance().setScores(scores);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
