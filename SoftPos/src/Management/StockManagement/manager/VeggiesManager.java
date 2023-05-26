/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.manager;

import File.Bring_StockData;
import Management.MenuManagement.Menu.*;
import Management.OrderManagement.Order.OrderProcess;

/**
 *
 * @author ������
 */
public class VeggiesManager implements StockManager {
    private OrderProcess op;
    private Menu menu;
    public StockList slist;
    public VeggiesManager(OrderProcess op) {
        this.op = op;
        op.addStockManager(this);
        slist = new StockList();

        bringData();

        // ��� ������� Ȯ���Ͽ� �˸�
//        new StockIsEmpty(cereals); 
    }

    // ����ҿ��� �ҷ�����
    private void bringData() {
//        slist.stocks = new Bring_StockData(this.identify()).bringStocksList();
        new Bring_StockData(this.identify());
    }

    @Override
    public String identify() { //��ü��Ȯ��
        return "Veggie";
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
}
