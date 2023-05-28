/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.payment;

import File.*;
import Management.MenuManagement.Menu.*;
import Management.MenuManagement.Menu.Menu;
import Management.OrderManagement.Order.Subject;
import Management.StockManagement.Stock.Stock;
import Management.StockManagement.manager.*;

import java.util.*;

/**
 * 5/ 16 ��� ó�� ���� ��� ����
 *
 * @author ������
 */
public class IngredientsProcess implements Subject { // �ϴ� ��� ó�� ���� ���

    private ArrayList<StockManager> stockmanagers; //��� ������ ���
//    public Menu menu; // ó���� �޴�
    public ArrayList<Menu> mlist; // �޴� ����Ʈ
    public Vector<Object[]> menu_pcs; // �޴��� �ش� �Ŵ� ����
    public Vector<String> stocknamelist; // ���� �̸� ����Ʈ

    public IngredientsProcess() { // ��� ����
        menu_pcs = new Vector<Object[]>(); //�ʱ�ȭ
        stockmanagers = new ArrayList<StockManager>(); //�ʱ�ȭ

        new StaplesManager().subscribePaymentProcess(this);
        new MeatsManager().subscribePaymentProcess(this);
        new SauceManager().subscribePaymentProcess(this);
        new VeggiesManager().subscribePaymentProcess(this);

        bringStockData();
    }

    public void addStockManager(StockManager o) { // ��ܿ� ������ �߰�

        stockmanagers.add(o);
    }

    public void removeStockManager(StockManager o) {  // ��ܿ��� ����
        stockmanagers.remove(o);
    }

    public void notifyStockManager() { // �����ڵ����� �˸�
        for (StockManager sm : stockmanagers) {  // ��� ������ ���鼭 ����
            sm.updateStockData(sm.getStocksList());
        }
    }

    public void bringStockData() {
        for (StockManager sm : stockmanagers) {
            sm.setStocksList(new Bring_StockData(sm.identify()).slist);
        }
    }

//    public void getMenu(Menu menu) { // �ӽ� �޴� �Է� �ޱ�
//        this.menu = menu;
//    }

    /*
    �޴��� �ش� �޴� ����
    menu_pcs �� �����ϴ� �ڵ�
     */
    public void checkUsedStock(Vector<Vector> orderlist) {
        for (Vector vec : orderlist) {
            Object[] mp = {"", 0}; //�޴��� �ش�Ŵ� ���� ���� ��ü
            mp[0] = vec.get(1); // �޴� ��
            mp[1] = vec.get(3); // �ش�޴� ����
            menu_pcs.add(mp);
        }
    }

    /*
    
     */
    public void applyUsedStock() {
        mlist = new Bring_MenuData().mlist;

        for (Menu menu : mlist) {
            for (Object[] obj : menu_pcs) {
                if(menu.name.equals(String.valueOf(obj[0]))){
                    for(Vector vec : menu.ingredient){
                        StockManager sm = null;
                        switch((String)vec.get(1)){ // ����� ī�װ��� �Ʒ� Ÿ���̸�
                            case "Staple":
                                sm = stockmanagers.get(0);
                                break;
                            case "Meat":
                                sm = stockmanagers.get(1);
                                break;
                            case "Sauce":
                                sm = stockmanagers.get(2);
                                break;
                            case "Veggie":
                                sm = stockmanagers.get(3);
                                break;
                        }
                        for(Stock stk : sm.getStocksList()){
                            if(stk.getName().equals((vec.get(0).toString()))){
                                stk.setPcs(stk.getPcs()-(int)obj[1]);
                            }
                        }
                    }
                }
            }
        }
//        for (StockManager sm : stockmanagers) {
//            for (Stock stk : sm.getStocksList()) {
////                if (stk.getName().equals(sname)) {
////                    stk.setPcs(pcs + stk.getPcs());
////                    System.out.println(stk.kind());
//            }
//        }
    }
}
