package velazquez.hibernateentregablejgd.services;

import velazquez.hibernateentregablejgd.models.Comment;

import java.util.List;

public interface CommentServices {
    public void deleteComment(Comment comment);
    public void insertComment(Comment comment);
    public void updateComment(Comment comment);
    public Comment selectComment(Long id);
    public List<Comment> selectAllComments();
    public List<Comment> selectCommentsByWord(String busqueda);
}
