package movies;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController{
  private final MovieRepository repository;

  MovieController(MovieRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/movies")
  List<MovieList> all() {
    return repository.findAllLazy();
  }

  @PostMapping("/movies")
  Movie addMovie(@RequestBody Movie movie) {
    return repository.save(movie);
  }

  @GetMapping("/movies/{id}")
  Movie getMovieById(@PathVariable String id) {
    return repository.findById(id)
      .orElseThrow(() -> new MovieNotFoundException(id));
  }

  @PutMapping("/movies/{id}")
  Movie addOrUpdateMovieById(@RequestBody Movie m, @PathVariable String id) {

    return repository.findById(id)
      .map(movie -> {
        movie.setTitle(m.getTitle());
        movie.setYear(m.getYear());
        return repository.save(movie);
      })
      .orElseGet(() -> {
        m.setId(id);
        return repository.save(m);
      });
  }

  @DeleteMapping("/movies/{id}")
  void removeMovieById(@PathVariable String id) {
    repository.deleteById(id);
  }
}
