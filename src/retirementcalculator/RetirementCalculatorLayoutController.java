package retirementcalculator;

import java.util.ArrayList;
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
       
        //ArrayList containing year objects
        protected ArrayList<Year> retirement = new ArrayList();
        protected Year year;
        
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
           
            for (int i = 0; i <= loopSize; i++) {
                
                if(i == 0){
                
                    retirement.add(new Year(0, getpreTaxContField(), getpostTaxContField()));
                
                }else{
                
                    retirement.add(new Year(1,2.0,4.0));
                
                }
                
            }
            
            calculationWindow.setText(String.valueOf(retirement.size()));
            
        }  
        
        public double preTaxCalculation(){
        
            double preTax = 0.0;
            
             
            
            return preTax;
        }
        
        public double postTaxCalcuation(){
        
        
            return .0;
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
        
        public double getpreTaxBalanceField(){
            
            double input = Double.parseDouble(preTaxBalanceField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public double getpostTaxBalance(){
            
            double input = Double.parseDouble(postTaxBalanceField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public double getpreTaxContField(){
            
            double input = Double.parseDouble(preTaxContField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public double getpostTaxContField(){
            
            double input = Double.parseDouble(postTaxContField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        public double getrateOfReturnField(){
            
            double input = Double.parseDouble(rateOfReturnField.getText()); //numeric string to an int'
            
            return input;
            
        }
        
        
    
}
