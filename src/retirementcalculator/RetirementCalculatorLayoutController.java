package RetirementCalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author derekbarrera
 */
public class RetirementCalculatorLayoutController {
        
        @FXML private TextArea calculationWindow;
        @FXML private final String string = "This";
        @FXML private final String new_string = " is working!";
        
        @FXML private TextField ageField;
        @FXML private TextField incomeTaxRateField;
        @FXML private TextField retirementAgeField;
        @FXML private TextField capGainsTxRateField;
        @FXML private TextField preTaxBalanceField;
        @FXML private TextField postTaxBalanceField;
        @FXML private TextField preTaxContField;
        @FXML private TextField postTaxContField;
        @FXML private TextField rateOfReturnField;
        
        
         
         
        @FXML protected void ageFieldGetter(ActionEvent event) {
            
            calculationWindow.setText(string);
            calculationWindow.appendText(new_string);
            calculationWindow.appendText(ageField.getText());
            
        }  
    
}
