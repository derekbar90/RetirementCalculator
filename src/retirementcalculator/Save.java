/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retirementcalculator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;

/**
 *
 * @author derekbarrera
 */
public class Save implements Serializable {
    
    int    retirementAgeField, ageField;
    double incomeTaxRateField, capGainsTxRateField, preTaxBalanceField, postTaxBalanceField, 
           preTaxContField, postTaxContField, rateOfReturnField;
    
    public Save(int ageField, double incomeTaxRateField, int retirementAgeField, 
                      double capGainsTxRateField, double preTaxBalanceField, double postTaxBalanceField, double preTaxContField, 
                      double postTaxContField, double rateOfReturnField, File file){
        
        this.ageField = ageField;
        this.incomeTaxRateField = incomeTaxRateField;
        this.retirementAgeField = retirementAgeField;
        this.capGainsTxRateField = capGainsTxRateField;
        this.preTaxBalanceField = preTaxBalanceField;
        this.postTaxBalanceField = postTaxBalanceField;
        this.preTaxContField = preTaxContField;
        this.postTaxContField = postTaxContField;
        this.rateOfReturnField = rateOfReturnField - 1.0;
        
        saveSerializer(file);
  
    }
    
    public Save(int ageField, double incomeTaxRateField, int retirementAgeField, 
                      double capGainsTxRateField, double preTaxBalanceField, double postTaxBalanceField, double preTaxContField, 
                      double postTaxContField, double rateOfReturnField){
        
        this.ageField = ageField;
        this.incomeTaxRateField = incomeTaxRateField;
        this.retirementAgeField = retirementAgeField;
        this.capGainsTxRateField = capGainsTxRateField;
        this.preTaxBalanceField = preTaxBalanceField;
        this.postTaxBalanceField = postTaxBalanceField;
        this.preTaxContField = preTaxContField;
        this.postTaxContField = postTaxContField;
        this.rateOfReturnField = rateOfReturnField - 1.0;
  
    }
    
    public void saveSerializer(File file){
        
        Charset chars = Charset.forName("US-ASCII");
    
        String filePath = file.toPath().toString();
        System.out.println(filePath);
        Save savers;
        
            if (file != null) {        
            
                try {
                    
                    FileOutputStream fileOut =
                    new FileOutputStream(filePath);
                    ObjectOutputStream out = new ObjectOutputStream(fileOut);
                    out.writeObject(
                            
                        savers = new Save(ageField, incomeTaxRateField, retirementAgeField, 
                                         capGainsTxRateField, preTaxBalanceField, postTaxBalanceField, preTaxContField, 
                                         postTaxContField, rateOfReturnField)
                    );
                    out.close();
                    fileOut.close();
                    System.out.printf("Serialized data is saved in" + filePath);
            
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }       
    }
    
}
