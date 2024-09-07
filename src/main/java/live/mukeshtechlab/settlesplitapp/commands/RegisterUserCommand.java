package live.mukeshtechlab.settlesplitapp.commands;

import java.util.List;

public class RegisterUserCommand implements Command {
    @Override
    public boolean matches(String input) {
        /* e.g: Register vinsmokesanji 003 namisswwaann */
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


    }
}
