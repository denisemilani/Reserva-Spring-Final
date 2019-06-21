package movies;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

@Data
@Entity
public class Movie{

  private @Id String id;
  private String title;
  private int duration;
  private double cost;
  private int year;

  private String currency;

  @ManyToOne(fetch=FetchType.EAGER)
  @JoinColumn(name = "director_id")
  @JsonBackReference
  private Director director;

  public Movie() {}
}
