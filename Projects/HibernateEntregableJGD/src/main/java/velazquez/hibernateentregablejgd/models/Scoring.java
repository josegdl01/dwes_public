package velazquez.hibernateentregablejgd.models;

import jakarta.persistence.*;
import velazquez.hibernateentregablejgd.dao.generic.Identifiable;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Scoring implements Serializable {

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId")
    private User user;

    @Id
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PostId")
    private Post post;
    @Column
    private Double score;

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

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scoring)) return false;
        Scoring scoring = (Scoring) o;
        return Objects.equals(user, scoring.user) && Objects.equals(post, scoring.post) && Objects.equals(score, scoring.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, post, score);
    }

    @Override
    public String toString() {
        return "Scoring{" +
                "user=" + user +
                ", post=" + post +
                ", score=" + score +
                '}';
    }
}
