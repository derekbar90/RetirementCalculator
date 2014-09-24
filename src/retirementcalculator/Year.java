/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retirementcalculator;

import java.text.DecimalFormat;

/**
 *
 * @author derekbarrera
 */
public class Year {
    
    protected final int year;
    protected final double preTaxAmount;
    protected final double postTaxAmount;
    private final double total;
    
    public Year(int year, double preTaxAmount, double postTaxAmount){
    
        this.year = year;
        this.preTaxAmount = preTaxAmount;
        this.postTaxAmount = postTaxAmount;
        total = preTaxAmount + postTaxAmount;
        
    }
    
    public String toString(){
    
        DecimalFormat dollar = new DecimalFormat("#");
        return year + "\t" + (dollar.format(preTaxAmount)) + "\t\t\t" + dollar.format(postTaxAmount) + "\t\t\t" + dollar.format(total) + "\n";
        
    }
    
}
