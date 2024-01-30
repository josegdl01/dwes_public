package velazquez.hibernateentregablejgd.models;

import jakarta.persistence.*;
import velazquez.hibernateentregablejgd.dao.generic.Identifiable;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Post implements Serializable, Identifiable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column private String title;
  @Column private String content;
  @Column private Date date;

  @ManyToOne(cascade = CascadeType.ALL)
  private User user;

  @OneToMany(mappedBy = "post", cascade = CascadeType.MERGE, orphanRemoval = true)
  private Set<Comment> comments = new HashSet<>();

  @Override
  public String toString() {
    return "Post{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", content='" + content + '\'' +
            ", date=" + date +
            ", user=" + user +
            ", comments=" + comments +
            ", scoring=" + scoring +
            '}';
  }

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Scoring> scoring = new HashSet<>();

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

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Set<Comment> getComments() {
    return comments;
  }

  //HELPERS
  public void addComment(Comment comment) {
    this.comments.add(comment);
    comment.setPost(this);
  }
  public void removeComment(Comment comment) {
    this.comments.remove(comment);
    comment.setPost(null);
  }

  public void addScoring(Scoring scoring){
    this.scoring.add(scoring);
    scoring.setPost(this);
  }

  public void removeScoring(Scoring scoring){
    this.scoring.remove(scoring);
    scoring.setPost(null);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Post)) return false;
    Post post = (Post) o;
    return Objects.equals(id, post.id)
        && Objects.equals(title, post.title)
        && Objects.equals(content, post.content)
        && Objects.equals(date, post.date)
        && Objects.equals(user, post.user)
        && Objects.equals(comments, post.comments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, content, date, user, comments);
  }
}
