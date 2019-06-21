package movies;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class ReservaList{

    private @Id String id;
    private String nome;
    private String data;
    private String horario;
    private String sala;
    private String codcancela;

    public ReservaList(String id, String nome, String data, String horario, String sala, String codcancela) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.horario = horario;
        this.sala = sala;
        this.codcancela = codcancela;
    }
}
