/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Management.PayManagement.receipt;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author ������
 */
public class Receipt {

    //����
    public String payment;
    public Date date;
    public Vector<Vector> orderlist; // ���� ����
    public int total_amount;     //�ѱݾ�
    public int discount; // ���αݾ�

    public int taxation_amount; //�����ݾ�
    public int surtax_amount; //�ΰ���
    public int pay_amoutn; //�����ݾ�

    //���� ����
    public int received_amount; // ����
    public int change; // �Ž�����

    //ī��, ����� ����
    public String cardnumber;
    public String installment; //�Һ�

    public Receipt() {

        
    }

}
