package gaetanomiscio.U5_W2_D5.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record DipendentiDTO(
        @NotEmpty(message = "Username obbligatorio!")
        @Size(min = 4, max = 20, message = "L'username deve avere min 4 caratteri massimo 20")
        String username,
        @NotEmpty(message = "Nome obbligatorio!")
        @Size(min = 3, max = 20, message = "Il nome deve avere min 3 caratteri massimo 20")
        String nome,
        @NotEmpty(message = "Cognome obbligatorio!")
        @Size(min = 4, max = 20, message = "Il cognome deve avere min 4 caratteri massimo 20")
        String cognome,
        @NotEmpty(message = "Email obbligatoria!")
        String email
) {


}
