/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.discount;

/**
 *
 * @author jsh
 */
//???��???? 3%
public class AffiliateDiscount extends DiscountDecorator {

    public String type = "";

    public AffiliateDiscount(Discount discount, String type) {
        this.discount = discount;
        this.type = type;
    }

    @Override
    public int applyDiscount() {
        switch (type) {
            case "�츮����":
                return  ((int)(((double)discount.applyDiscount()*0.96)/10))*10;
            case "�������":
                return  ((int)(((double)discount.applyDiscount()*0.96)/10))*10;
            case "īī����ũ":
                return  ((int)(((double)discount.applyDiscount()*0.96)/10))*10;
            case "�佺��ũ":
                return  ((int)(((double)discount.applyDiscount()*0.96)/10))*10;
        }
        return 0;
    }
}
