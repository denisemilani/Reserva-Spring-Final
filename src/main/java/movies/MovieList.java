package movies;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class MovieList{

  private @Id String id;
  private String title;
  private int year;

  public MovieList(String id, String title, int year) {
    this.title = title;
    this.year = year;
    this.id = id;
  }
}
