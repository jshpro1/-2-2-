/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.MenuManagement.Menu;


import Management.StockManagement.Stock.Basic.*;
import java.util.ArrayList;


/**
 * 5/ 16 �޴� ���� Ŭ����
 * @author ������
 */


public abstract class Food { //�޴�

    public String name;
    public int price;
    public ArrayList<Stock> material;
    
    public abstract void cook();
    
}
   