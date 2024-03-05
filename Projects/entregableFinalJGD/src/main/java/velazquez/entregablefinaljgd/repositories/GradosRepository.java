package velazquez.entregablefinaljgd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import velazquez.entregablefinaljgd.models.Grado;

@Repository
public interface GradosRepository extends JpaRepository<Grado, Integer> {}
