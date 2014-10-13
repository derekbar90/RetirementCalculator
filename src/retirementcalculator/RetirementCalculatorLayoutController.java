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
 * FXML Controller class for Retirement Calculator
 *
 * @author derekbarrera
 */
public class RetirementCalculatorLayoutController {
        
    //TextArea Variable
    @FXML private TextArea calculationWindow;
    
    //TextField variables
    @FXML private TextField ageField, incomeTaxRateField, retirementAgeField, capGainsTxRateField, preTaxBalanceField,
                            postTaxBalanceField, preTaxContField, postTaxContField, rateOfReturnField;
   
    //Button vairable
    @FXML private Button calculateButton;
    
    //FileChooser object, for saving and loading
    private FileChooser fileChooser = new FileChooser();
    
    //Dialog Box
    Stage dialog = new Stage();

    /** 
     * ActionListener to calculate the remaining account balances based retirement age
     * 
     * @param event EventListener
     */
     @FXML private void calculate(ActionEvent event) {
        
        try{
           
            //Form validation
            if(Integer.parseInt(ageField.getText()) < Integer.parseInt(retirementAgeField.getText()) && Integer.parseInt(ageField.getText()) >= 0 && Integer.parseInt(retirementAgeField.getText()) >= 0){
            
                //Create new retirement object
                Retirement retirement = new Retirement(Integer.parseInt(ageField.getText()), Double.parseDouble(incomeTaxRateField.getText()), Integer.parseInt(retirementAgeField.getText()), 
                                                   Double.parseDouble(capGainsTxRateField.getText()), Double.parseDouble(preTaxBalanceField.getText()), Double.parseDouble(postTaxBalanceField.getText()), Double.parseDouble(preTaxContField.getText()), 
                                                   Double.parseDouble(postTaxContField.getText()), Double.parseDouble(rateOfReturnField.getText()));
                
                //Invoke calculate method from the newly instansiated Retirement object
                calculationWindow.setText(retirement.calculate(retirement));}
           
            else{
               
               //Disable calculate button
               calculateButton.setDisable(true);
               
           }
        }catch(NumberFormatException e){
        
            //Disable Calculation button
            calculateButton.setDisable(true);   
            
        }
    }
    
    /**
     * Save action listener. Invokes initialize method to double check
     * parameters validity and then prompts user with a dialog. Then creates 
     * a Save object which is then overloaded to pass current File object to be 
     * written.
     * 
     * @param event EventListener
     */
    @FXML private void save(ActionEvent event){
        
        try{
            
            if(initialize()){
            
                File file = fileChooser.showSaveDialog(dialog);
        
                //Use Save overloaded method to pass current file object to be created
                Save save = new Save(Integer.parseInt(ageField.getText()), Double.parseDouble(incomeTaxRateField.getText()), Integer.parseInt(retirementAgeField.getText()), 
                                     Double.parseDouble(capGainsTxRateField.getText()), Double.parseDouble(preTaxBalanceField.getText()), Double.parseDouble(postTaxBalanceField.getText()), 
                                     Double.parseDouble(preTaxContField.getText()), Double.parseDouble(postTaxContField.getText()), Double.parseDouble(rateOfReturnField.getText()), file);
            
            }
       
        }catch(NullPointerException e){
        
            System.out.println(e.getMessage());
            
        }
        
    }
      
    /**
     * Exit listener for menu system. 
     * Causes System.exit. 
     * 
     * @param event EventListener
     */
    @FXML protected void exit(ActionEvent event) {
        
        System.exit(0);
        
    }
    
    /**
     * Resets all current TextFields to null
     * 
     * @param event EventListener
     */ 
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
    
    
    /**
     * Prompts user with save dialog, which is then
     * loaded into loadFile. Contents of loadFile are then read
     * and the textFields are then set accordingly.
     * 
     * @param event EventListener
     * @throws ClassNotFoundException 
     */
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
    
    /**
     * Invokes Listener methods for form validation
     * 
     * @return boolean Validity of input
     */
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
    
    /** 
     * Check if ageField, is a valid input, disables
     * calculateButton if false.
     */
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
    
     /** 
     * Check if incomeTaxRateField, is a valid input, disables
     * calculateButton if false.
     */
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
    
     /** 
     * Check if retirementAgeField, is a valid input, disables
     * calculateButton if false.
     */
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
    
    /** 
     * Check if capGainsTxRateField, is a valid input, disables
     * calculateButton if false.
     */
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
    
    /** 
     * Check if preTaxBalanceField, is a valid input, disables
     * calculateButton if false.
     */
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
    
    /** 
     * Check if postTaxBalanceField, is a valid input, disables
     * calculateButton if false.
     */
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
    
    /** 
     * Check if preTaxContField, is a valid input, disables
     * calculateButton if false.
     */
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
    
    /** 
     * Check if postTaxContField, is a valid input, disables
     * calculateButton if false.
     */
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
    
    
    /** 
     * Check if rateOfReturnField, is a valid input, disables
     * calculateButton if false.
     */
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
