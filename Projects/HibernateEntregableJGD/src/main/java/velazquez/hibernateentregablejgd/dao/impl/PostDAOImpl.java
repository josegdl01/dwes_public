package velazquez.hibernateentregablejgd.dao.impl;

import org.hibernate.Session;
import velazquez.hibernateentregablejgd.dao.PostDAO;
import velazquez.hibernateentregablejgd.dao.generic.GenericDAOImpl;
import velazquez.hibernateentregablejgd.models.Post;
import velazquez.hibernateentregablejgd.models.User;

import java.util.List;

public class PostDAOImpl extends GenericDAOImpl<Post> implements PostDAO {

  private final Session session;

  public PostDAOImpl(Session session) {
    super(session);
    this.session = session;
  }

  @Override
  public List<Post> selectPostsByUser(User user) {
    return session
        .createQuery("FROM Post p WHERE p.user =: PARAM")
        .setParameter("PARAM", user)
        .list();
  }
}
