/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

import Management.PayManagement.receipt.*;
import File.*;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author ������
 */
public class Process_Cash { //���ù�

    private Receipt_Cash receipt;

    public Process_Cash(Receipt_Cash receipt) {
        this.receipt = receipt;
    }
    
    public void CashReceiptProcessing(){
        ArrayList<Receipt> rlist = new ArrayList<Receipt>();
//        rlist = new Bring_ReceiptData().rlist;
        rlist.add(receipt);
        new Save_ReceiptData(rlist);
        System.out.println(receipt);
    }
}
