package velazquez.services.impl;

import velazquez.dao.generic.GenericDAO;
import velazquez.dao.impl.HabilidadDAOImpl;
import org.hibernate.Session;
import velazquez.services.HabilidadServices;

public class HabilidadServicesImpl implements HabilidadServices {
    GenericDAO habDAO;

    public HabilidadServicesImpl(Session session) {
    this.habDAO = new HabilidadDAOImpl(session);
    }


}
