package gb.junior.Webinar_3_serialization_plus_jdbc.homework;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBHandler {

    private static final Properties properties = setProps();
    private static final String URL = properties.getProperty("db.url");
    private static final String LOGIN = properties.getProperty("db.login");
    private static final String PASSWORD = properties.getProperty("db.password");

    public static boolean deleteAll(String title) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from junior_test." + title);
            int countResult = 0;
            while (resultSet.next()) countResult++;

            return countResult > 0 && statement.execute("delete from junior_test." + title);
        } catch (SQLException e) {
            throw new RuntimeException("deleteAll failed >>> " + e);
        }
    }

    public static void updateById(String title, int id, String newName, String newSurname) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {


            int countResult = 0;
            ResultSet resultSet = statement.executeQuery("select * from junior_test." + title);
            while (resultSet.next()) {
                countResult++;
            }
            resultSet.close();

            if (countResult >= id && id != 0) {
                PreparedStatement updateEXP = connection.prepareStatement("update junior_test." + title
                        + " set `firstname` = '" + newName + "',"
                        + " `surname` = '" + newSurname + "'"
                        + " where `id` = ? ");

                updateEXP.setInt(1, id);
                updateEXP.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(String.format("Table: %s ID: %d EXCEPTION >>> %s", title, id, e.getMessage()));
        }
    }

    public static void insertData(String title, int id, String name, String surn, int age) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "INSERT INTO junior_test." + title
                    + " (`id`,`firstname`,`surname`,`age`) VALUES "
                    + "(" + id + ", '" + name + "', '" + surn + "', " + age + ");";
            statement.execute(sql);

        } catch (SQLException e) {
            throw new RuntimeException("insert is broken >>> " + e);
        }
    }

    public static void readTable(String title) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from junior_test." + title);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(3) +
                        " " + resultSet.getString(2) +
                        " " + resultSet.getInt(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException("read table is broken >>>" + e);
        }
    }

    public static boolean createTable(String title) {
        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE junior_test." + title + "(" +
                    " `id` INT NOT NULL," +
                    " `firstname` VARCHAR(45) NULL," +
                    " `surname` VARCHAR(45) NULL," +
                    " `age` INT NULL," +
                    " PRIMARY KEY(`id`))";

            return statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException("createTable failed >>> " + e);
        }
    }

    private static Properties setProps() {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream("Junior/Junior/src/main/resources/db.config")) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("db.config not found: " + e);
        }
        return prop;
    }
}
