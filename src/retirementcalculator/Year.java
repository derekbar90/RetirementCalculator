/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package retirementcalculator;

/**
 *
 * @author derekbarrera
 */
public class Year {
    
    protected final int year;
    protected final double preTaxAmount;
    protected final double postTaxAmount;
    
    public Year(int year, double preTaxAmount, double postTaxAmount){
    
        this.year = year;
        this.preTaxAmount = preTaxAmount;
        this.postTaxAmount = postTaxAmount;
        
    }
    
    public String toString(){
    
        return year + " " + preTaxAmount + " " + postTaxAmount + "\n";
        
    }
    
}
