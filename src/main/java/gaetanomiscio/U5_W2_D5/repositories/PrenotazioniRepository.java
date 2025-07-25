package gaetanomiscio.U5_W2_D5.repositories;

import gaetanomiscio.U5_W2_D5.entities.Dipendenti;
import gaetanomiscio.U5_W2_D5.entities.Prenotazioni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazioni, Integer> {
    boolean existsByDipendentiAndDataRichiesta(Dipendenti dipendenti, String data);

    List<Prenotazioni> findByDipendentiId(int dipendentiId);

    List<Prenotazioni> findByViaggiId(int viaggiId);
}
