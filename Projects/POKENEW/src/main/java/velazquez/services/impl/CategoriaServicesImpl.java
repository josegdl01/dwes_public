package velazquez.services.impl;

import velazquez.dao.CategoriaDAO;
import velazquez.dao.impl.CategoriaDAOImpl;
import velazquez.models.Categoria;
import org.hibernate.Session;
import velazquez.services.CategoriaServices;

import java.util.List;

public class CategoriaServicesImpl implements CategoriaServices {

    CategoriaDAO catDAO;

    public CategoriaServicesImpl(Session session){
        this.catDAO = new CategoriaDAOImpl(session);
    }


    @Override
    public void deleteCategoria(Categoria categoria) {

    }

    @Override
    public void insertCategoria(Categoria categoria) {
        if(categoria != null && categoria.getId() == null){
            catDAO.insertItem(categoria);
        }
    }

    @Override
    public Categoria updateCategoria(Categoria categoria) {
        return null;
    }

    @Override
    public Categoria selectCategoria(Long id) {
        return null;
    }

    @Override
    public List<Categoria> selectAllCategorias() {
        return null;
    }
}
