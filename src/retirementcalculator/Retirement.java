/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retirementcalculator;

import java.util.ArrayList;

/**
 * Retirement class to create retirement output and manipulation
 * 
 * @author derekbarrera
 */

public class Retirement {
    
    // Class variables
    protected int    retirementAgeField, ageField;
    protected double incomeTaxRateField, capGainsTxRateField, preTaxBalanceField, postTaxBalanceField, 
                     preTaxContField, postTaxContField, rateOfReturnField;
    
    protected ArrayList<Year> retirement = new ArrayList<>();
    protected Year year;
    private String retirementPlan;
    
    /** 
     * Retirement object creation.
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
     */
    public Retirement(int ageField, double incomeTaxRateField, int retirementAgeField, 
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
     * Reads input from Retirement object, iterating through
     * calculating the next years balance, while adding Year
     * objects during each iteration.
     * 
     * @param retirementObject Current retirement plan
     * @return String          Contains fully concatenated retirement plan
     */
    protected String calculate(Retirement retirementObject) {
        
        int currentYear = 0;
        int loopSize = retirementAgeField - ageField;
        String output = "";
        
        for (int i = 0; i <= loopSize; i++) {
            
            currentYear = i + 1;
            
            if(i == 0){
                
                retirement.add(new Year(currentYear, preTaxBalanceField, postTaxBalanceField));
                
            }else if(i == loopSize){
                
                Year prevYear = getPreviousYear();
                double preTaxAmnt = preTaxIncomeTaxCalculation(preTaxCalculation(prevYear.preTaxAmount));
                double postTaxAmnt = postTaxCalcuation(prevYear.postTaxAmount);
                
                retirement.add(new Year(currentYear, preTaxAmnt, postTaxAmnt));
                output = toString();
                retirement.clear();
                
            }
            else{
                
                Year prevYear = getPreviousYear();
                double preTaxAmnt = preTaxCalculation(prevYear.preTaxAmount);
                double postTaxAmnt = postTaxCalcuation(prevYear.postTaxAmount);
                
                retirement.add(new Year(currentYear, preTaxAmnt, postTaxAmnt));
                
            }
            
        }
        
        return output;
        
    }
    
    /** 
     * Grabs the last object in the list
     * 
     * @return previous/last Year object
     */
    public Year getPreviousYear(){
        
        int arraysize = retirement.size();
        
        if (arraysize != 0) {
            
            arraysize -= 1;
            
        }
        
        return retirement.get(arraysize);
        
    }
    
    /**
     * Calculate pre Tax Income Tax
     * 
     * @param  x previous year preTaxBalance
     * @return   income tax calculation
     */
    public double preTaxIncomeTaxCalculation(double x){
        
        double preTax = x - (x * incomeTaxRateField);
        
        return preTax;
        
    }
    
    /**
     * Calculate pre Tax
     * 
     * @param  x previous year preTaxBalance
     * @return   preTax calculation
     */
    public double preTaxCalculation(double x){
        
        double preTax = x * (1 + rateOfReturnField) + (12 * preTaxContField);
        
        return preTax;
        
    }   
    
    /**
     * Calculate post Tax Balance
     * 
     * @param  x previous year postTaxBalance
     * @return   post Tax calculation
     */
    public double postTaxCalcuation(double x){
        
        double postTax = x * (1 + rateOfReturnField);
        double gain = (postTax - x  ) * capGainsTxRateField;
        double answer = postTax - gain + (12 * postTaxContField);
        
        return answer;
        
    }

    /**
     * Override for toString() method, providing a 
     * full print out for the retirement plan.
     * 
     * @return current retirement plan 
     */
    
    @Override
    public String toString(){
        
        retirementPlan = "Year" + "\t" + "PreTax Total" + "\t" + "PostTax Total" + "\t" + "Total" + "\n";
        
        for(int i = 0; i <= retirement.size() - 1; i++){
            
            Year currentYear = retirement.get(i);
            
            retirementPlan += currentYear;
            
        }
        return retirementPlan;
        
    }
    
}
