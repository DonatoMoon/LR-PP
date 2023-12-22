package logs;

import java.io.IOException;
import java.util.logging.*;

public class LoggerSetup {
    public static void setupLogger() {
        Logger globalLogger = Logger.getLogger("");

        Handler[] handlers = globalLogger.getHandlers();
        for (Handler handler : handlers) {
            globalLogger.removeHandler(handler);
        }

        try {
            FileHandler fileHandler = new FileHandler("D:\\Politech\\3 sem\\PP\\LR-PP\\src\\logs\\log.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            EmailHandler emailHandler = new EmailHandler("t7458304@gmail.com", "ytsvyiojtculgvla", "t7458304@gmail.com", "Severe Log Alert");
            globalLogger.addHandler(emailHandler);
            globalLogger.addHandler(fileHandler);

            globalLogger.setLevel(Level.INFO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}