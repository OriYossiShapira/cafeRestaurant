import client.mysqlclient.connection.MySQLConnection;
import client.products.coffee.Coffee;
import client.products.coffee.ECoffeeProducts;
import client.products.meals.Meals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
        Connection connection = MySQLConnection.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cafe_meals.meals_items;");
            while (rs.next()) {

                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("description"));

            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}