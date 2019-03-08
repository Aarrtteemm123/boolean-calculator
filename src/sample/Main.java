package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Logger logger = Logger.getLogger("MyLog");
        FileHandler fh;
        logger.setUseParentHandlers(false);

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("LogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            logger.info("Import library");
            logger.info("Import package");
            logger.info("Create logger");
            logger.info("Project start");

        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }



        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        logger.info("load fxml");
        primaryStage.setTitle("Boolean calculator");
        logger.info("Import package");
        Image icon = new Image(getClass().getResourceAsStream("logotipe.png"));
        logger.info("load image");
        primaryStage.getIcons().add(icon);
        logger.info("set image");
        primaryStage.setScene(new Scene(root, 492, 460));
        logger.info("load scene");
        primaryStage.show();
        logger.info("show scene");
        //10 logs
    }


    public static void main(String[] args) {
        launch(args);
    }
    // ALL 120 LOGS
}
