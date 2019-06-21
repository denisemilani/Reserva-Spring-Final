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
public class DirectorController{
  private final DirectorRepository repository;

  DirectorController(DirectorRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/directors")
  List<DirectorList> all() {
    return repository.findAllLazy();
  }

  @PostMapping("/directors")
  Director addDirector(@RequestBody Director actor) {
    return repository.save(actor);
  }

  @GetMapping("/directors/{id}")
  Director getDirectorById(@PathVariable String id) {
    return repository.findById(id)
      .orElseThrow(() -> new DirectorNotFoundException(id));
  }

  @PutMapping("/directors/{id}")
  Director addOrUpdateDirectorById(@RequestBody Director d, @PathVariable String id) {

    return repository.findById(id)
      .map(director -> {
        director.setName(d.getName());
        director.setBirth(d.getBirth());
        director.setCountry(d.getCountry());

        return repository.save(director);
      })
      .orElseGet(() -> {
        d.setId(id);
        return repository.save(d);
      });
  }

  @DeleteMapping("/directors/{id}")
  void removeDirectorById(@PathVariable String id) {
    repository.deleteById(id);
  }
}
