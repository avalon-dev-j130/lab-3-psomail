package ru.avalon.java.console;

import ru.avalon.java.Commands;
import ru.avalon.java.IllegalCommand;

import java.io.Closeable;
import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements Runnable, Closeable {

    private boolean exit;

    protected void processCommand() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("> ");

        String commandLine = scanner.nextLine();

        try { onCommand(new Commands(commandLine));}
        catch (IllegalCommand illegalCommand) {
            System.out.println("Unknown command " + illegalCommand.getMessage());
            illegalCommand.printStackTrace();
        }
    }
    /**
     * Алгоритм обработки команд.
     */
    @Override
    public void run() {
        while (!exit) processCommand();
    }
    /**
     * Метод жизненного цикла класса.
     * <p>
     * Вызывается, когда от пользозвателя была получена
     * следующая команда.
     * 
     * @param command экземпляр перечисления E. Описывает
     *                пользовательскую команду.
     * 
     * @throws IOException в случае ощибки ввода вывода
     */
  //  protected void onCommand(E command) throws IOException {}
    protected void onCommand(Commands command){}
    /**
     * {@inheritDoc}
     * @throws IOException 
     */
    @Override
    public void close() {
        exit = true;
    }
}
