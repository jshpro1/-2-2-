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

        ArrayList<Cereal> cereals = new ArrayList<Cereal>();


        Scanner scn = new Scanner(System.in);
        int t = 10;
        for(int i = 0 ; i< 10 ; i ++){

            System.out.print("����� �̸��� �Է� : ");
            String name = scn.nextLine().trim();
            System.out.println(name);

            System.out.println(String.format("%d��° �Է� �Ϸ�", i+1));
            cereals.add(new Cereal(name, i*10, i*100));
            System.out.println(cereals);
        }

        new Save_StockDataDefalt(cereals);

    }

}
