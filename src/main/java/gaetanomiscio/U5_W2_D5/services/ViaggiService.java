package gaetanomiscio.U5_W2_D5.services;

import gaetanomiscio.U5_W2_D5.entities.Viaggi;
import gaetanomiscio.U5_W2_D5.enums.Stato;
import gaetanomiscio.U5_W2_D5.exceptions.NotFoundException;
import gaetanomiscio.U5_W2_D5.repositories.ViaggiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViaggiService {
    @Autowired
    private ViaggiRepository viaggiRepository;

    public List<Viaggi> getAll() {
        return viaggiRepository.findAll();
    }

    public Viaggi getById(int id) {
        return viaggiRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Viaggi save(Viaggi viaggi) {
        return viaggiRepository.save(viaggi);
    }

    public Viaggi searchAndUpdate(int id, Viaggi viaggi) {
        Viaggi found = this.getById(id);
        found.setDestinazione(viaggi.getDestinazione());
        found.setData(viaggi.getData());
        found.setStato(viaggi.getStato());
        return viaggiRepository.save(found);
    }

    public void searchAndDelete(int id) {
        Viaggi found = this.getById(id);
        viaggiRepository.delete(found);
    }

    public Viaggi aggiornaStato(int id, Stato newStato) {
        Viaggi viaggi = this.getById(id);
        viaggi.setStato(newStato);
        return viaggiRepository.save(viaggi);
    }


}
