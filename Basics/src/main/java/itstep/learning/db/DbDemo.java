package itstep.learning.db;

import itstep.learning.ConsoleColors;

import java.sql.*;
import java.util.Random;

public class DbDemo {

    private Connection connection;

    public void Connection() {
        if (this.connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                System.err.println("ClassNotFoundException: " + e.getMessage());
                return;
            }
            try {
                this.connection = DriverManager.getConnection(
                        "jdbc:mysql://sql.freedb.tech:3306/freedb_java_011",
                        "freedb_user_011", "?ju5DjpebGQ@xPc"
                );
            } catch (SQLException e) {
                System.err.println("ConnectionError: : " + e.getMessage());
                return;
            }
            System.out.println(ConsoleColors.GREEN + "Connection OK" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.GREEN + "Connection established" + ConsoleColors.RESET);
        }
    }

    public void run() {
        Connection();

        String sql = "CREATE TABLE IF NOT EXISTS rands ( id CHAR(36) PRIMARY KEY, num INT, str VARCHAR(32) ) " +
                "ENGINE=INNODB DEFAULT CHARSET=utf8 ";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("CREATE error: " + e.getMessage());
            return;
        }
        System.out.println("CREATE OK");

        Random random = new Random();
        //                             параметры: 1  2
        sql = "INSERT INTO rands VALUES ( UUID(), ?, ? )";   // подготовленный запрос - с параметрами
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            // на место первого "?" ставим число
            preparedStatement.setInt(1, random.nextInt(1000));  // !! отсчет параметров начинается с 1 (не с 0)
            // на место второго - строку
            preparedStatement.setString(2, "str" + random.nextInt(1000));
            // после заполнения всех параметров выполняем запрос
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("INSERT error: " + ex.getMessage());
            return;
        }
        System.out.println("INSERT OK");
    }

    public void selectRowsByString(String string) {
        if (this.connection != null) {
            String sql = "SELECT id, num, str FROM rands WHERE str LIKE CONCAT('%', ?, '%')";
            try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
                preparedStatement.setString(1, string);
                ResultSet res = preparedStatement.executeQuery();
                while (res.next()) {
                    System.out.println(res.getString(1) + " " + res.getInt(2) + " " + res.getString(3));
                }
                res.close();
            } catch (SQLException ex) {
                System.err.println("SELECT error: " + ex.getMessage());
                return;
            }
        } else {
            System.out.println(ConsoleColors.RED + "Connection not established!" + ConsoleColors.RESET);
        }
    }

    public void selectRowsByInt(int value) {
        if (this.connection != null) {
            String sql = "SELECT id, num, str FROM rands WHERE num < ? ";
            try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, value);
                ResultSet res = preparedStatement.executeQuery();
                while (res.next()) {
                    System.out.println(res.getString(1) + " " + res.getInt(2) + " " + res.getString(3));
                }
                res.close();
            } catch (SQLException ex) {
                System.err.println("SELECT error: " + ex.getMessage());
                return;
            }
        } else {
            System.out.println(ConsoleColors.RED + "Connection not established!" + ConsoleColors.RESET);
        }
    }

    public void showAllRows() {
        // запросы с возвратом результата
        if (this.connection != null) {
            String sql = "SELECT id, num, str FROM rands";
            try (Statement statement = connection.createStatement()) {
                ResultSet res = statement.executeQuery(sql);
                while (res.next()) {  // ~fetch  ~Read
                    System.out.println(res.getString(1) + " " + res.getInt(2) + " " + res.getString(3));
                }
                res.close();
            } catch (SQLException ex) {
                System.err.println("SELECT error: " + ex.getMessage());
                return;
            }
        } else {
            System.out.println(ConsoleColors.RED + "Connection not established!" + ConsoleColors.RESET);
        }
    }
}
