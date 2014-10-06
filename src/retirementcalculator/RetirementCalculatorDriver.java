package retirementcalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * RetirementCalulatorDriver to start Scene/Application
 * @author derekbarrera
 * @version 1.0
 */

public class RetirementCalculatorDriver extends Application {
    
    /**
     * Start method to create and invoke the Stage
     * 
     * @param stage Current stage
     * @throws Exception Catch
     */
    
    @Override
    public void start(Stage stage) throws Exception {
    
        Parent root = FXMLLoader.load(getClass().getResource("RetirementCalculatorLayout.fxml"));
        
        //Set scene size, or the size will be the same as the contents of the Stage
        Scene scene = new Scene(root, 700, 500);
    
        stage.setTitle("Retirement Calc");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Main method to start program
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
