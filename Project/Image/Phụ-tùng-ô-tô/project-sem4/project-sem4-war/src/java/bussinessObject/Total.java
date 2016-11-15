/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinessObject;

/**
 *
 * @author Cgc_Shyn
 */
public class Total {
    public double totalPrice;
    public double discount;

    public Total() {
    }

    public Total(double totalPrice, double discount) {
        this.totalPrice = totalPrice;
        this.discount = discount;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDiscount() {
        return discount;
    }
    
}
