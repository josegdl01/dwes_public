package velazquez.hibernateentregablejgd.services.impl;

import org.hibernate.Session;
import velazquez.hibernateentregablejgd.dao.ScoringDAO;
import velazquez.hibernateentregablejgd.dao.impl.ScoringDAOImpl;
import velazquez.hibernateentregablejgd.models.Scoring;
import velazquez.hibernateentregablejgd.services.ScoringServices;

import java.util.List;

public class ScoringServicesImpl implements ScoringServices {

  ScoringDAO scoringDAO;

  public ScoringServicesImpl(Session session) {
    this.scoringDAO = new ScoringDAOImpl(session);
  }

  @Override
  public void insertScoring(Scoring scoring) {
    if (scoring != null) {
      System.out.println("hola");
      scoringDAO.insertItem(scoring);
    }
  }

  @Override
  public void deleteScoring(Scoring scoring) {
    if (scoring != null && scoring.getUser() != null) {
      scoringDAO.deleteItem(scoring);
    }
  }

  @Override
  public void updateScoring(Scoring scoring) {
    if (scoring != null && scoring.getUser() != null) {
      scoringDAO.updateItem(scoring);
    }
  }

  @Override
  public Scoring selectScoring(Long id) {
    Scoring scoring = null;
    if (id != null) {
      scoring = scoringDAO.selectItem(id);
    }
    return scoring;
  }

  @Override
  public List<Scoring> selectAllScorings() {
    return scoringDAO.selectAllItems();
  }
}
