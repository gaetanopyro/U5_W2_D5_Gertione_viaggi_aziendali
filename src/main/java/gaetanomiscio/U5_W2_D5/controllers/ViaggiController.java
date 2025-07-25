package gaetanomiscio.U5_W2_D5.controllers;

import gaetanomiscio.U5_W2_D5.entities.Viaggi;
import gaetanomiscio.U5_W2_D5.exceptions.ValidationException;
import gaetanomiscio.U5_W2_D5.payloads.ViaggiDTO;
import gaetanomiscio.U5_W2_D5.payloads.ViaggiStatoDTO;
import gaetanomiscio.U5_W2_D5.services.ViaggiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggiController {
    @Autowired
    private ViaggiService viaggiService;

    @GetMapping
    public List<Viaggi> getAll() {
        return viaggiService.getAll();
    }

    @GetMapping("/{id}")
    public Viaggi getById(@PathVariable int id) {
        return viaggiService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Viaggi create(@RequestBody @Validated ViaggiDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            throw new ValidationException(validationResult.getFieldErrors().stream()
                    .map(err -> err.getDefaultMessage()).toList());
        }

        Viaggi viaggi = new Viaggi(payload.destinazione(), payload.data(), payload.stato());
        return viaggiService.save(viaggi);
    }

    @PutMapping("/{id}")
    public Viaggi update(@PathVariable int id, @RequestBody @Validated ViaggiDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            throw new ValidationException(validationResult.getFieldErrors().stream()
                    .map(err -> err.getDefaultMessage()).toList());
        }


        Viaggi viaggi = new Viaggi(payload.destinazione(), payload.data(), payload.stato());
        return viaggiService.searchAndUpdate(id, viaggi);
    }

    @PatchMapping("/{id}/stato")
    public Viaggi updateStato(@PathVariable int id, @RequestBody @Validated ViaggiStatoDTO payload, BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            throw new ValidationException(validationResult.getFieldErrors().stream()
                    .map(err -> err.getDefaultMessage()).toList());
        }

        return viaggiService.aggiornaStato(id, payload.stato());
    }

//    @DeleteMapping("/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable int id) {
//        ViaggiService.searchAndDelete(id);
//    }
}
