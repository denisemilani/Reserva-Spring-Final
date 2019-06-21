package movies;

class DirectorNotFoundException extends RuntimeException {

  DirectorNotFoundException(String id) {
    super("Could not find director " + id);
  }
}
