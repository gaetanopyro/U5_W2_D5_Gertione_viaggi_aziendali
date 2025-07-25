package gaetanomiscio.U5_W2_D5.entities;

import gaetanomiscio.U5_W2_D5.enums.Stato;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Entity
@Table(name = "viaggi")
@Getter
@Setter
@NoArgsConstructor
@ToString

public class Viaggi {
    @Id
    @GeneratedValue
    private int id;
    private String destinazione;
    private String data;
    @Enumerated(EnumType.STRING)
    private Stato stato;
    

    public Viaggi(String destinazione, String data, Stato stato) {
        this.id = new Random().nextInt(1, 10000);
        this.destinazione = destinazione;
        this.data = data;
        this.stato = stato;
    }
}
