package gaetanomiscio.U5_W2_D5.services;

import gaetanomiscio.U5_W2_D5.entities.Dipendenti;
import gaetanomiscio.U5_W2_D5.entities.Prenotazioni;
import gaetanomiscio.U5_W2_D5.entities.Viaggi;
import gaetanomiscio.U5_W2_D5.exceptions.BadRequestException;
import gaetanomiscio.U5_W2_D5.exceptions.NotFoundException;
import gaetanomiscio.U5_W2_D5.repositories.DipendentiRepository;
import gaetanomiscio.U5_W2_D5.repositories.PrenotazioniRepository;
import gaetanomiscio.U5_W2_D5.repositories.ViaggiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioniService {
    @Autowired
    private PrenotazioniRepository prenotazioniRepository;

    @Autowired
    private DipendentiRepository dipendentiRepository;

    @Autowired
    private ViaggiRepository viaggiRepository;

    public List<Prenotazioni> getAll() {
        return prenotazioniRepository.findAll();
    }

    public Prenotazioni getById(int id) {
        return prenotazioniRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public Prenotazioni create(Prenotazioni prenotazioni) {
        int dipendentiId = prenotazioni.getDipendenti().getId();
        String dataRichiesta = prenotazioni.getDataRichiesta();

        if (prenotazioniRepository.existsByDipendentiAndDataRichiesta(prenotazioni.getDipendenti(), dataRichiesta)) {
            throw new BadRequestException("Il dipendente ha già una prenotazione per la data: " + dataRichiesta);
        }

        Dipendenti dipendenti = dipendentiRepository.findById(dipendentiId)
                .orElseThrow(() -> new NotFoundException(dipendentiId));

        int viaggiId = prenotazioni.getViaggi().getId();
        Viaggi viaggi = viaggiRepository.findById(viaggiId)
                .orElseThrow(() -> new NotFoundException(viaggiId));

        prenotazioni.setDipendenti(dipendenti);
        prenotazioni.setViaggi(viaggi);

        return prenotazioniRepository.save(prenotazioni);
    }

    public Prenotazioni update(int id, Prenotazioni prenotazioni) {
        Prenotazioni found = this.getById(id);

        found.setDataRichiesta(prenotazioni.getDataRichiesta());
        found.setNote(prenotazioni.getNote());

        Dipendenti dipendenti = dipendentiRepository.findById(prenotazioni.getDipendenti().getId())
                .orElseThrow(() -> new NotFoundException(prenotazioni.getDipendenti().getId()));

        Viaggi viaggi = viaggiRepository.findById(prenotazioni.getViaggi().getId())
                .orElseThrow(() -> new NotFoundException(prenotazioni.getViaggi().getId()));

        found.setDipendenti(dipendenti);
        found.setViaggi(viaggi);

        return prenotazioniRepository.save(found);
    }

    public void delete(int id) {
        Prenotazioni found = this.getById(id);
        prenotazioniRepository.delete(found);
    }
}
