package ru.avalon.java;

import java.util.Arrays;

public class Commands{

public enum Command {
    move,
    copy,
    delete,
    createfile,
    exit
}

public Command comm;
public String[] param;

public Commands (String input) throws IllegalCommand{

    String[] parts = input.trim().split(" +");

    switch (parts[0]) {
        case "copy" : comm = Command.copy;
                      if(parts.length != 3) throw new IllegalCommand("> Parameters error ");
            break;
        case "move" : comm = Command.move;
                      if(parts.length != 3) throw new IllegalCommand("> Parameters error ");
            break;

        case "delete" : comm = Command.delete;
            if(parts.length != 2) throw new IllegalCommand("> Parameters error ");
            break;

        case "createfile" : comm = Command.createfile;
            if(parts.length != 2) throw new IllegalCommand("> Parameters error ");
            break;

        case "exit" : comm = Command.exit;
            break;
        default: throw new IllegalCommand("> Unknown command " + input);
    }

    param = Arrays.copyOfRange(parts,1,parts.length);

}

    public String toString(){
        StringBuilder sb = new StringBuilder(comm.toString() + "Параметры: ");

        for(String s:param){
            sb.append(" ").append(s);
        }
        return sb.toString();
    }
}