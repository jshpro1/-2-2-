/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

import File.Bring_ReceiptData;
import File.Save_ReceiptData;
import Management.PayManagement.receipt.*;
import java.util.*;

/**
 *
 * @author ������
 */
public class Process_Card { //���ù�

    private Receipt receipt;

    public Process_Card(Receipt receipt) {
        this.receipt = receipt;
    }

    public void makeCardReceipt() {
        ArrayList<Receipt> rlist;
        rlist = new Bring_ReceiptData().rlist;
        rlist.add(receipt);
        new Save_ReceiptData(rlist);
        System.out.println(receipt);
    }
}
