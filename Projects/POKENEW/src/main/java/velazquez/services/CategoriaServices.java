package velazquez.services;

import velazquez.models.Categoria;

import java.util.List;

public interface CategoriaServices {
    public void deleteCategoria(Categoria categoria);
    public void insertCategoria(Categoria categoria);
    public Categoria updateCategoria(Categoria categoria);
    public Categoria selectCategoria(Long id);
    public List<Categoria> selectAllCategorias();
}
