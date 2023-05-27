/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.receipt;

import File.*;
import Management.PayManagement.payment.*;
import com.google.gson.*;
import java.util.*;
/**
 *
 * @author ������
 */
public class MobileReceipt {
    public ArrayList<Payment> rlist;
    public Payment pay;
    
    public MobileReceipt(){
        rlist = new ArrayList<Payment>();
        pay = new Payment();
    }
    
    public void saveMobileReceipt(ArrayList<Payment> payinfo) {
        // JSON���� ��ȯ�� �� ��¥ ���� ����
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        
        new Save_ReceiptData(payinfo);
        
        String json = gson.toJson(payinfo);
        System.out.println(json);
        
        System.out.println("complete");
    }
}
