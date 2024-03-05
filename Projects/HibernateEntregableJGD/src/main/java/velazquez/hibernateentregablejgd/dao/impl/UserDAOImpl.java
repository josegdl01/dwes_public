package velazquez.hibernateentregablejgd.dao.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import velazquez.hibernateentregablejgd.dao.UserDAO;
import velazquez.hibernateentregablejgd.dao.generic.GenericDAOImpl;
import velazquez.hibernateentregablejgd.models.User;

import java.util.List;

public class UserDAOImpl extends GenericDAOImpl<User> implements UserDAO {

  private final Session session;

  public UserDAOImpl(Session session) {
    super(session);
    this.session = session;
  }

  @Override
  public List<User> selectUsersByNameOrEmail(String busqueda) {
    CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(User.class);
    Root<User> root = criteriaQuery.from(User.class);

    Predicate userNameP = criteriaBuilder.equal(root.get("userName"), busqueda);
    Predicate userEmailP = criteriaBuilder.equal(root.get("email"), busqueda);
    Predicate orPredicate = criteriaBuilder.or(userNameP, userEmailP);

    criteriaQuery.select(root);
    criteriaQuery.where(orPredicate);

    return session.createQuery(criteriaQuery).getResultList();
  }
}
