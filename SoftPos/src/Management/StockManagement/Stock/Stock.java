/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.StockManagement.Stock;

/**
 *
 * @author ������
 */
public abstract class Stock { //���
    
    protected String name;
    protected int unit_price; //100�׶� ���� ����
    protected int kcal; //Į�θ�
    protected int pcs; // ��� �� 
    
    public int getPrice(){
        return unit_price;
    }
    public abstract String kind(); // �ӽ� ��� �Ǻ�å
}
