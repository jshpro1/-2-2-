/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement;

import File.*;
import Management.StockManagement.Stock.*;
import Management.StockManagement.manager.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ( ! ) ���� �ʿ��� �ڵ�
 * @author ������
 */
public class PlaceAnOrder { 

    private ArrayList<Stock> paolist;

    public PlaceAnOrder() {

    }

    /*
    
     */
    public void paoRequest() { // ���� ��û

        Scanner scn = new Scanner(System.in);
        int st = 0; // StocksType : ������ ��ǰ Ÿ���� �����ϱ� ���� �Է�
        int ss = 0; // SelectedStock : ������ ��ǰ ��ȣ �Է�

        // ������ǰ��
        // �����ϴ� �ڵ�
        System.out.println("������ ǰ�� ����");
        System.out.println("1 : Staple");
        System.out.println("2 : Meat");
        System.out.println("3 : Veggie");
        System.out.println("4 : Sauce");
        System.out.print("�Է� : ");
        st = scn.nextInt(); // StocksType : ������ ��ǰ Ÿ���� �����ϱ� ���� �Է�

        paolist = selectStocksType(st);

        /*
        ���õ� ǰ�� 
        �����ִ� �ڵ�
        */
        int num = 1;
        System.out.println("������ ��� ����");
        for (Stock stk : paolist) {
            System.out.println("");
            System.out.println("---" + num + "����ǰ---");
            System.out.println("��ǰ : " + stk.getName());
            System.out.println("Į�θ� : " + stk.getKcal());
            System.out.println("�ܰ� : " + stk.getPrice());
            System.out.println("���� : " + stk.getPcs());
            System.out.println("------------");
            num++;
        }
        System.out.print("�Է� : ");
        ss = scn.nextInt()-1;// SelectedStock : ������ ��ǰ ��ȣ �Է�

        // ��� �Էµ� ������ŭ
        // �����ϴ� �ڵ� ( ! ) �����ʿ�
        int pp = paolist.get(ss).getPcs(); // PlaceanorderPieces : ������ ���� �Է�
        System.out.print("������ ��� ������ �Է��Ͻÿ� : ");
        pp = scn.nextInt();
        
        System.out.println(paolist.get(ss).getPcs());
        
    }



    //������ ��ǰ Ÿ�� ���� �ڵ� ( ! ) �����ʿ�
    private ArrayList<Stock> selectStocksType(int type) {
        switch (type) {
            case 1:
                return new Bring_StockData("Staple").bringStocksList();
            case 2:
                return new Bring_StockData("Meat").bringStocksList();
            case 3:
                return new Bring_StockData("Veggie").bringStocksList();
            case 4:
                return new Bring_StockData("Sauce").bringStocksList();
            default:
                break;
        }
        return null;
    }
    //������ ��ǰ ���� �ڵ� ( ! ) �����ʿ�

    private Stock selectStock(int type) {
        for (Stock stk : paolist) {
            if (stk.getName().equals(type)) {
                return stk;
            }
        }
        return null;
    }

    
    
    
    
    
    // ��� ��Ȳ
    // �����ֱ�
    public void viewStockState(ArrayList<Stock> slist) {
        for (Stock stk : slist) {
            System.out.println(stk.getName() + "�� ��� �� : " + stk.getPcs());
        }
    }
}





