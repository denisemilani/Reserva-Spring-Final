package movies;

class MovieNotFoundException extends RuntimeException {

  MovieNotFoundException(String id) {
    super("Could not find movie " + id);
  }
}
