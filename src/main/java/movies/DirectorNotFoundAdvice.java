package movies;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class DirectorNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(DirectorNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String DirectorNotFoundHandler(DirectorNotFoundException ex) {
    return ex.getMessage();
  }
}
