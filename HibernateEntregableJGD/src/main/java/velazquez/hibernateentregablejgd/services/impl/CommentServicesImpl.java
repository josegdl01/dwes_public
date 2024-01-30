package velazquez.hibernateentregablejgd.services.impl;

import org.hibernate.Session;
import velazquez.hibernateentregablejgd.dao.CommentDAO;
import velazquez.hibernateentregablejgd.dao.impl.CommentDAOImpl;
import velazquez.hibernateentregablejgd.models.Comment;
import velazquez.hibernateentregablejgd.services.CommentServices;

import java.util.List;

public class CommentServicesImpl implements CommentServices {

    CommentDAO commentDAO;

    public CommentServicesImpl(Session session){
        this.commentDAO = new CommentDAOImpl(session);
    }

    @Override
    public void deleteComment(Comment comment) {
        if(comment != null && comment.getId() != null){
            commentDAO.deleteItem(comment);
        }
    }

    @Override
    public void insertComment(Comment comment) {
        if(comment != null && comment.getId() == null){
            commentDAO.insertItem(comment);
        }
    }

    @Override
    public void updateComment(Comment comment) {
        if(comment != null && comment.getId() != null){
            commentDAO.updateItem(comment);
        }
    }

    @Override
    public Comment selectComment(Long id) {
        Comment comment = null;
        if(id != null){
            comment = commentDAO.selectItem(id);
        }
        return comment;
    }

    @Override
    public List<Comment> selectAllComments() {
        return commentDAO.selectAllItems();
    }

    @Override
    public List<Comment> selectCommentsByWord(String busqueda) {
        return commentDAO.selectCommentsByWord(busqueda);
    }
}
