package movies;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class DirectorList{

  private @Id String id;
  private String name;

  public DirectorList(String id, String name) {
    this.name = name;
    this.id = id;
  }
}
