/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.manager;

import Management.PayManagement.payment.PaymentProcess;
import File.Bring_StockData;
import File.Save_StockDataDefalt;
import Management.MenuManagement.Menu.*;
import Management.OrderManagement.Order.*;
import Management.StockManagement.Stock.Stock;
import Management.StockManagement.StockManagement;
import java.util.ArrayList;

/**
 *
 * @author ������
 */
public class VeggiesManager implements StockManager {

    // Subject ���� Ŭ������
    private PaymentProcess op;
    private StockManagement smg;

    private Menu menu;
    public ArrayList<Stock> slist;

    public VeggiesManager() {
        slist = new ArrayList<Stock>();

        bringData();

        // ��� ������� Ȯ���Ͽ� �˸�
//        new StockIsEmpty(cereals); 
    }

    @Override
    public void subscribePaymentProcess(PaymentProcess op) {

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
        return "Veggie";
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    //������Ʈ��
    @Override
    public void updateMenuData(Menu menu) { //�ӽ� 
        this.menu = menu;
        saveData(slist);
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
