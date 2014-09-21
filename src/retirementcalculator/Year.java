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
    
    private final int year;
    private final double preTaxAmount;
    private final double postTaxAmount;
    private final double total;
    
    public Year(int year, double preTaxAmount, double postTaxAmount, double total){
    
        this.year = year;
        this.preTaxAmount = preTaxAmount;
        this.postTaxAmount = postTaxAmount;
        this.total = total;
    
    }
    
    @Override
    public String toString(){
    
        return year + " " + preTaxAmount + " " + postTaxAmount + "/n";
        
    }
    
}
