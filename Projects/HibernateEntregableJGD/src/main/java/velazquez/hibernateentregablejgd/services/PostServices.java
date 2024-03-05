package velazquez.hibernateentregablejgd.services;

import velazquez.hibernateentregablejgd.models.Post;
import velazquez.hibernateentregablejgd.models.User;

import java.util.List;

public interface PostServices {
    public void deletePost(Post post);
    public void insertPost(Post post);
    public void updatePost(Post post);
    public Post selectPost(Long id);
    public List<Post> selectAllPosts();
    public List<Post> selectPostsByUsername(User user);
}
