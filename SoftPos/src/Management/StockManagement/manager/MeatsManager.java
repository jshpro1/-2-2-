/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.manager;

import Management.MenuManagement.Menu.Food;
import Management.OrderManagement.Order.OrderProcess;

/**
 *
 * @author ������
 */
public class MeatsManager implements StockManager{
    private OrderProcess op;

    public MeatsManager(OrderProcess op) {
        this.op = op;
        op.addStockManager(this);
    }
    
    public void update(Food menu){
        
    }
}
