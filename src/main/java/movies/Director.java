package movies;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import com.fasterxml.jackson.annotation.*;
import javax.persistence.*;


import java.util.List;

@Data
@Entity
public class Director{

  private @Id String id;
  private String name;
  private Date birth;
  private String country;

  @OneToMany(mappedBy = "director", fetch=FetchType.LAZY)
  @JsonManagedReference
  private List<Movie> movies;

  public Director() {}
}
