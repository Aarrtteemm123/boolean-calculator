package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class Controller {

    Logger logger = Logger.getLogger("MyLog");
    FileHandler fh;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonFirstOperand;

    @FXML
    private Button buttonSecondOperand;

    @FXML
    private Button buttonFalse;

    @FXML
    private Button buttonTrue;

    @FXML
    private TextField textFieldFirstOperand;

    @FXML
    private TextField textFieldSecondOperand;

    @FXML
    private TextField textFieldResult;

    @FXML
    private Button buttonConstF;

    @FXML
    private Button buttonB;

    @FXML
    private Button buttonNotOrAB;

    @FXML
    private Button buttonNotA;

    @FXML
    private Button buttonAnd;

    @FXML
    private Button buttonAndBNotA;

    @FXML
    private Button buttonAEqualsB;

    @FXML
    private Button buttonImplicationAB;

    @FXML
    private Button buttonOr;

    @FXML
    private Button buttonA;

    @FXML
    private Button buttonNotB;

    @FXML
    private Button buttonNotAndAB;

    @FXML
    private Button buttonAndANotB;

    @FXML
    private Button buttonXor;

    @FXML
    private Button buttonImplicationBA;

    @FXML
    private Button buttonConstT;

    @FXML
    private RadioButton radioButtonFirstOperand;

    @FXML
    private RadioButton radioButtonSecondOperand;

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
        logger.info("Create fxml component");
    }

    @FXML
    void clickButtonDeleteFirstOperand(ActionEvent event) {
        textFieldFirstOperand.setText("");
        logger.info("clickButtonDeleteFirstOperand");

    }

    @FXML
    void clickButtonDeleteSecondOperand(ActionEvent event) {
        textFieldSecondOperand.setText("");
        logger.info(" clickButtonDeleteSecondOperand");

    }

    private Boolean toBoolean(String string) {
        if (string.equals("True"))
        {
            logger.info("Equals str to true");
            return true;
        }
        if (string.equals("False"))
        {
            logger.info("Equals str to false");
            return false;
        }
        logger.info("Equals str to null");
        return null;
    }

    @FXML
    void clickButtonA(ActionEvent event) {
        if (textFieldFirstOperand.getText().isEmpty())
        {
            logger.info("1 operand set text");
            textFieldResult.setText("Null");
        }
        else
        {
            logger.info("1 operand set text2");
            textFieldResult.setText(textFieldFirstOperand.getText());
        }

    }

    @FXML
    void clickButtonAEqualsB(ActionEvent event) {
        if (textFieldFirstOperand.getText().isEmpty() || textFieldSecondOperand.getText().
                isEmpty())

        {
            textFieldResult.setText("Null");
            logger.info("Set text null");
        }
        else {
            textFieldResult.setText(LogicOperation.toStringValue
                    (LogicOperation.AEqualsB(toBoolean(textFieldFirstOperand.getText()),
                            toBoolean(textFieldSecondOperand.getText()))));
            logger.info("Set text AEqualsB");
        }
    }

    @FXML
    void clickButtonAnd(ActionEvent event) {
        if (textFieldFirstOperand.getText().isEmpty() && textFieldSecondOperand.getText().
                isEmpty()) {
            textFieldResult.setText("Null");
            logger.info("clickButtonAnd null");
            return;
        }

        if (textFieldFirstOperand.getText().isEmpty()) {
            textFieldResult.setText(LogicOperation.toStringValue(LogicOperation.
                    and(toBoolean(textFieldSecondOperand.getText()))));
            logger.info("clickButtonAnd 1");
            return;
        }
        if (textFieldSecondOperand.getText().isEmpty()) {
            textFieldResult.setText(LogicOperation.toStringValue(LogicOperation.
                    and(toBoolean(textFieldFirstOperand.getText()))));
            logger.info("clickButtonAnd 2");
            return;
        }
        textFieldResult.setText(LogicOperation.toStringValue(LogicOperation.
                and(toBoolean(textFieldFirstOperand.getText()),
                        toBoolean(textFieldSecondOperand.getText()))));
        logger.info("clickButtonAnd 3");


    }

    @FXML
    void clickButtonAndANotB(ActionEvent event) {
        if (textFieldFirstOperand.getText().isEmpty() || textFieldSecondOperand.getText().
                isEmpty())
        {
            logger.info("clickButtonAndANotB 1");
            textFieldResult.setText("Null");
        }
        else {
            textFieldResult.setText(LogicOperation.toStringValue(LogicOperation.
                    andANotB(toBoolean(textFieldFirstOperand.getText()),
                            toBoolean(textFieldSecondOperand.getText()))));
            logger.info("clickButtonAndANotB 2");
        }
    }

    @FXML
    void clickButtonAndBNotA(ActionEvent event) {
        if (textFieldFirstOperand.getText().isEmpty() || textFieldSecondOperand.getText().
                isEmpty())
        {
            textFieldResult.setText("Null");
            logger.info("clickButtonAndBNotA 1");
        }
        else {
            textFieldResult.setText(LogicOperation.toStringValue(LogicOperation.
                    andANotB(toBoolean(textFieldSecondOperand.getText()),
                            toBoolean(textFieldFirstOperand.getText()))));
            logger.info("clickButtonAndBNotA 2");
        }

    }

    @FXML
    void clickButtonB(ActionEvent event) {
        if (textFieldSecondOperand.getText().isEmpty())
        {
            logger.info("clickButtonB 1");
            textFieldResult.setText("Null");
        }
        else
        {
            textFieldResult.setText(textFieldSecondOperand.getText());
            logger.info("clickButtonB 2");
        }


    }

    @FXML
    void clickButtonConstF(ActionEvent event) {
        textFieldResult.setText("False");
        logger.info("clickButtonConstF");
        logger.info("set text false");
    }

    @FXML
    void clickButtonConstT(ActionEvent event) {
        textFieldResult.setText("True");
        logger.info("clickButtonConstT");
        logger.info("set text true");
    }

    @FXML
    void clickButtonFalse(ActionEvent event) {
        if (radioButtonSecondOperand.isSelected())
        {
            textFieldSecondOperand.setText("False");
            logger.info(" clickButtonFalse 1");
        }
        if (radioButtonFirstOperand.isSelected())
        {
            textFieldFirstOperand.setText("False");
            logger.info(" clickButtonFalse 2");
        }

    }

    @FXML
    void clickButtonImplicationAB(ActionEvent event) {
        if (textFieldFirstOperand.getText().isEmpty() || textFieldSecondOperand.getText().
                isEmpty())
        {
            textFieldResult.setText("Null");
            logger.info("clickButtonImplicationAB 1");
        }
        else {
            textFieldResult.setText(LogicOperation.toStringValue(LogicOperation.
                    implicationAB(toBoolean(textFieldFirstOperand.getText()),
                            toBoolean(textFieldSecondOperand.getText()))));
            logger.info("clickButtonImplicationAB 2");
        }

    }

    @FXML
    void clickButtonImplicationBA(ActionEvent event) {
        if (textFieldFirstOperand.getText().isEmpty() || textFieldSecondOperand.getText().
                isEmpty())
        {
            textFieldResult.setText("Null");
            logger.info("clickButtonImplicationBA 1");
        }
        else {
            textFieldResult.setText(LogicOperation.toStringValue(LogicOperation.implicationAB
                    (toBoolean(textFieldSecondOperand.getText()),
                            toBoolean(textFieldFirstOperand.getText()))));
            logger.info("clickButtonImplicationBA 2");
        }

    }

    @FXML
    void clickButtonNotA(ActionEvent event) {
        textFieldResult.setText(LogicOperation.
                toStringValue(LogicOperation.notX
                        (toBoolean(textFieldFirstOperand.getText()))));
        logger.info("clickButtonNotA");

    }

    @FXML
    void clickButtonNotAndAB(ActionEvent event) {
        if (!textFieldFirstOperand.getText().isEmpty() && !textFieldSecondOperand.getText().
                isEmpty()) {
            textFieldResult.setText(LogicOperation.toStringValue(LogicOperation.notAndAB
                    (toBoolean(textFieldSecondOperand.getText()),
                            toBoolean(textFieldFirstOperand.getText()))));
            logger.info("clickButtonNotAndAB 1");
            return;
        }

        if (textFieldFirstOperand.getText().isEmpty() && textFieldSecondOperand.getText().
                isEmpty()) {
            textFieldResult.setText("Null");
            logger.info("clickButtonNotAndAB 2");
            return;
        }
        if (textFieldFirstOperand.getText().isEmpty()) {
            textFieldResult.setText(LogicOperation.toStringValue(LogicOperation.
                    notAndAB(toBoolean(textFieldSecondOperand.getText()))));
            logger.info("clickButtonNotAndAB 3");
            return;
        }
        textFieldResult.setText(LogicOperation.toStringValue(LogicOperation.
                notAndAB(toBoolean(textFieldFirstOperand.getText()))));
        logger.info("clickButtonNotAndAB 4");


    }

    @FXML
    void clickButtonNotB(ActionEvent event) {
        textFieldResult.setText(LogicOperation.
                toStringValue(LogicOperation.notX
                        (toBoolean(textFieldSecondOperand.getText()))));
        logger.info(" clickButtonNotB 1");


    }

    @FXML
    void clickButtonNotOrAB(ActionEvent event) {
        if (textFieldFirstOperand.getText().isEmpty() && textFieldSecondOperand.getText().
                isEmpty()) {
            logger.info("clickButtonNotOrAB 1");
            textFieldResult.setText("Null");
            return;
        }
        if (textFieldFirstOperand.getText().isEmpty()) {
            textFieldResult.setText(LogicOperation.toStringValue(LogicOperation.
                    notOrAB(toBoolean(textFieldSecondOperand.getText()))));
            logger.info("clickButtonNotOrAB 2");
            return;
        }
        if (textFieldSecondOperand.getText().isEmpty()) {
            textFieldResult.setText(LogicOperation.
                    toStringValue(LogicOperation.
                            notOrAB(toBoolean(textFieldFirstOperand.getText()))));
            logger.info("clickButtonNotOrAB 3");
            return;
        }
        textFieldResult.setText(LogicOperation.toStringValue
                (LogicOperation.notOrAB(toBoolean(textFieldFirstOperand.getText()),
                        toBoolean(textFieldSecondOperand.getText()))));
        logger.info("clickButtonNotOrAB 4");


    }

    @FXML
    void clickButtonOr(ActionEvent event) {
        if (textFieldFirstOperand.getText().isEmpty() && textFieldSecondOperand.getText().
                isEmpty()) {
            logger.info("clickButtonOr 1");
            textFieldResult.setText("Null");
            return;
        }
        if (!textFieldFirstOperand.getText().isEmpty() && !textFieldSecondOperand.getText().
                isEmpty()) {
            textFieldResult.setText(LogicOperation.toStringValue
                    (LogicOperation.or(toBoolean(textFieldFirstOperand.getText()),
                            toBoolean(textFieldSecondOperand.getText()))));
            logger.info("clickButtonOr 2");
            return;
        }
        if (textFieldFirstOperand.getText().isEmpty()) {
            textFieldResult.setText(LogicOperation.toStringValue
                    (LogicOperation.or(toBoolean(textFieldSecondOperand.getText()))));
            logger.info("clickButtonOr 3");
            return;
        }
        textFieldResult.setText(LogicOperation.toStringValue
                (LogicOperation.or(toBoolean(textFieldFirstOperand.getText()))));
        logger.info("clickButtonOr 4");


    }

    @FXML
    void clickButtonTrue(ActionEvent event) {
        if (radioButtonSecondOperand.isSelected()) {
            textFieldSecondOperand.setText("True");
            logger.info("clickButtonTrue 1");
        }
        if (radioButtonFirstOperand.isSelected()) {
            textFieldFirstOperand.setText("True");
            logger.info("clickButtonTrue 2");
        }
    }

    @FXML
    void clickButtonXor(ActionEvent event) {
        if (textFieldFirstOperand.getText().isEmpty() || textFieldSecondOperand.getText().
                isEmpty())
        {
            logger.info("clickButtonXor 1");
            textFieldResult.setText("Null");
        }
        else {
            textFieldResult.setText(LogicOperation.toStringValue
                    (LogicOperation.xOr(toBoolean(textFieldFirstOperand.getText()),
                            toBoolean(textFieldSecondOperand.getText()))));
            logger.info("clickButtonXor 1");
        }


    }

    @FXML
    void clickRadioButtonFirstOperand(ActionEvent event) {
        radioButtonFirstOperand.setSelected(true);
        logger.info("clickRadioButtonFirstOperand 1");
        radioButtonSecondOperand.setSelected(false);
        logger.info("clickRadioButtonFirstOperand 2");
    }

    @FXML
    void clickRadioButtonSecondOperand(ActionEvent event) {
        radioButtonFirstOperand.setSelected(false);
        logger.info("clickRadioButtonSecondOperand 1");
        radioButtonSecondOperand.setSelected(true);
        logger.info("clickRadioButtonSecondOperand 2");
    }

    @FXML
    void initialize() {
        assert buttonFalse != null : "fx:id=\"buttonFalse\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize but false");
        assert buttonTrue != null : "fx:id=\"buttonTrue\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize but true");
        assert textFieldFirstOperand != null : "fx:id=\"textFieldRirstOperand\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  textFieldFirstOperand");
        assert textFieldSecondOperand != null : "fx:id=\"textFieldSecondOperand\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  textFieldSecondOperand");
        assert textFieldResult != null : "fx:id=\"textFieldResult\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  textFieldResult");
        assert buttonConstF != null : "fx:id=\"buttonConstF\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  buttonConstF ");
        assert buttonB != null : "fx:id=\"buttonB\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  buttonB");
        assert buttonNotOrAB != null : "fx:id=\"buttonNotOrAB\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize buttonNotOrAB");
        assert buttonNotA != null : "fx:id=\"buttonNotA\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  buttonNotA");
        assert buttonAnd != null : "fx:id=\"buttonAnd\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  buttonAnd");
        assert buttonAndBNotA != null : "fx:id=\"buttonAndBNotA\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  buttonAndBNotA");
        assert buttonAEqualsB != null : "fx:id=\"buttonAEqualsB\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  buttonAEqualsB");
        assert buttonImplicationAB != null : "fx:id=\"buttonImplicationAB\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  buttonImplicationAB");
        assert buttonOr != null : "fx:id=\"buttonOr\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  buttonOr");
        assert buttonA != null : "fx:id=\"buttonA\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  buttonA");
        assert buttonNotB != null : "fx:id=\"buttonNotB\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  buttonNotB ");
        assert buttonNotAndAB != null : "fx:id=\"buttonNotAndAB\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  buttonNotAndAB");
        assert buttonAndANotB != null : "fx:id=\"buttonAndANotB\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  buttonAndANotB");
        assert buttonXor != null : "fx:id=\"buttonXor\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  buttonXor");
        assert buttonImplicationBA != null : "fx:id=\"buttonImplicationBA\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  buttonImplicationBA");
        assert buttonConstT != null : "fx:id=\"buttonConstT\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize buttonConstT");
        assert radioButtonFirstOperand != null : "fx:id=\"radioButtonFirstOperand\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  radioButtonFirstOperand");
        assert radioButtonSecondOperand != null : "fx:id=\"radioButtonSecondOperand\" was not injected: check your FXML file 'sample.fxml'.";
        logger.info("initialize  radioButtonSecondOperand");
    }
    //75 logs
}
