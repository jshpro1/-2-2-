/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.OrderManagement.Order;

import Management.MenuManagement.Menu.Beverage;
import Management.MenuManagement.Menu.Meat_Menu;
import Management.MenuManagement.Menu.RiceAndNoodle;
import Management.MenuManagement.Menu.Salad;
import Management.MenuManagement.Menu.SideDish;
import Management.MenuManagement.Menu.Various_Menu;
import java.util.ArrayList;

/**
 *
 * @author ������
 */
public class Order_Menu {
    private Various_Menu various_menu;

    public Order_Menu(Various_Menu vm) {
        various_menu = vm;
    }
    
    // �ֹ����� �ý��� �޴� ī�װ��� ó��
    public ArrayList<RiceAndNoodle> getRiceAndNoodle(){ // ��,&�� ī�װ�
        return various_menu.riceAndnoodles;
    }
    
    public ArrayList<Meat_Menu> getMeats(){ // ��� ī�װ�
        return various_menu.meats;
    }
    
    public ArrayList<Salad> getSalads(){ // ������ ī�װ�
        return various_menu.salads;
    }
    
    public ArrayList<SideDish> getSides(){ // ���̵� ī�װ�
        return various_menu.sides;
    }
    
    public ArrayList<Beverage> getBeverages(){ // ���� ī�װ�
        return various_menu.beverages;
    }
}
