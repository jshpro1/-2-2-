/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement;

import Management.OrderManagement.Order.OrderProcess;
import Management.StockManagement.manager.*;

/**
 *
 * @author ������
 */
public class PlaceAnOrder {
    
    private CerealsManager cerealsmanager;
    private MeatsManager meatsmanager;
    private SauceManager saucemanager;
    private VeggiesManager veggieManager;

    public PlaceAnOrder() {
        OrderProcess op = new OrderProcess(); // �ӽ� �ֹ� ó��
        cerealsmanager = new CerealsManager(op);
        meatsmanager = new MeatsManager(op);
        saucemanager = new SauceManager(op);
        veggieManager = new VeggiesManager(op);
        
    }
    
    
}
