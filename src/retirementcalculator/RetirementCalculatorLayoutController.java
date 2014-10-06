package retirementcalculator;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author derekbarrera
 */
public class RetirementCalculatorLayoutController {
        
    //TextArea Variable
    @FXML private TextArea calculationWindow;
    
    //Text input variables
    @FXML private TextField ageField, incomeTaxRateField, retirementAgeField, capGainsTxRateField, preTaxBalanceField,
                            postTaxBalanceField, preTaxContField, postTaxContField, rateOfReturnField;
    @FXML private Button calculateButton;
    
          private FileChooser fileChooser = new FileChooser();
    
    //Dialog Box
    Stage dialog = new Stage();

    @FXML protected void calculate(ActionEvent event) {
        
        try{
           if(Integer.parseInt(ageField.getText()) < Integer.parseInt(retirementAgeField.getText()) && Integer.parseInt(ageField.getText()) >= 0 && Integer.parseInt(retirementAgeField.getText()) >= 0){
            Retirement retirement = new Retirement(Integer.parseInt(ageField.getText()), Double.parseDouble(incomeTaxRateField.getText()), Integer.parseInt(retirementAgeField.getText()), 
                                                   Double.parseDouble(capGainsTxRateField.getText()), Double.parseDouble(preTaxBalanceField.getText()), Double.parseDouble(postTaxBalanceField.getText()), Double.parseDouble(preTaxContField.getText()), 
                                                   Double.parseDouble(postTaxContField.getText()), Double.parseDouble(rateOfReturnField.getText()));
           
            calculationWindow.setText(retirement.calculate(retirement));}
           else{
               
               calculateButton.setDisable(true);
               
           }
        }catch(NumberFormatException e){
        
            calculateButton.setDisable(true);   
            
        }
    }
    
    @FXML protected void save(ActionEvent event){
        
        try{
            if(initialize()){
            
                File file = fileChooser.showSaveDialog(dialog);
        
            Save save = new Save(Integer.parseInt(ageField.getText()), Double.parseDouble(incomeTaxRateField.getText()), Integer.parseInt(retirementAgeField.getText()), 
                Double.parseDouble(capGainsTxRateField.getText()), Double.parseDouble(preTaxBalanceField.getText()), Double.parseDouble(postTaxBalanceField.getText()), 
                Double.parseDouble(preTaxContField.getText()), Double.parseDouble(postTaxContField.getText()), Double.parseDouble(rateOfReturnField.getText()), file);
            
            }
       
        }catch(NullPointerException e){
        
        
        }
        
    }
      
    @FXML protected void exit(ActionEvent event) {
        
        System.exit(0);
        
    }
    
     @FXML protected void reset(ActionEvent event) {
        
            ageField.setText("");
            incomeTaxRateField.setText("");
            retirementAgeField.setText("");
            capGainsTxRateField.setText("");
            preTaxBalanceField.setText("");
            postTaxBalanceField.setText("");
            preTaxContField.setText("");
            postTaxContField.setText("");
            rateOfReturnField.setText("");
        
    }
    
    @FXML protected void open(ActionEvent event) throws ClassNotFoundException{
        
        File file = fileChooser.showOpenDialog(dialog);
        
        if (file != null) {
            
            Save loadFile = new Save();
            loadFile = loadFile.loadSerialed(file);  
             
            ageField.setText(String.valueOf(loadFile.ageField));
            incomeTaxRateField.setText(String.valueOf(loadFile.incomeTaxRateField));
            retirementAgeField.setText(String.valueOf(loadFile.retirementAgeField));
            capGainsTxRateField.setText(String.valueOf(loadFile.capGainsTxRateField));
            preTaxBalanceField.setText(String.valueOf(loadFile.preTaxBalanceField));
            postTaxBalanceField.setText(String.valueOf(loadFile.postTaxBalanceField));
            preTaxContField.setText(String.valueOf(loadFile.preTaxContField));
            postTaxContField.setText(String.valueOf(loadFile.postTaxContField));
            rateOfReturnField.setText(String.valueOf(loadFile.rateOfReturnField));
            
        }
        
    }
    
    public boolean initialize(){
        
        boolean bool = false;
        try{
            
            ageValidation();
            incomeTaxRateFieldValidation();
            retirementAgeFieldValidation();
            capGainsTxRateFieldValidation();
            preTaxBalanceFieldValidation();
            postTaxBalanceFieldValidation();
            preTaxContFieldValidation();
            postTaxContFieldValidation();
            rateOfReturnFieldValidation();
            
            bool = true;    
       
        }catch(NumberFormatException e){
            
        }
        
        return bool;
        
    }
    
    private void ageValidation(){

        ageField.textProperty().addListener((observable, oldValue, newValue) -> {
            
            try{
                
                if(Integer.parseInt(ageField.getText()) < Integer.parseInt(retirementAgeField.getText()) && Integer.parseInt(ageField.getText()) >= 0 && Integer.parseInt(retirementAgeField.getText()) >= 0){
                    
                    Integer.parseInt(ageField.getText());
                    calculateButton.setDisable(false);
                
                }else{
                
                    calculateButton.setDisable(true);
                
                }
                
            }
            catch(NumberFormatException e){

                calculateButton.setDisable(true);
            }
            
        });
        
    }
    
    private void incomeTaxRateFieldValidation(){

        incomeTaxRateField.textProperty().addListener((observable, oldValue, newValue) -> {
            
            try{
                Double.parseDouble(incomeTaxRateField.getText());
                calculateButton.setDisable(false);
                
            }
            catch(NumberFormatException e){

                calculateButton.setDisable(true);                
            }
        
        });
        
    }
    
    private void retirementAgeFieldValidation(){

        retirementAgeField.textProperty().addListener((observable, oldValue, newValue) -> {
            
            try{
                
                if(Integer.parseInt(ageField.getText()) > Integer.parseInt(retirementAgeField.getText()) && Integer.parseInt(ageField.getText()) >= 0 && Integer.parseInt(retirementAgeField.getText()) >= 0){
                    
                    calculateButton.setDisable(true);
                
                }else{
                
                    calculateButton.setDisable(false);
                
                }
                
                
            }
            catch(NumberFormatException e){

                calculateButton.setDisable(true);                
            }
            
        });
        
    }
    
    private void capGainsTxRateFieldValidation(){

        capGainsTxRateField.textProperty().addListener((observable, oldValue, newValue) -> {
            
            try{
                Double.parseDouble(capGainsTxRateField.getText());
                calculateButton.setDisable(false);
                
            }
            catch(NumberFormatException e){

                calculateButton.setDisable(true);                
            }
            
        });
        
    }
    
    private void preTaxBalanceFieldValidation(){

        preTaxBalanceField.textProperty().addListener((observable, oldValue, newValue) -> {
            
            try{
                Double.parseDouble(preTaxBalanceField.getText());
                calculateButton.setDisable(false);
                
            }
            catch(NumberFormatException e){

                calculateButton.setDisable(true);                
            }
            
        });
        
    }
    
    private void postTaxBalanceFieldValidation(){

        postTaxBalanceField.textProperty().addListener((observable, oldValue, newValue) -> {
            
            try{
                Double.parseDouble(postTaxBalanceField.getText());
                calculateButton.setDisable(false);
                
            }
            catch(NumberFormatException e){

                calculateButton.setDisable(true);                
            }
            
        });
        
    }
    
    private void preTaxContFieldValidation(){

        preTaxContField.textProperty().addListener((observable, oldValue, newValue) -> {
            
            try{
                Double.parseDouble(preTaxContField.getText());
                calculateButton.setDisable(false);
                
            }
            catch(NumberFormatException e){

                calculateButton.setDisable(true);                
            }
            
        });
        
    }
    
    private void postTaxContFieldValidation(){

        postTaxContField.textProperty().addListener((observable, oldValue, newValue) -> {
            
            try{
                Double.parseDouble(postTaxContField.getText());
                calculateButton.setDisable(false);
                
            }
            catch(NumberFormatException e){

                calculateButton.setDisable(true);                
            }
            
        });
        
    }
    
    private void rateOfReturnFieldValidation(){

        rateOfReturnField.textProperty().addListener((observable, oldValue, newValue) -> {
            
            try{
                Double.parseDouble(rateOfReturnField.getText());
                calculateButton.setDisable(false);
                
            }
            catch(NumberFormatException e){

                calculateButton.setDisable(true);                
            }
            
        });
        
    }
    
    
}
