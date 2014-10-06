/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retirementcalculator;

import java.text.DecimalFormat;

/**
 * Year class to manage years of retirement via objects
 * 
 * @author derekbarrera
 */
public class Year {
    
    //Class variables
    protected int year;
    protected double preTaxAmount;
    protected double postTaxAmount;
    private double total;
    
    /** 
     * Year constructor, for creating retirement years
     * 
     * @param year          Current Year
     * @param preTaxAmount  Current preTaxAmont
     * @param postTaxAmount Current PostTaxAmount
     */
    public Year(int year, double preTaxAmount, double postTaxAmount){
    
        this.year = year;
        this.preTaxAmount = preTaxAmount;
        this.postTaxAmount = postTaxAmount;
        total = preTaxAmount + postTaxAmount;
        
    }
    
    /**
     * toString Override, providing String representation
     * of Year objects.
     * 
     * @return String Concatenated string with Year variables
     */
    
    @Override
    public String toString(){
    
        DecimalFormat dollar = new DecimalFormat("#");
        return year + "\t" + (dollar.format(preTaxAmount)) + "\t\t\t" + dollar.format(postTaxAmount) + "\t\t\t" + dollar.format(total) + "\n";
        
    }
    
}
