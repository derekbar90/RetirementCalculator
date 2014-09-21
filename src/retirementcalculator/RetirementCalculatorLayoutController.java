package RetirementCalculator;

import java.util.NoSuchElementException;
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
        
        //Text input variables
        @FXML private TextField ageField;
        @FXML private TextField incomeTaxRateField;
        @FXML private TextField retirementAgeField;
        @FXML private TextField capGainsTxRateField;
        @FXML private TextField preTaxBalanceField;
        @FXML private TextField postTaxBalanceField;
        @FXML private TextField preTaxContField;
        @FXML private TextField postTaxContField;
        @FXML private TextField rateOfReturnField;

        
        @FXML protected void calculate(ActionEvent event) {
            
           
            
        }  
        
        public int getAge(){
            
            int input = Integer.parseInt(ageField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public int getincomeTaxRate(){
            
            int input = Integer.parseInt(incomeTaxRateField.getText()); //numeric string to an int'
            
            return input;
            
        }
         
        public int getretirementAge(){
            
            int input = Integer.parseInt(retirementAgeField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public int getcapGainsTxRate(){
            
            int input = Integer.parseInt(capGainsTxRateField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public int getpreTaxBalanceField(){
            
            int input = Integer.parseInt(preTaxBalanceField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public int getpostTaxBalance(){
            
            int input = Integer.parseInt(postTaxBalanceField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public int getpreTaxContField(){
            
            int input = Integer.parseInt(preTaxContField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public int getpostTaxContField(){
            
            int input = Integer.parseInt(postTaxContField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public int getrateOfReturnField(){
            
            int input = Integer.parseInt(rateOfReturnField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        
    
}
