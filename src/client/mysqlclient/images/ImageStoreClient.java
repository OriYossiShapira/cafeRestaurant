package client.mysqlclient.images;

import client.mysqlclient.connection.MySQLConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ImageStoreClient {

    private ImagesStore store;



    public ImageStoreClient() throws SQLException, ClassNotFoundException {
        store = new ImagesStore();
    }
    public void storeImage(String filename) throws SQLException, IOException, ClassNotFoundException {

        Connection conn = null;
        try {
            conn = MySQLConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        store.storeImage(filename);
    }

    public void showMenu(){
        Scanner scanner = new Scaner(System.in);
        String menu = "1. show images\n2. add image";
        System.out.println(menu);
        int menuSelection = scanner.nextInt();
        if(menuSelection == 1)
    }
}

