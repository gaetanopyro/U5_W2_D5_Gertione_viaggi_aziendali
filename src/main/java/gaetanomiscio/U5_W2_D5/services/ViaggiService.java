package gaetanomiscio.U5_W2_D5.services;

import gaetanomiscio.U5_W2_D5.entities.Viaggi;
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
        return viaggiRepository.findAll():
    }
    public Viaggi getById(int id){
        return viaggiRepository.findAllById(id).orElseThrow(() -> new NotFoundException(id));
    }


}
