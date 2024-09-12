package live.mukeshtechlab.settlesplitapp;

import live.mukeshtechlab.settlesplitapp.commands.CommandExecutor;
import live.mukeshtechlab.settlesplitapp.commands.CreateExpenseCommand;
import live.mukeshtechlab.settlesplitapp.commands.RegisterUserCommand;
import live.mukeshtechlab.settlesplitapp.controllers.ExpenseController;
import live.mukeshtechlab.settlesplitapp.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SettleSplitAppApplication implements CommandLineRunner {
    @Autowired
    private UserController userController;
    @Autowired
    private ExpenseController expenseController;
    public static void main(String[] args) {
        SpringApplication.run(SettleSplitAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Register Command
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.addCommand(new RegisterUserCommand(userController));
        commandExecutor.addCommand(new CreateExpenseCommand(expenseController));
        while(true){
            System.out.println("Enter Command");
            String input = scanner.nextLine();
            commandExecutor.execute(input);
        }

    }
}
