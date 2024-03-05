package dao.impl;

import dao.HabilidadDAO;
import dao.generic.GenericDAOImpl;
import models.Habilidad;
import org.hibernate.Session;

public class HabilidadDAOImpl extends GenericDAOImpl<Habilidad> implements HabilidadDAO {

    private final Session session;

    public HabilidadDAOImpl(Session session) {
        super(session);
        this.session = session;
    }
}
