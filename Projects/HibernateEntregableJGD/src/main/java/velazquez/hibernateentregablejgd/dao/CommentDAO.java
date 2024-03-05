package velazquez.hibernateentregablejgd.dao;

import velazquez.hibernateentregablejgd.dao.generic.GenericDAO;
import velazquez.hibernateentregablejgd.models.Comment;

import java.util.List;

public interface CommentDAO extends GenericDAO<Comment> {

    public List<Comment> selectCommentsByWord(String busqueda);

}
