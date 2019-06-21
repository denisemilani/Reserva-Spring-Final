package movies;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

@Data
@Entity
public class Reservas{

    private @Id String id;
    private String nome;
    private String data;
    private String horario;
    private String sala;
    private String codcancela;

    public Reservas() {}

}
