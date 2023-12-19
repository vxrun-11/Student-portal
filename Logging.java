package com.example.demo;
//used to create loggers,which are used to write log messages
import java.util.logging.Logger;
//defines severity level of log messages(INFO,SEVERE,WARNING,etc.,)
import java.util.logging.Level;
//responsible for sending log messages to appropriate output destination
import java.util.logging.Handler;
import java.util.logging.FileHandler;
import java.io.IOException;
class Logs2
{
    void func()
    {
        final Logger log = Logger.getLogger("Logs");
        log.setLevel(Level.WARNING);
        log.warning("WARNING");
    }


}

public class Logging
{
    static final Logger logger = Logger.getLogger("MyLogger");

    public static void main(String[] args)
    {
        Logs2 l = new Logs2();
        l.func();
        String a = "DA";
        try {
            Handler file = new FileHandler("Logfile.log", true);
            logger.addHandler(file);
        }
        catch(IOException e){
            System.err.println("Error creating file: "+e.getMessage());
            System.exit(1);
        }

        logger.setLevel(Level.SEVERE);
        logger.log(Level.WARNING,"ERROR",a);
        logger.severe("HELP!");
        logger.warning("WARNING!");
        logger.info("Informational message");

    }
}
