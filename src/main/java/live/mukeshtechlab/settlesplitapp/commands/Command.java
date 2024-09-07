package live.mukeshtechlab.settlesplitapp.commands;

public interface Command {
    boolean matches(String input);
    void execute(String input);
}
