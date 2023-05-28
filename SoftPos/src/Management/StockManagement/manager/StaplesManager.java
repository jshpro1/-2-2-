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
public class StaplesManager implements StockManager {

    // Subject ���� Ŭ������
    private IngredientsProcess op;
    private StockManagement smg;

    public Menu menu;
//    public StocksList slist; // ������ ��� ����Ʈ 0522 ��� ���
    public ArrayList<Stock> slist;

    public StaplesManager() {

//        slist = new StocksList(this); 0522 ������
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
        slist = new Bring_StockData(this.identify()).slist;
    }

    @Override
    public String identify() { //��ü��Ȯ��
        return "Staple";
    }

    @Override
    public Menu getMenu() {
        return menu;
    }

    //������Ʈ��
    @Override
    public void updateMenuData(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void updateStockData(ArrayList<Stock> slist) {
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
//    public void count(){ // �ӽ� ��� Ȯ��
//        for(Stock material : menu.material){
//            System.out.println(material.kind());
//        }
//    }
}
