/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement;

import Management.StockManagement.Stock.*;
import java.util.ArrayList;

/**
 *
 * @author ������
 */
public class StockIsEmpty {

    public StockIsEmpty(ArrayList<Stock> stocks) {
        for (Stock stk : stocks) {
            if (stk.getPcs() == 0) {
                notifycation(stk);
            }
        }
    }
    public void notifycation(Stock stk) {
        System.out.println(stk.getName() + "�� ��� �������");
        System.out.print("���� ��û�� �Ͻðڽ��ϱ�?");
    }
}
