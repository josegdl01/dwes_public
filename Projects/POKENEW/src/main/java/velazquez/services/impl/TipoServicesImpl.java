package velazquez.services.impl;

import velazquez.dao.TipoDAO;
import velazquez.dao.impl.TipoDAOImpl;
import velazquez.models.Tipo;
import org.hibernate.Session;
import velazquez.services.TipoServices;

import java.util.List;

public class TipoServicesImpl implements TipoServices {

    TipoDAO tipoDAO;

    public TipoServicesImpl(Session session) {
    this.tipoDAO = new TipoDAOImpl(session);
    }

    @Override
    public void deleteTipo(Tipo tipo) {

    }

    @Override
    public void insertTipo(Tipo tipo) {
    System.out.println(tipo);
        if(tipo != null && tipo.getId() == null){
            tipoDAO.insertItem(tipo);
      System.out.println("TIPO INSERTADO");
        }
    }

    @Override
    public Tipo updateTipo(Tipo tipo) {
        return null;
    }

    @Override
    public Tipo selectTipo(Tipo tipo) {
        return null;
    }

    @Override
    public List<Tipo> selectAllTipos(Tipo tipo) {
        return null;
    }
}
