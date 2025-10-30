package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import java.util.Locale;
import java.util.ResourceBundle;

public class BMIController {

    @FXML
    private Label text;

    @FXML
    private Label text1;

    @FXML
    private TextField field;

    @FXML
    private TextField field1;

    @FXML
    private Button submit;

    @FXML
    private Text totaltxt;

    @FXML
    private Button en;

    @FXML
    private Button fr;

    @FXML
    private Button ur;

    @FXML
    private Button vi;

    private ResourceBundle bundle;

    @FXML
    private void initialize() {
        setLanguage("en");

        en.setOnAction(e -> setLanguage("en"));
        fr.setOnAction(e -> setLanguage("fr"));
        ur.setOnAction(e -> setLanguage("ur"));
        vi.setOnAction(e -> setLanguage("vi"));
    }

    @FXML
    private void updateBMI() {
        try {
            double height = Double.parseDouble(field.getText());
            double weight = Double.parseDouble(field1.getText());
            height = height/100;
            double bmi = weight / Math.pow(height, 2);
            String bmiFormatted = String.format(Locale.US, "%.1f", bmi);

            totaltxt.setText("Your BMI is: " + bmiFormatted);

        } catch (NumberFormatException e) {
            totaltxt.setText(bundle.getString("lblInvalid.text"));
        }
    }

    private void setLanguage(String langCode) {
        Locale locale;

        switch (langCode) {
            case "fr":
                locale = new Locale("fr", "FR");
                break;
            case "ur":
                locale = new Locale("ur", "PA");
                break;
            case "vi":
                locale = new Locale("vi", "VI");
                break;
            default:
                locale = new Locale("en", "US");
                break;
        }

        bundle = ResourceBundle.getBundle("Messages1", locale);
        text.setText(bundle.getString("lblHeight.text"));
        text1.setText(bundle.getString("lblWeight.text"));
        submit.setText(bundle.getString("btnCalculate.text"));
        totaltxt.setText(bundle.getString("lblResult.text"));
    }

    public static void main(String[] args) {
        view.BMI.launch(view.BMI.class);
    }
}
