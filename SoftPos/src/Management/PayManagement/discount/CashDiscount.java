/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.discount;

/**
 *
 * @author jsh
 */
//??�? ????
public class CashDiscount extends DiscountDecorator {

//    private final double point;
    private String type;
    public CashDiscount(Discount discount, String type) {
        this.discount = discount;
        this.type = type;
    }
    

    @Override
    public int applyDiscount() {

        switch (type) {
            case "����":
                return discount.applyDiscount() -2000;
            case "����":
                return discount.applyDiscount() -5000;
        }
        return 0;
    }
}
