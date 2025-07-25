package gaetanomiscio.U5_W2_D5.repositories;

import gaetanomiscio.U5_W2_D5.entities.Dipendenti;
import gaetanomiscio.U5_W2_D5.entities.Prenotazioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazioni, Long> {
    boolean existsByDipendentiAndViaggi_Data(Dipendenti dipendente, String data);
}
