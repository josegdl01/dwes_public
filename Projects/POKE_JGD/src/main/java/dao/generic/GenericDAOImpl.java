package dao.generic;

import jakarta.persistence.EntityExistsException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;

public class GenericDAOImpl<T extends Identifiable> implements GenericDAO<T> {

  static final Logger log = LoggerFactory.getLogger(GenericDAOImpl.class);
  protected final Session session;
  private Class<T> clase;

  public GenericDAOImpl(Session session) {
    setEntityClass(
        (Class<T>)
            ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]);
    this.session = session;
  }

  private void setEntityClass(Class<T> clase) {
    this.clase = clase;
  }

  @Override
  public void insert(T t) {
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    session.persist(t);
    log.info("OBJETO INSERTADO: " + t.toString());
    session.flush();

    session.getTransaction().commit();
  }

  @Override
  public void delete(T t) {
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    session.remove(t);

    session.getTransaction().commit();
  }

  @Override
  public void update(T t) {
    T objetoActualizado = null;

    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    if (Objects.isNull(session.find(this.clase, t.getId()))) {
      session.persist(t);
      log.info("OBJETO INSERTADO: " + t.toString());
    } else {
      objetoActualizado = session.merge(t);
      log.info("OBJETO ACTUALIZADO: " + t.toString());
    }

    try {
      session.getTransaction().commit();
    } catch (EntityExistsException e) {
      log.error("ERROR AL ACTUALIZAR " + t);
      log.error(e.getMessage());
      for (StackTraceElement element : e.getStackTrace()) {
        log.error(element.toString());
      }
    }
  }

  @Override
  public T select(Long id) {

    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    return session.get(this.clase, id);
  }

  @Override
  public List<T> selectAll() {
    if(!session.getTransaction().isActive()){
        session.getTransaction().begin();
    }

    return session.createQuery("FROM "+this.clase.getName(), this.clase).list();
  }

    public Class<T> getClase() {
        return clase;
    }

    public void setClase(Class<T> clase) {
        this.clase = clase;
    }
}
