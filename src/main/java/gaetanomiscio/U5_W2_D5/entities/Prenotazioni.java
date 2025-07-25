package gaetanomiscio.U5_W2_D5.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "prenotazioni")
@Getter
@Setter
@NoArgsConstructor
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

}
