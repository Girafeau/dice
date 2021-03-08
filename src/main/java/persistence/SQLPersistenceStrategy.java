package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entities.HighScore;

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
		String request = "INSERT INTO HighScore(score) VALUES (?)";
		try {
			PreparedStatement ps = this.connection.prepareStatement(request);
			int i = 1;
			ps.setInt(i++, score);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
