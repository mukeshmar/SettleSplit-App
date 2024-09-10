package live.mukeshtechlab.settlesplitapp.controllers;

import live.mukeshtechlab.settlesplitapp.dtos.userDto.RegisterUserRequestDto;
import live.mukeshtechlab.settlesplitapp.dtos.userDto.RegisterUserResponseDto;
import live.mukeshtechlab.settlesplitapp.exceptions.UserAlreadyExistException;
import live.mukeshtechlab.settlesplitapp.models.User;
import live.mukeshtechlab.settlesplitapp.services.userService.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto registerUserRequestDto) throws UserAlreadyExistException {

        RegisterUserResponseDto registerUserResponseDto = new RegisterUserResponseDto();
        User user = userService.registerUser(
                registerUserRequestDto.getName(),
                registerUserRequestDto.getPhoneNumber(),
                registerUserRequestDto.getPassword()
        );
        registerUserResponseDto.setName(user.getName());
        registerUserResponseDto.setPhoneNumber(user.getPhoneNumber());
        return registerUserResponseDto;
    }
}
