package gaetanomiscio.U5_W2_D5.services;

import gaetanomiscio.U5_W2_D5.entities.Dipendenti;
import gaetanomiscio.U5_W2_D5.exceptions.NotFoundException;
import gaetanomiscio.U5_W2_D5.repositories.DipendentiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DipendentiService {
    @Autowired
    private DipendentiRepository dipendentiRepository;

    public List<Dipendenti> getAll() {
        return dipendentiRepository.findAll();
    }

    public Dipendenti getById(int id) {
        return dipendentiRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Dipendenti save(Dipendenti dipendenti) {
        return dipendentiRepository.save(dipendenti);
    }

    public Dipendenti searchAndUpdate(int id, Dipendenti dipendenti) {
        Dipendenti found = this.getById(id);
        found.setUsername(dipendenti.getUsername());
        found.setNome(dipendenti.getNome());
        found.setCognome(dipendenti.getCognome());
        found.setEmail(dipendenti.getEmail());
        return dipendentiRepository.save(found);
    }

    public void searchAndDelete(int id) {
        Dipendenti found = this.getById(id);
        dipendentiRepository.delete(found);
    }
}
