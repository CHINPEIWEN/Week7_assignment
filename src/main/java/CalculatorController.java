
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculatorController {

    @FXML private TextField number1Field;
    @FXML private TextField number2Field;
    @FXML private Label resultLabel;

    @FXML
    private void onCalculateClick() {
        try {
            double num1 = Double.parseDouble(number1Field.getText());
            double num2 = Double.parseDouble(number2Field.getText());

            double sum = num1 + num2;
            double product = num1 * num2;
            double difference = num1 - num2;
            double quotient = 0;
            boolean validDivision = true;

            if (num2 != 0) {
                quotient = num1 / num2;                       // new
            } else {
                validDivision = false;
            }

            String resultText = "Sum: " + sum + ", Product: " + product +
                ", Difference: " + difference;
            if (validDivision) {
                resultText += ", Quotient: " + quotient;
            } else {
                resultText += ", Quotient: Error (divide by 0)";
            }

            resultLabel.setText(resultText);

            ResultService.saveResult(num1, num2, sum, product, difference, validDivision ? quotient : null);

        } catch (NumberFormatException e) {
            resultLabel.setText("Please enter valid numbers!");
        }
    }
}
