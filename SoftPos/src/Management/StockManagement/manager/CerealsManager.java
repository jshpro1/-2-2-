/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.manager;

import File.*;
import Management.MenuManagement.Menu.*;
import Management.OrderManagement.Order.OrderProcess;
import Management.StockManagement.Stock.*;
import java.util.ArrayList;

/**
 *
 * @author ������
 */
public class CerealsManager implements StockManager {

    private OrderProcess op;
    public Food menu;
    private ArrayList<Cereal> cereals;

    public CerealsManager(OrderProcess op) {  // ��� ������ ��� ����
        this.op = op;
        op.addStockManager(this);
        
        
        cereals = new Bring_StockData().getList(); // ����ҿ��� �ҷ�����
        
    }

    public Food getMenu() {
        return menu;
    }

    public void update(Food menu) { //�ӽ� 
        this.menu = menu;
    }
    
    public ArrayList<Cereal> getStockList(){
        return cereals;
    }

//    public void count(){ // �ӽ� ��� Ȯ��
//        for(Stock material : menu.material){
//            System.out.println(material.kind());
//        }
//    }
}
