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
public class ReservaController{
    private final ReservaRepository repository;

    ReservaController(ReservaRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/reservas")
    List<ReservaList> all() {
        return repository.findAllLazy();
    }

    @PostMapping("/reservas")
    Reservas addReserva(@RequestBody Reservas reserva) {
    	System.out.println("---------------------------------------------------------------------------------");
    	System.out.println("Estou no addReserva ReservaController");
    	System.out.println("---------------------------------------------------------------------------------");
        return repository.save(reserva);
    }

    @GetMapping("/reservas/{id}")
    Reservas getReservaById(@PathVariable String id) {
        return repository.findById(id)
                .orElseThrow(() -> new ReservaNotFoundException(id));
    }

    @PutMapping("/reservas/{id}")
    Reservas addOrUpdateReservaById(@RequestBody Reservas r, @PathVariable String id) {

        return repository.findById(id)
                .map(reserva -> {
                    reserva.setId(r.getId());
                    reserva.setNome(r.getNome());
                    reserva.setSala(r.getSala());
                    reserva.setData(r.getData());
                    reserva.setHorario(r.getHorario());
                    return repository.save(reserva);
                })
                .orElseGet(() -> {
                    r.setId(id);
                    return repository.save(r);
                });
    }

    @DeleteMapping("/reservas/{id}")
    void removeReservaById(@PathVariable String id) {
        repository.deleteById(id);
    }
}
