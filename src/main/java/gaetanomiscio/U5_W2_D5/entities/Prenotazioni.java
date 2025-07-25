package gaetanomiscio.U5_W2_D5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Prenotazioni {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "viaggi_id")
    private Viaggi viaggi;
    @ManyToOne
    @JoinColumn(name = "dipente_id")
    private Dipendenti dipendenti;
    private String dataRichiesta;
    private String note;

    public Prenotazioni(Viaggi viaggi, Dipendenti dipendenti, String dataRichiesta, String note) {
        this.id = new Random().nextInt(1, 10000);
        this.viaggi = viaggi;
        this.dipendenti = dipendenti;
        this.dataRichiesta = dataRichiesta;
        this.note = note;
    }
}
