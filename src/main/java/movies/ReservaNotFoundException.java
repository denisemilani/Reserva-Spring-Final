package movies;

class ReservaNotFoundException extends RuntimeException {

    ReservaNotFoundException(String id) {
        super("Não foi possível achar a reserva: " + id);
    }
}
