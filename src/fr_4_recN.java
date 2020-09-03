/*
-------------------------------------------------------------
브랜드 전체에서 논커피 메뉴를 추천해주는 fr_recom_noncoffee 클래스

랜덤 추천 방식 : 모든 메뉴의 id가 저장된 arraylist의 인덱스
               범위 내의 난수 값을 자바에 내장된 난수 함수로
               생성하여(Math.random()) 지정된 랜덤 id값에
               대한 데이터를 불러오는 방식

이 코드는 sql의 수정, 삭제, 추가 등의 update 이후에도 유효합니다.

마지막 수정 날짜 : 2020-08-28  6:15 AM
수정 내용 : -
 -------------------------------------------------------------
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class fr_4_recN extends JFrame {
    private JLabel imageLabel4;    private JLabel textLabel4;    private ImageIcon img4 = null;
    private static int id4;
    private MySQL_Handler handler4 = new MySQL_Handler();
    private static double DValue4;
    private static ArrayList<Integer> idList_noncoffee = new ArrayList<>();

    public fr_4_recN() {
        setTitle("메뉴 추천해주기_논커피 메뉴 추천");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        imageLabel4 = new JLabel();			textLabel4 = new JLabel();		JButton B = new JButton("◀");
        imageLabel4.setLocation(25,80);		textLabel4.setLocation(25,30);	B.setLocation(215,460);					//버튼 위치 설정
		imageLabel4.setSize(350,400);		textLabel4.setSize(450,30);		B.setSize(50,50);						//버튼 크기 설정
		
		B.setBackground(Color.WHITE);	B.addMouseListener(new IVtoIII()); textLabel4.setFont(new Font("함초롬바탕", Font.PLAIN, 20));
		c.add(textLabel4); c.add(imageLabel4); c.add(B); 

        handler4.conectDB(); //DB연결
        idList_noncoffee = handler4.coffee_X();

        DValue4 = Math.random();

        int random_num4 = (int)(DValue4 * idList_noncoffee.size()) - 1;
        int get_id4 = (int)(idList_noncoffee.get(random_num4));
        id4 = get_id4;

        showMenu(id4); //메뉴보여주기

        setSize(500, 600);
        setVisible(true);
    }
    class IVtoIII extends MouseAdapter{																		//'◀' 클릭시 fr_3으로 돌아가는 마우스 이벤트(뒤로가기 버튼)
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)		new fr_3_choR();}
    }
    public void showMenu(int i){
        imageLabel4.setIcon(handler4.getMenuImage(i));
        textLabel4.setText("[" + handler4.getMenuString(i,"BRAND") + "] " + handler4.getMenuString(i,"NAME")+ " "
                + handler4.getMenuString(i,"PRICE")+ "원 "
                + "커피 "+ handler4.getMenuString(i,"COFFEE"));
    }
}
