/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retirementcalculator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Save class to facilitate saving and loading of files.
 * 
 * @author derekbarrera
 */
public class Save implements Serializable {
    
    //Class Variables
    int    retirementAgeField, ageField;
    double incomeTaxRateField, capGainsTxRateField, preTaxBalanceField, postTaxBalanceField, 
           preTaxContField, postTaxContField, rateOfReturnField;
    
    /**
     * Blank Object creator
     * */
    public Save(){
    
    }
    
    /**
     * Save Constructor to hold information to be serialized into a file.
     * 
     * @param ageField              current Age
     * @param incomeTaxRateField    current incomeTaxRateField contents
     * @param retirementAgeField    current retirementAgeField contents
     * @param capGainsTxRateField   current capGainsTxRateField contents
     * @param preTaxBalanceField    current preTaxBalanceField contents
     * @param postTaxBalanceField   current postTaxBalanceField contents
     * @param preTaxContField       current preTaxContField contents
     * @param postTaxContField      current postTaxContField contents
     * @param rateOfReturnField     current rateOfReturnField contents
     * @param file                  current file to be written to. 
     */
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
        this.rateOfReturnField = rateOfReturnField;
  
    }
    
        
    /**
     * Save Constructor overload to hold information to be serialized into a file.
     * 
     * @param ageField              current Age
     * @param incomeTaxRateField    current incomeTaxRateField contents
     * @param retirementAgeField    current retirementAgeField contents
     * @param capGainsTxRateField   current capGainsTxRateField contents
     * @param preTaxBalanceField    current preTaxBalanceField contents
     * @param postTaxBalanceField   current postTaxBalanceField contents
     * @param preTaxContField       current preTaxContField contents
     * @param postTaxContField      current postTaxContField contents
     * @param rateOfReturnField     current rateOfReturnField contents
     * @param file                  current file to be written to. 
     */
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
        this.rateOfReturnField = rateOfReturnField;
        
        saveSerializer(file);
  
    }
    
    /**
     * Save serialized object to file in chosen file destination.
     * 
     * @param file 
     */
    private void saveSerializer(File file){
        
        //Set filePath to current chosen save directory  
        String filePath = file.toPath().toString();
        
        //Initialize save object
        Save savers;
        
        //Check to make sure that a current file has been selected
        if (file != null) {        
            
            //Try and create FileOutSteam
            try(FileOutputStream fileOut = new FileOutputStream(filePath)){

                //Create ObjectOutput Stream
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                
                //Write Object to ObjectOutputSteam, which writes to FileOutputStream
                out.writeObject(
                            
                    //Write Save object
                    savers = new Save(ageField, incomeTaxRateField, retirementAgeField, 
                                      capGainsTxRateField, preTaxBalanceField, postTaxBalanceField, preTaxContField, 
                                      postTaxContField, rateOfReturnField)
                );
                
//Close streams
                out.close();
                fileOut.close();
            
            } catch (IOException e) {
                
                System.out.println(e.getMessage());
            
            }
        }       
    }
    
    /**
     * Load a serialized file as a Save object and 
     * then return the new Save object
     * 
     * @param file                      Serialized file containing object to be read.
     * @return Save                     Save object containing the loaded object.
     * 
     * @throws ClassNotFoundException   Catch any errors that may occur from bring in object.
     */
    public Save loadSerialed(File file) throws ClassNotFoundException{
    
        Save input;
        Save output = null;
        
        try (FileInputStream fileIn = new FileInputStream(file)) {
            
            ObjectInputStream in = new ObjectInputStream(fileIn);
            
            //Read casted object into input
            input = (Save)in.readObject();
            
            output = new Save(input.ageField, input.incomeTaxRateField, input.retirementAgeField, 
                                         input.capGainsTxRateField, input.preTaxBalanceField, input.postTaxBalanceField, input.preTaxContField, 
                                         input.postTaxContField, input.rateOfReturnField);
            
            in.close();
            fileIn.close();
        
        }catch(IOException e){
            
            System.out.println(e.getMessage());
        
        }
    
        return output;
    }
    
}
