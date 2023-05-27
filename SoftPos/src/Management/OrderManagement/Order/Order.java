/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.OrderManagement.Order;

import File.*;
import Management.MenuManagement.Menu.*;
import Management.StockManagement.Stock.Stock;
import com.google.gson.Gson;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ������
 */
public class Order {

    public ArrayList<Menu> mlist;
    public Vector<Vector> orderlist;
    public Vector orderinfo;
//    public Vector<Menu> vlist;
    public ArrayList<JButton> btnlist;
    public OrderCarculator ocal;

    //�޴�����µ� ���� ��� ��� ����Ʈ
    public Object[][] ob = {
        {"�� �� ��", 0},
        {"���αݾ�", 0},
        {"�����ݾ�", 0},
        {"�����ݾ�", 0},
        {"�Ž�����", 0}
    };

    public Order() {
        orderlist = new Vector<Vector>();
    }
//        System.out.println(new Gson().toJson(mlist));

    public void setMenus(String ctype) {
        mlist = new Bring_MenuData().mlist;
        int i = 0;
        setEnableF();
        setTextNull();
        for (Menu m : mlist) {
            if (m.category.equals(ctype)) {

                btnlist.get(i).setText(m.name);
                btnlist.get(i).setEnabled(true);

                i++;
            }
        }
    }

    public void getbtnList(ArrayList<JButton> btnlist) {
        this.btnlist = btnlist;
    }

    public void setEnableF() {
        for (JButton jbtn : btnlist) {
            jbtn.setEnabled(false);
        }
    }

    public void setTextNull() {
        for (JButton jbtn : btnlist) {
            jbtn.setText("");
        }
    }

    public void takeOrder(DefaultTableModel tm){
        tm.setRowCount(0);
        for (Vector vec : orderlist){
            tm.addRow(vec);
        }
        tm.fireTableDataChanged();
    }
    public void addOrder(String mname, DefaultTableModel tm) {

        setOrderinfo();

        tm.setRowCount(0);

        /*
        �ֹ�����Ʈ�� �޴��� 
        �ߺ��ϴ��� Ȯ���ϴ� �ڵ�
         */
        boolean dup = false; // �ֹ� ����Ʈ�� �޴� �ߺ� Ȯ��
        for (Vector vec : orderlist) {
            if (vec.get(1).equals(mname)) {
                dup = true; //�ߺ�Ȯ��
                vec.set(3, (int) vec.get(3) + 1);
                vec.set(4, (int) vec.get(3) * (int) vec.get(2));
//                vec.set(5, (int) vec.get(3) * (int) vec.get(2)); //0527
            }
            tm.addRow(vec);
        }
        if (!dup) {
            for (Menu m : mlist) {
                if (m.name.equals(mname)) {

                    // ��� �������� Ȯ���غ��� �ڵ�
                    if (checkHaveStocks(m)) {
                        return;
                    }
                    /*
                    �ֹ� ����Ʈ�� ���ο� �޴� 
                    �߰��ϴ� �ڵ�
                    */
                    orderlist.add(orderinfo);
                    orderinfo.set(0, orderlist.indexOf(orderinfo) + 1);
                    orderinfo.set(1, m.name);
                    orderinfo.set(2, m.price);
                    orderinfo.set(3, 1);
                    orderinfo.set(4, (int) orderinfo.get(3) * (int) orderinfo.get(2));
//                    orderinfo.set(4, 0); 
//                    orderinfo.set(5, (int) orderinfo.get(3) * (int) orderinfo.get(2)); 0527
                    tm.addRow(orderinfo);
                }
            }
        }

        tm.fireTableDataChanged();
    }

    public void setAmounts(DefaultTableModel atm, int ra) {

        ocal = new OrderCarculator(orderlist, ob);
        ocal.setAmounts(atm, ra);
    }

    public void setOrderinfo() {
        orderinfo = new Vector();
        orderinfo.add(0); //�ֹ� ��ȣ
        orderinfo.add(""); //�޴� ��
        orderinfo.add(0); // �ܰ�
        orderinfo.add(0); // ����
        orderinfo.add(0); // �ݾ�
//        orderinfo.add(0);
    }

    public Vector<Vector> getOrderList() {
        return orderlist;
    }

    /*
    ��� �������� 
    Ȯ���غ��� �ڵ�
     */
    public Boolean checkHaveStocks(Menu m) {
        String emptystocks = "";
        boolean empty = false;
        for (Vector vec : m.ingredient) {
            ArrayList<Stock> list = new Bring_StockData(String.valueOf(vec.get(1))).slist;
            for (Stock stk : list) {
                if (stk.getName().equals((String) vec.get(0))) {
                    if (stk.getPcs() == 0) {
                        empty = true;
                        if (emptystocks.equals("")) {
                            emptystocks = stk.getName();
                        } else {
                            emptystocks = emptystocks + ", " + stk.getName();
                        }
                    }
                }
            }
        }
        if (empty) {
            JOptionPane.showMessageDialog(null, m.name + "�� ����� " + emptystocks + " (��)�� �����մϴ�.");
            return true;
        }
        return false;
    }

}
