package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDB {

    Connection connection;

   public ProductDB(){
       try {
           connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgresdemo","postgres","admin");
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
   }

    public void save(Product product) {
     String sql="insert into product (name,type,place,warranty) values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement=connection.
                    prepareStatement(sql);
               preparedStatement.setString(1,product.getName());
               preparedStatement.setString(2,product.getType());
               preparedStatement.setString(3,product.getPlace());
               preparedStatement.setInt(4,product.getWarranty());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
