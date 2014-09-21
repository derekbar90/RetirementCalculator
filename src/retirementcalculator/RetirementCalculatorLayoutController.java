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
        
        //TextArea Variable    
        @FXML private TextArea calculationWindow;
        
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
            
           int age = getAge();
           int retirementAge = getretirementAge();
           
           int loopSize = retirementAge - age; 
           
            for (int i = 0; i < loopSize; i++) {
                
                
                
            }
            
        }  
        
        public int getAge(){
            
            int input = Integer.parseInt(ageField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public int getretirementAge(){
            
            int input = Integer.parseInt(retirementAgeField.getText());
            
            return input;
            
        }
        
        public double getincomeTaxRate(){
            
            double input = Double.parseDouble(incomeTaxRateField.getText());
            
            return input;
            
        }
        
        public double getcapGainsTxRate(){
            
            double input = Double.parseDouble(capGainsTxRateField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public int getpreTaxBalanceField(){
            
            double input = Double.parseDouble(preTaxBalanceField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public int getpostTaxBalance(){
            
            double input = Double.parseDouble(postTaxBalanceField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public int getpreTaxContField(){
            
            double input = Double.parseDouble(preTaxContField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public int getpostTaxContField(){
            
            double input = Double.parseDouble(postTaxContField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public int getrateOfReturnField(){
            
            double input = Double.parseDouble(rateOfReturnField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        
    
}
