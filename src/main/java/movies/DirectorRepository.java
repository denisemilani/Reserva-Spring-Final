package movies;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DirectorRepository extends JpaRepository<Director, String> {

  @Query("select new movies.DirectorList(id, name) from Director")
  List<DirectorList> findAllLazy();
}
