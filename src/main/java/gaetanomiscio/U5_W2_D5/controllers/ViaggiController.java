package gaetanomiscio.U5_W2_D5.controllers;

import gaetanomiscio.U5_W2_D5.entities.Viaggi;
import gaetanomiscio.U5_W2_D5.services.ViaggiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/viaggi")
public class ViaggiController {
    @Autowired
    private ViaggiService viaggiService;

    @GetMapping
    public List<Viaggi> getViaggi() {
        return this.viaggiService.getAll();
    }

}
