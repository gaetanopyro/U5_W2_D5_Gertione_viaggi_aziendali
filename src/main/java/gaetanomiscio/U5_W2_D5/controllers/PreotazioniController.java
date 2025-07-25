package gaetanomiscio.U5_W2_D5.controllers;

import gaetanomiscio.U5_W2_D5.entities.Prenotazioni;
import gaetanomiscio.U5_W2_D5.payloads.PrenotazioniDTO;
import gaetanomiscio.U5_W2_D5.services.PrenotazioniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PreotazioniController {
    @Autowired
    private PrenotazioniService prenotazioniService;

    @GetMapping
    public List<Prenotazioni> getAllPrenotazioni() {
        return prenotazioniService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Prenotazioni createPrenotazioni(@RequestBody @Validated PrenotazioniDTO newPrenotazioni) {
        return prenotazioniService.create(new Prenotazioni());
    }

    @GetMapping("/{prenotazioneId}")
    public Prenotazioni getPrenotazioniById(@PathVariable int prenotazioneId) {
        return prenotazioniService.getById(prenotazioneId);
    }

    /*
        @PutMapping("/{prenotazioniId}")
        public Prenotazioni updatePrenotazioni(@PathVariable int prenotazioniId, @RequestBody @Validated PrenotazioniDTO prenotazioni) {
            return prenotazioniService.update(prenotazioniId, prenotazioni);
        }
    */
    @DeleteMapping("/{prenotazioniId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePrenotazioni(@PathVariable int prenotazioniId) {
        prenotazioniService.delete(prenotazioniId);
    }
}
