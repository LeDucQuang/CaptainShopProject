/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bussinessObject;

/**
 *
 * @author VuNK
 */
public class ShoppingCartItem {

    public int productId;
    public String productName;
    public String productImage;
    public int productPrice;
    public int productFee;
    public int productQuantity;
    public int TotalPrice;

    public ShoppingCartItem() {
    }

    public ShoppingCartItem(int productId, String productName, String productImage, int productPrice, int productFee, int productQuantity, int TotalPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productImage = productImage;
        this.productPrice = productPrice;
        this.productFee = productFee;
        this.productQuantity = productQuantity;
        this.TotalPrice = TotalPrice;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductFee(int productFee) {
        this.productFee = productFee;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getProductFee() {
        return productFee;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }
    
}
