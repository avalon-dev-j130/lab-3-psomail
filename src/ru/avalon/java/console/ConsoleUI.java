package ru.avalon.java.console;

import ru.avalon.java.Commands;
import ru.avalon.java.IllegalCommand;
import java.io.Closeable;
import java.util.Scanner;

public class ConsoleUI implements Runnable, Closeable {

    private boolean exit;

    protected void processCommand() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("> ");
//        System.out.print("\u001b[30CSome text");

        String commandLine = scanner.nextLine();

        try{
            onCommand(new Commands(commandLine));
        }
        catch (IllegalCommand illegalCommand) {
            System.out.println(illegalCommand.getMessage());
         //   illegalCommand.printStackTrace();
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
