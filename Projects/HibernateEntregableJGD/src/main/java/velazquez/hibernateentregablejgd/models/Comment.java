package velazquez.hibernateentregablejgd.models;

import jakarta.persistence.*;
import velazquez.hibernateentregablejgd.dao.generic.Identifiable;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Comment implements Serializable, Identifiable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column private String title;
  @Column private String content;

  @ManyToOne(cascade = CascadeType.MERGE)
  private User user;

  @ManyToOne(cascade = CascadeType.MERGE)
  private Post post;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Comment)) return false;
    Comment comment = (Comment) o;
    return Objects.equals(id, comment.id)
        && Objects.equals(title, comment.title)
        && Objects.equals(content, comment.content)
        && Objects.equals(user, comment.user)
        && Objects.equals(post, comment.post);
  }

  @Override
  public String toString() {
    return "Comment{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", user=" + user +
            ", post=" + post +
            '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, content, user, post);
  }
}
