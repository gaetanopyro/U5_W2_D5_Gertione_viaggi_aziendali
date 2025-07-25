package gaetanomiscio.U5_W2_D5.payloads;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PrenotazioniDTO(
        @NotNull(message = "Id viaggio obbligatorio!")
        Integer viaggiId,
        @NotNull(message = "Id dipendete obbligatorio!")
        Integer dipendentiId,
        @NotNull(message = "Prenotazione obbligatorio!")
        Integer dataRichiesta,
        @Size(message = "Id viaggio obbligatorio!")
        String note
) {


}
