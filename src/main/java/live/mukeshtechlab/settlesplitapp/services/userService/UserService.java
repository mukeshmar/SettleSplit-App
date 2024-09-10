package live.mukeshtechlab.settlesplitapp.services.userService;

import live.mukeshtechlab.settlesplitapp.exceptions.UserAlreadyExistException;
import live.mukeshtechlab.settlesplitapp.models.User;

public interface UserService {
    User registerUser(String name, String phoneNumber, String password) throws UserAlreadyExistException;
}
