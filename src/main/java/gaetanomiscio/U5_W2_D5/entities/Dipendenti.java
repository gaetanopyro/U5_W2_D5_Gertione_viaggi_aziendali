package gaetanomiscio.U5_W2_D5.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;

@Entity
@Table(name = "dipendenti")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Dipendenti {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String imgUrl;

    public Dipendenti(String username, String nome, String cognome, String email) {
        this.id = new Random().nextInt(1, 10000);
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }
}
