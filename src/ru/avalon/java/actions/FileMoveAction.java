package ru.avalon.java.actions;

import java.io.*;

public class FileMoveAction implements Action {

    File source;
    File dest;

    public FileMoveAction(String source, String dest){

        this.source = new File(source);
        this.dest = new File(dest);
    }

    public void start(){
        new Thread(this).start();
        System.out.println("Start thread");
    }

    @Override
    public void run() {

    try( InputStream is = new FileInputStream(source);
         OutputStream os = new FileOutputStream(dest)){
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            os.flush();
            is.close();
            source.delete();
            System.out.println("Copying " + source.getAbsolutePath() + "\n to " +  dest.getAbsolutePath() + " completed");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {

        source = null;
        dest = null;
    }
}
