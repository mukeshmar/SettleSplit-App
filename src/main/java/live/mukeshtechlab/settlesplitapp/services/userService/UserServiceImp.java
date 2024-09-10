package live.mukeshtechlab.settlesplitapp.services.userService;

import live.mukeshtechlab.settlesplitapp.exceptions.UserAlreadyExistException;
import live.mukeshtechlab.settlesplitapp.models.User;
import live.mukeshtechlab.settlesplitapp.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService  {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private UserRepository userRepository;
    public UserServiceImp(
            UserRepository userRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder
    ){
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User registerUser(String name, String phoneNumber, String password) throws UserAlreadyExistException {
        Optional<User> userOptional = userRepository.findByPhoneNumber(phoneNumber);
        if(userOptional.isPresent()){
            throw new UserAlreadyExistException("User with Name : " + name + " and Id: " + userOptional.get().getId());
        }
        User user = new User();
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        return userRepository.save(user);
    }
}
