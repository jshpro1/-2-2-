/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

/**
 *
 * @author USER
 */
import java.io.*;
import java.util.*;
import File.*;

public class PaymentManager { // �κ�Ŀ

//    private Map<String, Command> commands = new HashMap<>();
    private Bring_ReceiptData br;
    private Command command;
    
    public PaymentManager() {
        
//        commands.put("card", new CardPayCommand(payinfo));
//        commands.put("cash", new CashPayCommand(payinfo));
//        commands.put("mobile", new MobilePayCommand(payinfo));
        
        
        
        
        //commands.put("receipt", new ReceiptCommand(scanner));
    }
    
    public void setCommend(Command command){
        this.command = command;
    }
    
    

//    public void GUIstart(String payType, Payment payment) {
//        payinfo.add(payment);
//        
////        Command command = commands.get(payType);
////        if (command != null) {
////            command.execute();
////        } else if (payType.equals("quit")) {
////            System.out.println("�ý����� �����մϴ�.");
////            System.exit(0);
////        } else {
////            System.out.println("�߸��� �Է��Դϴ�. �ٽ� �����ϼ���.");
////        }
//    }
    
    public void takePayment(){
        command.execute();
    }
    
}
