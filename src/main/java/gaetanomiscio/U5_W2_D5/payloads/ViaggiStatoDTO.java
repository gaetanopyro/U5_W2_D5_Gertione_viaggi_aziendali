package gaetanomiscio.U5_W2_D5.payloads;

import gaetanomiscio.U5_W2_D5.enums.Stato;
import jakarta.validation.constraints.NotNull;

public record ViaggiStatoDTO(
        @NotNull(message = "Lo stato è obbligatorio")
        Stato stato
) {
}
