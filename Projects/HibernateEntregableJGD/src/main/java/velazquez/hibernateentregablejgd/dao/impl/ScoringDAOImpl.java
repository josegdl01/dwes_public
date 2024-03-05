package velazquez.hibernateentregablejgd.dao.impl;

import org.hibernate.Session;
import velazquez.hibernateentregablejgd.dao.ScoringDAO;
import velazquez.hibernateentregablejgd.dao.generic.GenericDAOImpl;
import velazquez.hibernateentregablejgd.dao.generic.GenericDAOScoring;
import velazquez.hibernateentregablejgd.models.Scoring;

public class ScoringDAOImpl extends GenericDAOScoring<Scoring> implements ScoringDAO {

  private final Session session;

  public ScoringDAOImpl(Session session) {
    super(session);
    this.session = session;
  }
}
