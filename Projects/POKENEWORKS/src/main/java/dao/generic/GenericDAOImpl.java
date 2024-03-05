package dao.generic;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;

public class GenericDAOImpl<T extends Identifiable> implements GenericDAO<T> {

  static final Logger log = LoggerFactory.getLogger(GenericDAOImpl.class);
  private Class<T> item;
  protected final Session session;

  public GenericDAOImpl(Session session) {
    setItem(
        (Class<T>)
            ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0]);
    this.session = session;
  }

  @Override
  public void updateItem(T t) {
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }
    if (Objects.isNull(session.find(this.item, t.getId()))) {
      session.persist(t);
      log.info("OBJETO INSERTADO" + t.toString());
    } else {
      session.merge(t);
      log.info("OBJETO ACTUALIZADO" + t.toString());
    }
    session.flush();
    session.getTransaction().commit();
  }

  @Override
  public void insertItem(T t) {
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }
    session.persist(t);
//    session.flush();
    session.getTransaction().commit();
    log.info("OBJETO INSERTADO " + t.toString());
  }

  @Override
  public void deleteItem(T t) {
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }

    session.delete(t);
    session.flush();
    session.getTransaction().commit();
    log.info("OBJETO BORRADO " + t.toString());
  }

  @Override
  public T selectItem(long id) {
    T t = null;
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }
    if (session.find(this.item, id) == null) {
      log.error("NO SE HA ENCONTRADO EL OBJETO EN CUESTIÓN");
    } else {
      t = session.find(this.item, id);
      log.info("OBJETO ENCONTRADO " + t.toString());
    }
    return t;
  }

  @Override
  public List<T> selectAllItems() {
    if (!session.getTransaction().isActive()) {
      session.getTransaction().begin();
    }
    return session.createQuery("FROM " + this.item.getName(), this.item).list();
  }

  public void setItem(Class<T> item) {
    this.item = item;
  }
}
