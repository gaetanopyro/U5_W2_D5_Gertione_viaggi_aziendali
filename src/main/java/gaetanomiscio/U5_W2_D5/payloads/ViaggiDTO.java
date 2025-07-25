package gaetanomiscio.U5_W2_D5.payloads;

import gaetanomiscio.U5_W2_D5.enums.Stato;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record ViaggiDTO(
        @NotEmpty(message = "Destinazione obbligatorio!")
        @Size(min = 2, max = 20, message = "La destinazione deve avere min 2 caratteri massimo 20")
        String destinazione,
        @NotEmpty(message = "Data obbligatorio!")
        @Size(min = 2, max = 20, message = "la data deve avere min 2 caratteri massimo 20")
        String data,
        @NotEmpty(message = "Stato obbligatorio!")
        Stato stato

) {
}
