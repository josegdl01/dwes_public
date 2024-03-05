package velazquez.hibernateentregablejgd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import velazquez.hibernateentregablejgd.models.Comment;
import velazquez.hibernateentregablejgd.models.Post;
import velazquez.hibernateentregablejgd.models.Scoring;
import velazquez.hibernateentregablejgd.models.User;
import velazquez.hibernateentregablejgd.services.CommentServices;
import velazquez.hibernateentregablejgd.services.PostServices;
import velazquez.hibernateentregablejgd.services.ScoringServices;
import velazquez.hibernateentregablejgd.services.UserServices;
import velazquez.hibernateentregablejgd.services.impl.CommentServicesImpl;
import velazquez.hibernateentregablejgd.services.impl.PostServicesImpl;
import velazquez.hibernateentregablejgd.services.impl.ScoringServicesImpl;
import velazquez.hibernateentregablejgd.services.impl.UserServicesImpl;
import velazquez.hibernateentregablejgd.utils.HibernateUtils;

import java.sql.Date;

public class Main {
  public static void main(String[] args) {
    SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    Session session = sessionFactory.openSession();

    UserServices userServices = new UserServicesImpl(session);
    CommentServices commentServices = new CommentServicesImpl(session);
    ScoringServices scoringServices = new ScoringServicesImpl(session);
    PostServices postServices = new PostServicesImpl(session);

    User user1 = new User();
    user1.setUserName("user1");
    user1.setEmail("email1");
    user1.setPassword("password1");
    user1.setFirstName("Fname1");
    user1.setLastName("LName1");

    User user2 = new User();
    user2.setUserName("user2");
    user2.setEmail("email2");
    user2.setPassword("password2");
    user2.setFirstName("Fname2");
    user2.setLastName("LName2");

    User user3 = new User();
    user3.setUserName("user3");
    user3.setEmail("email3");
    user3.setPassword("password3");
    user3.setFirstName("Fname3");
    user3.setLastName("LName3");

    Post post1 = new Post();
    post1.setUser(user1);
    post1.setContent("content1");
    post1.setDate(new Date(2024, 01, 24));
    post1.setTitle("title1");

    Post post2 = new Post();
    post2.setUser(user1);
    post2.setContent("content2");
    post2.setDate(new Date(2023, 01, 24));
    post2.setTitle("title2");

    Post post3 = new Post();
    post3.setUser(user2);
    post3.setContent("content3");
    post3.setDate(new Date(2025, 01, 24));
    post3.setTitle("title3");

    Post post4 = new Post();
    post4.setUser(user1);
    post4.setContent("content4");
    post4.setDate(new Date(2024, 05, 24));
    post4.setTitle("title4");

    Post post5 = new Post();
    post5.setUser(user2);
    post5.setContent("content5");
    post5.setDate(new Date(2027, 01, 24));
    post5.setTitle("title5");

    Comment comment1 = new Comment();
    comment1.setContent("content1");
    comment1.setTitle("title1");
    comment1.setUser(user1);
    comment1.setPost(post1);

    Comment comment2 = new Comment();
    comment2.setContent("content2");
    comment2.setTitle("title2");
    comment2.setUser(user2);
    comment2.setPost(post1);

    Comment comment3 = new Comment();
    comment3.setContent("content3");
    comment3.setTitle("title3");
    comment3.setUser(user1);
    comment3.setPost(post4);

    Scoring scoring1 = new Scoring();
    scoring1.setScore(9.5);
    scoring1.setUser(user1);
    scoring1.setPost(post1);
    Scoring scoring2 = new Scoring();
    scoring2.setScore(8.5);
    scoring2.setUser(user2);
    scoring2.setPost(post1);
    Scoring scoring3 = new Scoring();
    scoring3.setScore(7.5);
    scoring3.setUser(user1);
    scoring3.setPost(post2);
    Scoring scoring4 = new Scoring();
    scoring4.setScore(6.5);
    scoring4.setUser(user2);
    scoring4.setPost(post2);
    Scoring scoring5 = new Scoring();
    scoring5.setScore(5.5);
    scoring5.setUser(user1);
    scoring5.setPost(post3);
    Scoring scoring6 = new Scoring();
    scoring6.setScore(4.5);
    scoring6.setUser(user2);
    scoring6.setPost(post3);
    Scoring scoring7 = new Scoring();
    scoring7.setScore(3.5);
    scoring7.setUser(user2);
    scoring7.setPost(post4);
    Scoring scoring8 = new Scoring();
    scoring8.setScore(2.5);
    scoring8.setUser(user1);
    scoring8.setPost(post5);
    Scoring scoring9 = new Scoring();
    scoring9.setScore(1.5);
    scoring9.setUser(user2);
    scoring9.setPost(post5);
    Scoring scoring10 = new Scoring();
    scoring10.setScore(0.5);
    scoring10.setUser(user3);
    scoring10.setPost(post3);

    userServices.insertUser(user1);
    userServices.insertUser(user2);
    userServices.insertUser(user3);

    postServices.insertPost(post1);
    postServices.insertPost(post2);
    postServices.insertPost(post3);
    postServices.insertPost(post4);
    postServices.insertPost(post5);

    commentServices.insertComment(comment1);
    commentServices.insertComment(comment2);
    commentServices.insertComment(comment3);

    scoringServices.insertScoring(scoring1);
    scoringServices.insertScoring(scoring2);
    scoringServices.insertScoring(scoring3);
    scoringServices.insertScoring(scoring4);
    scoringServices.insertScoring(scoring5);
    scoringServices.insertScoring(scoring6);
    scoringServices.insertScoring(scoring7);
    scoringServices.insertScoring(scoring8);
    scoringServices.insertScoring(scoring9);
    scoringServices.insertScoring(scoring10);

    System.out.println(userServices.selectUsersByUsernameOrEmail("email2"));
    System.out.println(postServices.selectPostsByUsername(user2));
    System.out.println(commentServices.selectCommentsByWord("title1"));

    user3.setPassword("Contraseña");
    userServices.updateUser(user3);

    commentServices.deleteComment(comment3);

    session.close();
  }
}
