package velazquez.dao.impl;

import velazquez.dao.HabilidadDAO;
import velazquez.dao.generic.GenericDAOImpl;
import velazquez.models.Habilidad;
import org.hibernate.Session;

public class HabilidadDAOImpl extends GenericDAOImpl<Habilidad> implements HabilidadDAO {

    private final Session session;

    public HabilidadDAOImpl(Session session) {
        super(session);
        this.session = session;
    }
}
