package sn.ucad.esp.glsi.tp14;

import java.sql.*;

public class Test_MySQL {
    public static String server = "localhost";
    public static String port = "3306";
    public static String database = "tp13";
    public static String user = "esp";
    public static String password = "Esp#2026";
    public static String url = "jdbc:mysql://" + server + ":" + port + "/" + database;

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM information";
            PreparedStatement ps = connection.prepareStatement(sql);
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println("Liste des messages");
                while (rs.next()) {
                    System.out.println(rs.getString("message"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}