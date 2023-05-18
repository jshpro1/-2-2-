/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.OrderManagement.Order;

import Management.MenuManagement.Menu.Food;
import Management.StockManagement.manager.StockManager;


import java.util.ArrayList;

/**
 * 5/ 16 ��� ó�� ���� ��� ����
 * @author ������
 */
public class OrderProcess implements Subject{ // �ϴ� ��� ó�� ���� ���
    
    private ArrayList<StockManager> stockmanagers; //��� ������ ���
    public Food menu ; // ó���� �޴�

    public OrderProcess() { // ��� ����
        stockmanagers = new ArrayList<StockManager>();
    }
    
    public void addStockManager(StockManager o) { // ��ܿ� ������ �߰�
        
        stockmanagers.add(o);
    }

    public void removeStockManager(StockManager o) {  // ��ܿ��� ����
        stockmanagers.remove(o); 
    }

    public void notifyStockManager() { // �����ڵ����� �˸�
        for(StockManager all_sm : stockmanagers){  // ��� ������ ���鼭 ����
            all_sm.update(menu);
        }
    }
    public void getMenu(Food menu){ // �ӽ� �޴� �Է� �ޱ�
        this.menu = menu;
    }
    
}
