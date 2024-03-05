package velazquez.hibernateentregablejgd.dao.impl;

import org.hibernate.Session;
import velazquez.hibernateentregablejgd.dao.CommentDAO;
import velazquez.hibernateentregablejgd.dao.generic.GenericDAOImpl;
import velazquez.hibernateentregablejgd.models.Comment;

import java.util.List;

public class CommentDAOImpl extends GenericDAOImpl<Comment> implements CommentDAO {

    private final Session session;

    public CommentDAOImpl(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    public List<Comment> selectCommentsByWord(String busqueda) {
        return session.createQuery("FROM Comment c WHERE c.content =: PARAM OR c.title =: PARAM")
                .setParameter("PARAM", busqueda)
                .list();
    }
}
