/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement;

import File.*;
import Management.OrderManagement.Order.*;
import Management.StockManagement.Stock.*;
import Management.StockManagement.manager.*;
import com.google.gson.Gson;
import java.util.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ������
 */
public class StockManagement implements Subject {

    private ArrayList<StockManager> stockmanagers; //��� ������ ���
    private Vector vlist; // ���̺� ������ �� ���� ����
//    private ArrayList<Stock> slist; // �� ������ �� ���� ��� ����Ʈ

    public StockManagement() {
        stockmanagers = new ArrayList<StockManager>();

        //�ӽ� ����
        
        bringStockData();

    }

    public void setStocksTable(String type, DefaultTableModel tm) {
        tm.setRowCount(0);

        
        for (StockManager sm : stockmanagers) {
            
            if (sm.identify().equals(type)) {

                for (Stock stk : sm.getStocksList()) {
                    vlist = new Vector();
                    vlist.add(stk.getName());
                    vlist.add(stk.getKcal());
                    vlist.add(stk.getPrice());
                    vlist.add(stk.getPcs());
                    tm.addRow(vlist);
                }
            }else if (type.equals("All")){
                for (Stock stk : sm.getStocksList()) {
                    vlist = new Vector();
                    vlist.add(stk.getName());
                    vlist.add(stk.getKcal());
                    vlist.add(stk.getPrice());
                    vlist.add(stk.getPcs());
                    tm.addRow(vlist);
                }
            }
        }
        tm.fireTableDataChanged();
    }

    public void setStocksData(String sname, int pcs) {
        for (StockManager sm : stockmanagers) {
            for (Stock stk : sm.getStocksList()) {
                if (stk.getName().equals(sname)) {
                    stk.setPcs(pcs + stk.getPcs());
//                    System.out.println(stk.kind());
                }
            }
        }
    }
    public void setAllStocksData( int pcs) {
        for (StockManager sm : stockmanagers) {
            for (Stock stk : sm.getStocksList()) {
                    stk.setPcs(pcs + stk.getPcs());
            }
        }
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

}
