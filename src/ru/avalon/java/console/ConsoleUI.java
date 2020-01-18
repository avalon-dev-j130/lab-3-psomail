package ru.avalon.java.console;

import ru.avalon.java.Commands;
import ru.avalon.java.IllegalCommand;

import java.io.Closeable;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Класс описывает текстовый человеко-машинный интерфейс.
 * 
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 * @param <E> тип данных, описывающий возможные команды.
 *            Дожен быть перечислением
 */
//public class ConsoleUI<E extends Enum<E>> extends EnumReader<E> implements Runnable {
public class ConsoleUI implements Runnable, Closeable {


    /**
     * Флаг, указывающий на то, должен ли интерфейс
     * продолжать обрабатывать команды.
     * <p>
     * Переменная должна содержать значение false, чтобы
     * интрефейс продолжал получать команды из потомка.
     */
    private boolean exit;

    /**
     * Основной конструктор класса.
     * 
     * @param cls описатель перечисления, которое отражает
     *            набор команд, обрабатываемых интерфейсом
     */
//    public ConsoleUI(Class<E> cls) {
//        super(System.in, cls);
//    }

    /**
     * Выполняет обработку следующей команды из потока.
     * <p>
     * Следующая команда, содержащаяся в потоке, связанном
     * с текущим объектом, передаётся на обрабтку в метод
     * onCommand.
     */
    protected void processCommand() {
//        try {
//            System.out.print("> ");
//            onCommand(next());
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }

        Scanner sc = new Scanner(System.in);
        System.out.print("> ");

        String commanStr = sc.nextLine();
        try {
            onCommand(new Commands(commanStr));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalCommand illegalCommand) {

            System.out.println("Такого я не умею");
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
    protected void onCommand(Commands command) throws IOException {}
    /**
     * {@inheritDoc}
     * @throws IOException 
     */
    @Override
    public void close() throws IOException {
        exit = true;
    }
}
