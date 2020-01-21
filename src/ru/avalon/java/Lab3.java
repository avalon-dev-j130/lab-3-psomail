package ru.avalon.java;

import ru.avalon.java.actions.FileCopyAction;
import ru.avalon.java.actions.FileCreateAction;
import ru.avalon.java.actions.FileDeleteAction;
import ru.avalon.java.actions.FileMoveAction;
import ru.avalon.java.console.ConsoleUI;

public class Lab3 extends ConsoleUI {

    static public boolean errorStatus = false;

    public static void main(String[] args) {
        new Lab3().run();
    }

        @Override
    protected void onCommand(Commands command){
        switch (command.comm) {
            case copy:

                new FileCopyAction(command.param[0], command.param[1]).start();

                System.out.println("> Copying started");

                break;

            case move:

                new FileMoveAction(command.param[0], command.param[1]).start();

                System.out.println("> Moving started");

                break;

            case exit:

                close();

                break;

            case delete:

                new FileDeleteAction(command.param[0]).start();

                System.out.println("> Deleting started");

                break;

            case createfile:

                new FileCreateAction(command.param[0]).start();

                System.out.println("> Creating started");

                break;
        }
    }
}
