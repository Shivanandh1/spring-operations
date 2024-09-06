package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    List<Product> getAll(){
          List<Product> productList=new ArrayList<>();

          String sql="select name,type,place,warranty from product";

        try {
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet= preparedStatement.executeQuery();
          while(resultSet.next()){
              Product product=new Product();

              product.setName(resultSet.getString(1));
              product.setType(resultSet.getString(2));
              product.setPlace(resultSet.getString(3));
              product.setWarranty(resultSet.getShort(4));

              productList.add(product);
          }

    } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return productList;
    }


}
