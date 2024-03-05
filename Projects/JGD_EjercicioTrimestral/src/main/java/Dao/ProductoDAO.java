package Dao;

import Models.ProductoBean;

import java.util.ArrayList;

public interface ProductoDAO {
    public ArrayList<ProductoBean> getProductos();
    public ProductoBean getProducto(String id);
    public boolean updateProducto(ProductoBean producto);
    public ArrayList<String> getCategorias();
}
