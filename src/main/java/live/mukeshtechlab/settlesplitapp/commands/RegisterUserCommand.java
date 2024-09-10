package live.mukeshtechlab.settlesplitapp.commands;

import live.mukeshtechlab.settlesplitapp.controllers.UserController;
import live.mukeshtechlab.settlesplitapp.dtos.userDto.RegisterUserRequestDto;
import live.mukeshtechlab.settlesplitapp.dtos.userDto.RegisterUserResponseDto;
import live.mukeshtechlab.settlesplitapp.exceptions.UserAlreadyExistException;

import java.util.List;

public class RegisterUserCommand implements Command {

    private UserController userController;

    public RegisterUserCommand(UserController userController){
        this.userController = userController;
    }

    @Override
    public boolean matches(String input) {
        /* e.g: Register vinsmokesanji +91123456789 namisswwaann */
        System.out.println("Checking if input matches RegisterUserCommand");
        List<String> words = List.of(input.split(" "));
        return words.size() == 4 && words.get(0).equals(CommandKeyWords.REGISTER_USER_COMMAND);
    }

    @Override
    public void execute(String input) {
        System.out.println("Executing RegisterUserCommand");
        List<String> words = List.of(input.split(" "));
        String userName = words.get(1);
        String phoneNumber = words.get(2);
        String password = words.get(3);
        System.out.println("Registering User: " + userName + " with Phone Number: " + phoneNumber + " and Password: " + password);

        RegisterUserRequestDto registerUserRequestDto = new RegisterUserRequestDto();
        registerUserRequestDto.setName(userName);
        registerUserRequestDto.setPhoneNumber(phoneNumber);
        registerUserRequestDto.setPassword(password);

        RegisterUserResponseDto registerUserResponseDto = userController.registerUser(registerUserRequestDto);
        System.out.println("############## Register Successfully ##############");
        System.out.println(registerUserResponseDto.toString());
    }
}
