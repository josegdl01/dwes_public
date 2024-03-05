package velazquez.entregablefinaljgd.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import velazquez.entregablefinaljgd.models.Usuarios;

@Repository
public interface JPAUserDetailsRepository extends JpaRepository<Usuarios, Integer> {
    Usuarios findUsuariosByUsuario(String usuario);
}
