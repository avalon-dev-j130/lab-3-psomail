package ru.avalon.java;

import ru.avalon.java.actions.FileCopyAction;
import ru.avalon.java.actions.FileMoveAction;
import ru.avalon.java.console.ConsoleUI;

import java.io.IOException;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "Программирование на платформе Java. Разработка
 * многоуровневых приложений"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
//public class Lab3 extends ConsoleUI<Commands> {
    public class Lab3 extends ConsoleUI {
    /**
     * Точка входа в приложение.
     * 
     * @param args 
     */
    public static void main(String[] args) {
        new Lab3().run();


        new FileCopyAction("1.txt", "2.txt").start();
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
//    Lab3() {
//        super(Commands.class);
//    }


    /**
     * {@inheritDoc}
     */
//    @Override
//    protected void onCommand(Commands command) throws IOException {
//        switch (command) {
//            case copy:
//
//                /*
//                 * TODO №6 Обработайте команду copy
//                 */
//                close();
//
//                FileCopyAction fileCopy = new FileCopyAction();
//                fileCopy.start();
//                break;
//
//            case move:
//                /*
//                 * TODO №7 Обработайте команду move
//                 */
//                FileMoveAction fileMove = new FileMoveAction();
//                fileMove.start();
//                break;
//            case exit:
//                close();
//                break;
//                /*
//                 * TODO №9 Обработайте необработанные команды
//                 */
//        }
//    }


        @Override
    protected void onCommand(Commands command) throws IOException {
        switch (command.comm) {
            case copy:

                new FileCopyAction(command.param[0], command.param[0]).start();

                System.out.println("Запущено копирование");
                /*
                 * TODO №6 Обработайте команду copy
                 */

                break;

            case move:
                /*
                 * TODO №7 Обработайте команду move
                 */

                new FileMoveAction(command.param[0], command.param[0]).start();

                System.out.println("Запущено перемещение");

            case exit:
                close();
                break;
                /*
                 * TODO №9 Обработайте необработанные команды
                 */
        }
    }
    
}
