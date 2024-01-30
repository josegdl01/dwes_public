package velazquez.hibernateentregablejgd.dao;

import velazquez.hibernateentregablejgd.dao.generic.GenericDAO;
import velazquez.hibernateentregablejgd.models.Post;
import velazquez.hibernateentregablejgd.models.User;

import java.util.List;

public interface PostDAO extends GenericDAO<Post> {
    public List<Post> selectPostsByUser(User user);
}
