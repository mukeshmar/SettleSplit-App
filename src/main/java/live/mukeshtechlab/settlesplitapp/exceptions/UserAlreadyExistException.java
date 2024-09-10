package live.mukeshtechlab.settlesplitapp.exceptions;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message){
        super(message);
    }
}
