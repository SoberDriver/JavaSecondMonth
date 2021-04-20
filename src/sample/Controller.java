package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    TextField mainText;

    @FXML
    Label mainLabel;

    public void buttonAction(ActionEvent actionEvent) {
         mainLabel.setText(mainLabel.getText() + "\n" + mainText.getText());
         mainText.setText("");
    }

    public void fieldAction(ActionEvent actionEvent) {
        mainLabel.setText(mainLabel.getText() + "\n" + mainText.getText());
        mainText.setText("");
    }
}
