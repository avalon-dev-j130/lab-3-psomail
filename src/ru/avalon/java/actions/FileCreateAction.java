package ru.avalon.java.actions;

import ru.avalon.java.Lab3;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileCreateAction implements Action {

    String source;

    public FileCreateAction(String source){

        this.source = source;
    }

    public void start(){
        new Thread(this).start();
    }

    @Override
    public void run() {

        boolean error = false;

        Path filenameSource = Paths.get(source);

        try {
            if (Files.notExists(filenameSource)) {
                Files.createFile(filenameSource);
            }
            else {
                System.out.println("File " +  source + " already exists");
                System.out.print("> ");

            }
        } catch (IOException e) {
            Lab3.errorStatus = true;
            System.out.println("Creating error");
            System.out.print("> ");
            Lab3.errorStatus = false;
            error = true;
        }

        if(!error) {
            System.out.println("Creating " + source + " completed");
            System.out.print("> ");
        }
    }

    @Override
    public void close() {
        source = null;

    }
}


