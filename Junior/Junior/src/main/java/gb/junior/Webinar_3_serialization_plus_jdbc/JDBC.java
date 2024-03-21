package gb.junior.Webinar_3_serialization_plus_jdbc;


import java.sql.*;

public class JDBC {

    static final String JDBC_DRIVER = "org.h2.Driver";
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test")){
            Class.forName(JDBC_DRIVER);

            acceptConnection(connection);
        } catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    private static void acceptConnection(Connection connection) throws SQLException{
        createTable(connection);
        insertData(connection);

        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery("select id, name from person");

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                System.out.println("id = " + id + " name = " + name);
            }


        }
    }

    private static void insertData(Connection connection) throws SQLException {
        try(Statement statement = connection.createStatement()){
            int affectedRows = statement.executeUpdate("""
                    insert into person(id, name) values
                    (1, 'igor'),
                    (1, 'Person #2'),
                    (1, 'John'),
                    (1, 'Alex'),
                    (1, 'Peter')
                    """);

            System.out.println("INSERT: " + affectedRows + " affectedRows");
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        try(Statement statement = connection.createStatement()){
            statement.execute("""
                    CREATE TABLE person (
                      id bigint,
                      name varchar(256)
                    )
                    """);
        }
    }
}
