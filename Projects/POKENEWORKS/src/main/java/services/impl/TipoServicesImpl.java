package services.impl;

import dao.TipoDAO;
import dao.impl.TipoDAOImpl;
import models.Pokemon;
import models.Tipo;
import org.hibernate.Session;
import services.TipoServices;

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
    public List<Tipo> selectAllTipo() {
        return null;
    }

    @Override
    public List<Pokemon> selectPokemonsByTipo(Tipo tipo) {
        return tipoDAO.selectPokesByTipo(tipo);
    }
}
