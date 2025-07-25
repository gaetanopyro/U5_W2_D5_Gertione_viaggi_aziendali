package gaetanomiscio.U5_W2_D5.payloads;

import java.time.LocalDate;

public record ErrorsDTO(String message, LocalDate timestamp) {
}
