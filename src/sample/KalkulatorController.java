package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class KalkulatorController {
    @FXML
    TextField valueTextField;
    String buttonText = "";
    String memory = "";
    String operator = "";


    @FXML
    public void handleDigitButton(ActionEvent event) {
        Button button = (Button) event.getSource();
        valueTextField.setText(valueTextField.getText() + button.getText());
    }

    @FXML
    public void handleDigitOperator(ActionEvent event) {
        String text = valueTextField.getText();
            if (!memory.equals("") && !valueTextField.equals("")) {
                this.calculateButton();
            }

            Button button = (Button) event.getSource();
            buttonText = button.getText();
            this.setOperator(buttonText);
            this.setMemory(valueTextField.getText());
            valueTextField.setText("");
    }

    @FXML
    public void calculateButton() {
        if (valueTextField.getText().isEmpty() || valueTextField.getText().equals("")) {

        } else {
            if (operator.equals("+")) {
                Double calculate = Double.parseDouble(this.memory) + Double.parseDouble(valueTextField.getText());
                valueTextField.setText(Double.toString(calculate));
            } else if (operator.equals("-")) {
                Double calculate = Double.parseDouble(this.memory) - Double.parseDouble(valueTextField.getText());
                valueTextField.setText(Double.toString(calculate));
            } else if (operator.equals("x")) {
                Double calculate = Double.parseDouble(this.memory) * Double.parseDouble(valueTextField.getText());
                valueTextField.setText(Double.toString(calculate));
            } else if (operator.equals("/")) {
                Double calculate = Double.parseDouble(this.memory) / Double.parseDouble(valueTextField.getText());
                valueTextField.setText(Double.toString(calculate));
            } else {
                valueTextField.setText("");
            }
        }
    }

    @FXML
    public void commaButton(ActionEvent event) {
        if (!valueTextField.getText().contains(".") && valueTextField.getText().length() != 0) {
            Button button = (Button) event.getSource();
            valueTextField.setText(valueTextField.getText() + button.getText());
        }
    }

    public void setOperator(String button){
        this.operator = button;
    }

    public void setMemory(String memory) {
        this.memory = valueTextField.getText();
    }

    public void clearButton() {
        this.memory = "";
        valueTextField.setText("");
    }
}
