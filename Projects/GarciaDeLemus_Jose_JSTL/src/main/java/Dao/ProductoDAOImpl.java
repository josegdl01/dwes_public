package Dao;

import BBDD.ConnectionBBDD;
import Models.ProductoBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAOImpl implements ProductoDAO {

  static final Logger log = LoggerFactory.getLogger(ProductoDAOImpl.class);

  @Override
  public ArrayList<ProductoBean> getProductos() {
    ArrayList<ProductoBean> productos = new ArrayList<>();
    ProductoBean producto = null;
    try {
      String sentence = "SELECT * FROM products";
      PreparedStatement preparedStatement =
          ConnectionBBDD.getConnection().prepareStatement(sentence);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        producto =
            new ProductoBean(
                resultSet.getString("productCode"),
                resultSet.getString("productName"),
                resultSet.getString("productLine"),
                resultSet.getString("quantityInStock"),
                resultSet.getString("buyPrice"));
        productos.add(producto);
      }

    } catch (SQLException s) {
      log.error(s.toString());
    }
    return productos;
  }

  @Override
  public ProductoBean getProducto(String id) {
    ProductoBean producto = null;
    try {
      String sentence = "SELECT * FROM products WHERE productCode = ?";
      PreparedStatement preparedStatement =
          ConnectionBBDD.getConnection().prepareStatement(sentence);
      preparedStatement.setString(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        producto =
            new ProductoBean(
                resultSet.getString("productCode"),
                resultSet.getString("productName"),
                resultSet.getString("productLine"),
                resultSet.getString("quantityInStock"),
                resultSet.getString("buyPrice"));
      }
    } catch (SQLException s) {
      log.error(s.toString());
    }
    return producto;
  }

  @Override
  public ArrayList<String> getCategorias() {
    ArrayList<String> categorias = new ArrayList<>();
    String categoria = null;
    try {
      String query = "SELECT * FROM productlines";
      PreparedStatement preparedStatement = ConnectionBBDD.getConnection().prepareStatement(query);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        categoria = resultSet.getString("productLine");
        categorias.add(categoria);
      }

    } catch (SQLException s) {
      log.error(toString());
    }
    return categorias;
  }

  @Override
  public boolean updateProducto(ProductoBean producto) {
    boolean correcto = false;
    try {
      String sentence =
          "UPDATE products SET productName =?,productLine=?,quantityInStock=?,buyPrice=? WHERE productCode = ?";
      PreparedStatement preparedStatement =
          ConnectionBBDD.getConnection().prepareStatement(sentence);
      preparedStatement.setString(1, producto.getNombre());
      preparedStatement.setString(2, producto.getCategoria());
      preparedStatement.setString(3, producto.getStock());
      preparedStatement.setString(4, producto.getPrecio());
      preparedStatement.setString(5, producto.getCodigo());
      preparedStatement.executeUpdate();
      correcto = true;
    } catch (SQLException s) {
      log.error(s.toString());
    }
    return correcto;
  }
}
