package velazquez.entregablefinaljgd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import velazquez.entregablefinaljgd.models.Profesor;

@Repository
public interface ProfesoresRepository extends JpaRepository<Profesor, Integer> {}
