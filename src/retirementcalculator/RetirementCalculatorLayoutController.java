package retirementcalculator;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author derekbarrera
 */
public class RetirementCalculatorLayoutController {
       
        //ArrayList containing year objects
        protected ArrayList<Year> retirement = new ArrayList<Year>();
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
        @FXML private ProgressIndicator progessIndicatorObject;

        @FXML protected void progess(ActionEvent event){
        
            double current = 0.0;
            current += .112;
            progessIndicatorObject.setProgress(.112);
        
        }
        
        @FXML protected void validate(ActionEvent event){
        
            
        
        }
        
        @FXML protected void calculate(ActionEvent event) {
            
           int age = getAge();
           int retirementAge = getretirementAge();
           int currentYear = 0;
           int loopSize = retirementAge - age; 
           
            for (int i = 0; i <= loopSize; i++) {
                
                currentYear = i + 1;
                
                if(i == 0){
                
                    retirement.add(new Year(currentYear, getpreTaxBalanceField(), getpostTaxBalance()));
                
                }else if(i == loopSize){
                    
                    Year prevYear = getPreviousYear();
                    double preTaxAmnt = preTaxIncomeTaxCalculation(prevYear.preTaxAmount);
                    double postTaxAmnt = postTaxCalcuation(prevYear.postTaxAmount);

                    retirement.add(new Year(currentYear, preTaxAmnt, postTaxAmnt));
                    
                }
                else{   
                    
                    Year prevYear = getPreviousYear();
                    double preTaxAmnt = preTaxCalculation(prevYear.preTaxAmount);
                    double postTaxAmnt = postTaxCalcuation(prevYear.postTaxAmount);
                    
                    retirement.add(new Year(currentYear, preTaxAmnt, postTaxAmnt));
                
                }
                
            }
            
            calculationWindow.setText(toString());
            
        }  
        
        public Year getPreviousYear(){
        
          int arraysize = retirement.size();
          
          if (arraysize != 0) {
                
            arraysize -= 1;
                
          }

          return retirement.get(arraysize);
            
        }
        
        public double preTaxIncomeTaxCalculation(double x){
        
            double preTax = x - (x * getincomeTaxRate());
            
            return preTax;
        
        }
        
        public double preTaxCalculation(double x){
            
            double preTax = x * (1 + getrateOfReturnField()) + (12 * getpreTaxContField());
            
            return preTax;
            
        }
        
        public double postTaxCalcuation(double x){
                    
            double postTax = x * (1 + getrateOfReturnField());
            double gain = (postTax - x) * getcapGainsTxRate();
            double answer = postTax + gain + (12 * getpostTaxContField());
            
            return answer;
        
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
        
        @Override
        public String toString(){
        
            String retirementPlan = "";
            retirementPlan = "Year" + "\t" + "PreTax Total" + "\t" + "PostTax Total" + "\t" + "Total" + "\n";
            
            for(int i = 0; i <= retirement.size() - 1; i++){
            
                Year currentYear = retirement.get(i);
                
                retirementPlan += currentYear;
            
            }
            
            return retirementPlan;
        
        }
    
}
