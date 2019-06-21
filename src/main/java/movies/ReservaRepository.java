package movies;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReservaRepository extends JpaRepository<Reservas, String> {

    @Query("select new movies.ReservaList(id, nome, data, horario, sala, codcancela) from Reservas")
    List<ReservaList> findAllLazy();
}
