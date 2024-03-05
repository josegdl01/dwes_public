package services.impl;

import dao.HabilidadDAO;
import dao.generic.GenericDAO;
import dao.impl.HabilidadDAOImpl;
import models.Habilidad;
import org.hibernate.Session;
import services.HabilidadServices;

public class HabilidadServicesImpl implements HabilidadServices {
    GenericDAO habDAO;

    public HabilidadServicesImpl(Session session) {
    this.habDAO = new HabilidadDAOImpl(session);
    }


}
