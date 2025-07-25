package gaetanomiscio.U5_W2_D5.controllers;

import gaetanomiscio.U5_W2_D5.entities.Dipendenti;
import gaetanomiscio.U5_W2_D5.exceptions.ValidationException;
import gaetanomiscio.U5_W2_D5.payloads.DipendentiDTO;
import gaetanomiscio.U5_W2_D5.services.DipendentiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dipendenti")
public class DipendentiController {
    @Autowired
    private DipendentiService dipendentiService;

    @GetMapping
    public List<Dipendenti> getDipendenti() {
        return this.dipendentiService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendenti save(@RequestBody @Validated DipendentiDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            throw new ValidationException(validationResult.getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).toList());
        } else {
            Dipendenti newDipendenti = this.dipendentiService.save(new Dipendenti(payload.username(), payload.nome(), payload.cognome(), payload.email()));
            return newDipendenti;
        }
    }

    @GetMapping("/{id}")
    public Dipendenti getById(@PathVariable int id) {
        return this.dipendentiService.getById(id);
    }

    @PutMapping("/{id}")
    public Dipendenti update(@PathVariable int id, @RequestBody @Validated DipendentiDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            throw new ValidationException(validationResult.getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).toList());
        }

        Dipendenti updatedDipendenti = new Dipendenti(payload.username(), payload.nome(), payload.cognome(), payload.email());
        return this.dipendentiService.searchAndUpdate(id, updatedDipendenti);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        this.dipendentiService.searchAndDelete(id);
    }

    @PatchMapping("/{dipendenteId}/upload")
    public Dipendenti uploadImage(@PathVariable int dipendenteId, @RequestParam("image") MultipartFile image) throws IOException {
        String url = dipendentiService.uploadImage(image);
        return dipendentiService.updateImgUrl(dipendenteId, url);
    }
}
