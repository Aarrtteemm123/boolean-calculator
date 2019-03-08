package sample;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogicOperation {

    static Logger logger = Logger.getLogger("MyLog");
    FileHandler fh;

    private void log()
    {
        logger.setUseParentHandlers(false);

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("LogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean and(boolean x1, boolean x2) {
        logger.info("Use and");
        if (x1 == true && x2 == true)
        {
            logger.info("return true");
            return true;
        }
        logger.info("return false");
        return false;
    }

    public static Boolean and(boolean x) {
        logger.info("Use and 2");
        if (x == true)
        {
            logger.info("return null");
            return null;
        }
        logger.info("return false");
        return false;
    }

    public static Boolean or(boolean x1, boolean x2) {
        logger.info("Use or");
        if (x1 == true || x2 == true)
        {
            logger.info("return true");
            return true;
        }
        logger.info("return false");
        return false;
    }

    public static Boolean or(boolean x) {
        logger.info("Use or 2");
        if (x == true)
        {
            logger.info("return true");
            return true;
        }
        logger.info("return null");
        return null;
    }

    public static Boolean andANotB(boolean a, boolean b) {
        logger.info("Use andANotB");
        if (a == true && b == false)
        {
            logger.info("return true");
            return true;
        }
        logger.info("return false");
        return false;
    }

    public static Boolean xOr(boolean a, boolean b) {
        logger.info("Use xOr");
        if (a == b)
        {
            logger.info("return false");
            return false;
        }
        logger.info("return true");
        return true;
    }

    public static Boolean notOrAB(boolean a, boolean b) {
        logger.info("Use notOrAB");
        return !or(a, b);
    }

    public static Boolean notOrAB(boolean x) {
        logger.info("Use notOrAB 2");
        if (or(x) == null)
        {
            logger.info("return null");
            return null;
        }
        return !or(x);
    }

    public static Boolean AEqualsB(boolean a, boolean b) {
        logger.info("Use AEqualsB");
        return !xOr(a, b);
    }

    public static Boolean notX(Boolean x) {
        logger.info("Use notX");
        if (x == null)
        {
            logger.info("return null");
            return null;
        }
        logger.info("return !x");
        return !x;
    }

    public static Boolean implicationAB(boolean a, boolean b) {
        logger.info("Use implicationAB");
        if (a == true && b == false)
        {
            logger.info("return false");
            return false;
        }
        logger.info("return true");
        return true;
    }

    public static Boolean notAndAB(boolean a, boolean b) {
        logger.info("Use notAndAB");
        return !and(a, b);
    }

    public static Boolean notAndAB(boolean x) {
        logger.info("Use notAndAB 2");
        if (x == true)
        {
            logger.info("return null");
            return null;
        }
        logger.info("return true");
        return true;
    }

    public static String toStringValue(Boolean x) {
        logger.info("Use toStringValue");
        if (x == null)
        {
            logger.info("return Null");
            return "Null";
        }
        if (x == true)
        {
            logger.info("return True");
            return "True";
        }
        logger.info("return False");
        return "False";
    }
    //35 logs
}
