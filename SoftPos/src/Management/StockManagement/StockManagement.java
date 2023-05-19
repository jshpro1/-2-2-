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
 *
 * @author ������
 */
public class StockManagement {

    public StockManagement() {
    }

    public void makeStockData() {

        ArrayList stocks = new ArrayList();
        Scanner scn = new Scanner(System.in);
        
        System.out.println("���� Ÿ���� ��� �Է��Ͻðڽ��ϱ�?");
        System.out.println("C : Cereal");
        System.out.println("M : Meat");
        System.out.println("V : Veggie");
        System.out.println("S : Sauce");
        System.out.print("�Է� : ");
        String type = scn.next();
        
        boolean plag = true;
        while (plag) {

            System.out.print("����� �̸��� �Է� : ");
            String name = scn.next();

            System.out.print("����� Į�θ��� �Է� : ");
            int kcal = scn.nextInt();

            System.out.print("����� �ܰ��� �Է� : ");
            int unit_price = scn.nextInt();

            if (type.equals("C")) {
                stocks.add(new Cereal(name, kcal, unit_price));
            }else if (type.equals("M")){
                stocks.add(new Meat(name, kcal, unit_price));
            }else if( type.equals("V")){
                stocks.add(new Veggie(name, kcal, unit_price));
            }else if(type.equals("S")){
                stocks.add(new Sauce(name,kcal,unit_price));
            }else System.out.println("�߸��� Ÿ�� �Դϴ�.");

            System.out.print("��� �Է� �Ͻðڽ��ϱ�? (Y/N) : ");
            String check = scn.next();

            if (check.equals("Y")); else {
                plag = false;
            }

        }

        System.out.println(stocks);

        new Save_StockDataDefalt(stocks,type);

    }

}
