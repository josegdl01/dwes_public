package velazquez.hibernateentregablejgd.services.impl;

import org.hibernate.Session;
import velazquez.hibernateentregablejgd.dao.PostDAO;
import velazquez.hibernateentregablejgd.dao.impl.PostDAOImpl;
import velazquez.hibernateentregablejgd.models.Post;
import velazquez.hibernateentregablejgd.models.User;
import velazquez.hibernateentregablejgd.services.PostServices;

import java.util.List;

public class PostServicesImpl implements PostServices {

    private PostDAO postDAO;

    public PostServicesImpl(Session session) {
    this.postDAO = new PostDAOImpl(session);
    }

    @Override
    public void deletePost(Post post) {
        if(post != null && post.getId() != null){
            postDAO.deleteItem(post);
        }
    }

    @Override
    public void insertPost(Post post) {
        if(post != null && post.getId() == null){
            postDAO.insertItem(post);
        }
    }

    @Override
    public void updatePost(Post post) {
        if(post != null && post.getId() != null){
            postDAO.updateItem(post);
        }
    }

    @Override
    public Post selectPost(Long id) {
        Post post = null;
        if(id != null){
            post = postDAO.selectItem(id);
        }

        return post;
    }

    @Override
    public List<Post> selectAllPosts() {
        return postDAO.selectAllItems();
    }

    @Override
    public List<Post> selectPostsByUsername(User user) {
        return postDAO.selectPostsByUser(user);
    }
}
