package retirementcalculator;

import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ProgressIndicator;
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
    @FXML private ProgressIndicator progessIndicatorObject = new ProgressIndicator();
    @FXML private LineChart<Integer,Integer> lineChart;
    final FileChooser fileChooser = new FileChooser();
    
    //Dialog Box
    Stage dialog = new Stage();

    @FXML protected void calculate(ActionEvent event) {
        
         Retirement retirement = new Retirement(Integer.parseInt(ageField.getText()), Double.parseDouble(incomeTaxRateField.getText()), Integer.parseInt(retirementAgeField.getText()), 
                      Double.parseDouble(capGainsTxRateField.getText()), Double.parseDouble(preTaxBalanceField.getText()), Double.parseDouble(postTaxBalanceField.getText()), Double.parseDouble(preTaxContField.getText()), 
                      Double.parseDouble(postTaxContField.getText()), Double.parseDouble(rateOfReturnField.getText()));

        calculationWindow.setText(retirement.calculate(retirement));
    
    }
    
    @FXML protected void progess(){
        
        double current = 0.0;
        current += .112;
       //progessIndicatorObject.setProgress(.112);
        
    }
    
      @FXML protected void save(ActionEvent event){
        
        File file = fileChooser.showOpenDialog(dialog);
        
        if (file != null) {
            
            
            
            
        }
        
    }
      
          @FXML protected void exit(ActionEvent event) {
        
        System.exit(0);
        
    }
    
    @FXML protected void open(ActionEvent event){
        
        File file = fileChooser.showOpenDialog(dialog);
       
        if (file != null) {
            
            
            
            
        }
        
    }
    
    public void initialize(){
    
        ageField.textProperty().addListener((observable, oldValue, newValue) -> {
    
           try{
               ageField.getText();
               calculationWindow.setText("GO YOU!");
           }
           catch(NumberFormatException e){
               
               calculationWindow.setText("NOPE");
           
           }
    
        });
    
    }
}
