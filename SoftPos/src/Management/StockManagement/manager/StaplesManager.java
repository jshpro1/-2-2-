/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.manager;

import File.*;
import Management.MenuManagement.Menu.*;
import Management.OrderManagement.Order.OrderProcess;

/**
 *
 * @author ������
 */
public class StaplesManager implements StockManager {

    private OrderProcess op;
    public Menu menu;
//    public StocksList slist; // ������ ��� ����Ʈ 0522 ��� ���
    public StockList slist;

    public StaplesManager(OrderProcess op) {
        this.op = op;
        op.addStockManager(this);  // ��� ������ ��� ����

//        slist = new StocksList(this); 0522 ������
        slist = new StockList();

        bringData();

    }

    // ����ҿ��� �ҷ�����
    private void bringData() {
        new Bring_StockData(this.identify());
    }

    @Override
    public String identify() { //��ü��Ȯ��
        return "Staple";
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    @Override
    public void update(Menu menu) { //�ӽ� 
        this.menu = menu;
    }

    @Override
    public StockList getStocksList() {
        return slist;
    }
//    public void count(){ // �ӽ� ��� Ȯ��
//        for(Stock material : menu.material){
//            System.out.println(material.kind());
//        }
//    }
}
