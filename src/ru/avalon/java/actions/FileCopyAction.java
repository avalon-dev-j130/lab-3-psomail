package ru.avalon.java.actions;

import ru.avalon.java.Lab3;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileCopyAction implements Action {

    String source;
    String dest;

    public FileCopyAction(String source, String dest){

        this.source = source;
        this.dest = dest;
    }

    public void start(){
        new Thread(this).start();
    }

    @Override
    public void run() {

        boolean error = false;

        Path filenameSource = Paths.get(source);
        Path filenameDestination = Paths.get(dest);

        try {
            Files.copy(filenameSource, filenameDestination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            Lab3.errorStatus = true;
            System.out.println("Copying error");
            System.out.print("> ");
            Lab3.errorStatus = false;
            error = true;
        }

        if(!error) {
            System.out.println("Copying " + source + " to "+ dest + " completed");
            System.out.print("> ");
        }
    }

    @Override
    public void close() {
        source = null;
        dest = null;
    }
}
