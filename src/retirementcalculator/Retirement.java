/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retirementcalculator;

import java.util.ArrayList;

/**
 *
 * @author derekbarrera
 */

public class Retirement {
    
    int    retirementAgeField, ageField;
    double incomeTaxRateField, capGainsTxRateField, preTaxBalanceField, postTaxBalanceField, 
           preTaxContField, postTaxContField, rateOfReturnField;
    
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
    
    //ArrayList containing year objects
    protected ArrayList<Year> retirement = new ArrayList<>();
    protected Year year;
    private String retirementPlan;
  
    public boolean validate(){
    
               
    
        return true;
    
    }
    
    
    
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
                double preTaxAmnt = preTaxIncomeTaxCalculation(prevYear.preTaxAmount);
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
    
    public Year getPreviousYear(){
        
        int arraysize = retirement.size();
        
        if (arraysize != 0) {
            
            arraysize -= 1;
            
        }
        
        return retirement.get(arraysize);
        
    }
    
    public double preTaxIncomeTaxCalculation(double x){
        
        double preTax = x - (x * incomeTaxRateField);
        
        return preTax;
        
    }
    
    public double preTaxCalculation(double x){
        
        double preTax = x * (1 + rateOfReturnField) + (12 * preTaxContField);
        
        return preTax;
        
    }
    
    public double postTaxCalcuation(double x){
        
        double postTax = x * (1 + rateOfReturnField);
        double gain = (postTax - x) * capGainsTxRateField;
        double answer = postTax + gain + (12 * postTaxContField);
        
        return answer;
        
    }

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
