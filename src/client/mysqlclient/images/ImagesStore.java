package client.mysqlclient.images;

import client.mysqlclient.connection.MySQLConnection;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.imageio.ImageIO;
import java.util.List;
import java.util.ArrayList;

public class ImagesStore {
    private static final String INSERT_SQL = "INSERT INTO images (image_data) VALUES (?))";
    private static final String SELECT_SQL = "SELECT * FROM images";

    private final Connection conn;

    public ImagesStore( ) throws SQLException, ClassNotFoundException {
        this.conn = MySQLConnection.getConnection();
    }

    public void storeImage(String filename) throws IOException, SQLException {

        File input = new File(filename);
        BufferedImage image = ImageIO.read(input);

        File output = new File("output.jpg");
        ImageIO.write(image, "jpg", output);

        PreparedStatement stmt = conn.prepareStatement(INSERT_SQL);
        stmt.setString(1, "output.jpg");
        stmt.executeUpdate();
    }

    public List<String> getImages(){
        List<String> imageList = new ArrayList<String>();
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(SELECT_SQL);
            while(rs.next()){
                String imageData = rs.getString("image_data");
                imageList.add(imageData);
            }
        }catch(SQLException ex){

        }
        return imageList;
    }
}

