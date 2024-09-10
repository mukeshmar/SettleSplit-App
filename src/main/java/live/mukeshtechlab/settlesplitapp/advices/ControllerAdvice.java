package live.mukeshtechlab.settlesplitapp.advices;

import live.mukeshtechlab.settlesplitapp.exceptions.UserAlreadyExistException;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(UserAlreadyExistException.class)
    public String handleUserAlreadyExistException(UserAlreadyExistException e){
        return e.getMessage();
    }
}
