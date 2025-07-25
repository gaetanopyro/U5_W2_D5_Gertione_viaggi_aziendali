package gaetanomiscio.U5_W2_D5.repositories;

import gaetanomiscio.U5_W2_D5.entities.Dipendenti;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DipendentiRepository extends JpaRepository<Dipendenti, Long> {

    Optional<Dipendenti> findByUsername(String username);

    boolean existsByEmail(String email);
}
