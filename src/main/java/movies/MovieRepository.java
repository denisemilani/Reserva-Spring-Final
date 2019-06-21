package movies;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, String> {

  @Query("select new movies.MovieList(id, title, year) from Movie")
  List<MovieList> findAllLazy();
}
