/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.manager;

import Management.MenuManagement.Menu.*;
import Management.OrderManagement.Order.OrderProcess;
import Management.StockManagement.Stock.Basic.Stock;
/**
 *
 * @author ������
 */
public class CerealsManager implements StockManager{
    
    private OrderProcess op;
    public Food menu;

    public CerealsManager(OrderProcess op) {  // ��� ������ ��� ����
        this.op = op;
        op.addStockManager(this);
    }
    
    
    
    public void update(Food menu){ //�ӽ� 
        this.menu = menu;
    }
    public void count(){ // �ӽ� ��� Ȯ��
        for(Stock material : menu.material){
            System.out.println(material.kind());
        }
    }
}
