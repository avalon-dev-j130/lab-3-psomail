package ru.avalon.java.actions;

import java.io.*;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    /**
     * {@inheritDoc}
     */
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
        /*
         * TODO №4 Реализуйте метод run класса FileMoveAction
         */

  //      File sourse = new File(sourse);
 //       try(InputStream inputStream = new FileInputStream(sourse)){

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

        System.out.println("Копирование " + source.getAbsolutePath() + "\n в " +  dest.getAbsolutePath() + " завершено");

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
        }
      //  throw new UnsupportedOperationException("Not implemented yet!");
    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №5 Реализуйте метод close класса FileMoveAction
         */
        source = null;
        dest = null;
       // throw new UnsupportedOperationException("Not implemented yet!");
    }

}
