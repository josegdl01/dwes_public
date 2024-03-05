package velazquez.entregablefinaljgd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import velazquez.entregablefinaljgd.models.Departamento;
@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {}
