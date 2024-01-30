package velazquez.hibernateentregablejgd.models;

import jakarta.persistence.*;
import velazquez.hibernateentregablejgd.dao.generic.Identifiable;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@Entity
public class User implements Serializable, Identifiable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column private String userName;
  @Column private String password;
  @Column private String firstName;
  @Column private String lastName;
  @Column private String email;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Post> posts = new HashSet<>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.MERGE, orphanRemoval = true)
  private Set<Comment> comments = new HashSet<>();

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", posts=" + posts +
            ", comments=" + comments +
            ", scoring=" + scoring +
            '}';
  }

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Scoring> scoring = new HashSet<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Set<Post> getPosts() {
    return posts;
  }

  public Set<Scoring> getScoring() {
    return scoring;
  }

  public Set<Comment> getComments() {
    return comments;


  }
  //HELPERS

  public void addPost(Post post) {
    this.posts.add(post);
    post.setUser(this);
  }

  public void removePost(Post post) {
    this.posts.remove(post);
    post.setUser(null);
  }

  public void addComment(Comment comment) {
    this.comments.add(comment);
    comment.setUser(this);
  }
  public void removeComment(Comment comment) {
    this.comments.remove(comment);
    comment.setUser(null);
  }

  public void addScoring(Scoring scoring){
    this.scoring.add(scoring);
    scoring.setUser(this);
  }

  public void removeScoring(Scoring scoring){
    this.scoring.remove(scoring);
    scoring.setUser(null);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return Objects.equals(id, user.id)
        && Objects.equals(userName, user.userName)
        && Objects.equals(password, user.password)
        && Objects.equals(firstName, user.firstName)
        && Objects.equals(lastName, user.lastName)
        && Objects.equals(email, user.email)
        && Objects.equals(posts, user.posts)
        && Objects.equals(comments, user.comments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userName, password, firstName, lastName, email, posts, comments);
  }
}
