/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.manager;

import Management.PayManagement.payment.IngredientsProcess;
import File.*;
import Management.MenuManagement.Menu.*;
import Management.OrderManagement.Order.*;
import Management.StockManagement.Stock.Stock;
import Management.StockManagement.StockManagement;
import java.util.ArrayList;

/**
 *
 * @author ������
 */
public class SauceManager implements StockManager {

    private Menu menu;
    public ArrayList<Stock> slist;

    // Subject ���� Ŭ������
    private IngredientsProcess op;
    private StockManagement smg;

    public SauceManager() {
        slist = new ArrayList<Stock>();
        bringData();
    }

    @Override
    public void subscribePaymentProcess(IngredientsProcess op) {

        op.addStockManager(this);
    }

    @Override
    public void subscribeStockMangement(StockManagement smg) {

        smg.addStockManager(this);
    }

    // ����ҿ��� �ҷ�����
    private void bringData() {
//        slist.stocks = new Bring_StockData(this.identify()).bringStocksList();
        slist = new Bring_StockData(this.identify()).slist;
    }

    @Override
    public String identify() { //��ü��Ȯ��
        return "Sauce";
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    //������Ʈ��
    @Override
    public void updateMenuData(Menu menu) { //�ӽ� 
        this.menu = menu;
    }

    @Override
    public void updateStockData(ArrayList<Stock> slist) { //�ӽ� 
        this.slist = slist;
        saveData(slist);
    }

    private void saveData(ArrayList<Stock> slist) {
        new Save_StockDataDefalt(slist, this.identify());
    }

    @Override
    public ArrayList<Stock> getStocksList() {
        return slist;
    }

    @Override
    public void setStocksList(ArrayList<Stock> slist) {
        this.slist = slist;
    }
}
