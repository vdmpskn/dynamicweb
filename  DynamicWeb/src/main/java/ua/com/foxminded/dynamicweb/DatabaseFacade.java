package ua.com.foxminded.dynamicweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseFacade extends DatabaseConstants {
	private static final String db_username = "postgres";
	private static final String db_password = "1111";
	private static final String db_url = "jdbc:postgresql://localhost:5432/postgres";

	public static List<String> getBooks() {
		List<String> result = new ArrayList<String>();
		try (Connection connection = DriverManager.getConnection(db_url, db_username, db_password)) {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM books.books");
			while (resultSet.next()) {
				result.add(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}
		return result;
	}

	public static void deleteAllBooks() {
		String sql = "DELETE FROM books.books";
		try (Connection connection = DriverManager.getConnection(db_url, db_username, db_password)) {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}
	}

	public static void addBook(String name) {
		String sql = "INSERT INTO books.books (name) VALUES (?)";
		try (Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, name);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}
	}

	public static void deleteBook(String name) {
		String sql = "DELETE FROM books.books WHERE name = ?";
		try (Connection connection = DriverManager.getConnection(db_url, db_username, db_password);
				PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, name);
			statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Connection failure.");
			e.printStackTrace();
		}
	}

}