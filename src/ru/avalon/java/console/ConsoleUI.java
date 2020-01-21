package ru.avalon.java.console;

import ru.avalon.java.Commands;
import ru.avalon.java.IllegalCommand;
import ru.avalon.java.Lab3;

import java.io.Closeable;
import java.util.Scanner;

public class ConsoleUI implements Runnable, Closeable {

    private boolean exit;

    protected void processCommand() {

        Scanner scanner = new Scanner(System.in);

       if(!Lab3.errorStatus) System.out.print("> ");

        String commandLine = scanner.nextLine();

        try{
            onCommand(new Commands(commandLine));
        }
        catch (IllegalCommand illegalCommand) {
            System.out.println(illegalCommand.getMessage());
        }
    }

    @Override
    public void run() {
        while (!exit) processCommand();
    }

    protected void onCommand(Commands command){}

    @Override
    public void close() {
        exit = true;
    }
}
