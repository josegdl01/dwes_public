package velazquez.hibernateentregablejgd.services;

import velazquez.hibernateentregablejgd.models.Scoring;

import java.util.List;

public interface ScoringServices {
    public void insertScoring(Scoring scoring);
    public void deleteScoring(Scoring scoring);
    public void updateScoring(Scoring scoring);
    public Scoring selectScoring(Long id);
    public List<Scoring> selectAllScorings();
}
