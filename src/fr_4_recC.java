/*
----------------------------------------------------------
브랜드 전체에서 커피 메뉴를 추천해주는 fr_recom_coffee 클래스

랜덤 추천 방식 : 모든 메뉴의 id가 저장된 arraylist의 인덱스
               범위 내의 난수 값을 자바에 내장된 난수 함수로
               생성하여(Math.random()) 지정된 랜덤 id값에
               대한 데이터를 불러오는 방식

이 코드는 sql의 수정, 삭제, 추가 등의 update 이후에도 유효합니다.

마지막 수정 날짜 : 2020-08-28  6:14 AM
수정 내용 : -
 ----------------------------------------------------------
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class fr_4_recC extends JFrame {
    private JLabel imageLabel3;    private JLabel textLabel3;    private ImageIcon img3 = null;
    private static int id3;
    private MySQL_Handler handler3 = new MySQL_Handler();
    private static double DValue3;
    private static ArrayList<Integer> idList_coffee = new ArrayList<>();

    public fr_4_recC() {
        setTitle("메뉴 추천해주기_커피 메뉴 추천");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        imageLabel3 = new JLabel();			textLabel3 = new JLabel();		JButton B = new JButton("◀");
        imageLabel3.setLocation(25,80);		textLabel3.setLocation(25,30);	B.setLocation(215,460);					//버튼 위치 설정
		imageLabel3.setSize(350,400);		textLabel3.setSize(450,30);		B.setSize(50,50);						//버튼 크기 설정
		
		B.setBackground(Color.WHITE);	B.addMouseListener(new IVtoIII()); textLabel3.setFont(new Font("함초롬바탕", Font.PLAIN, 20));
		c.add(textLabel3); c.add(imageLabel3); c.add(B); 	

        handler3.conectDB(); //DB연결
        idList_coffee = handler3.coffee_O();

        DValue3 = Math.random();

        int random_num1 = (int)(DValue3 * idList_coffee.size()) - 1;
        int get_id3 = (int)(idList_coffee.get(random_num1));
        id3 = get_id3;

        showMenu(id3); //메뉴보여주기

        setSize(500, 600);
        setVisible(true);
    }
    class IVtoIII extends MouseAdapter{																				//'◀' 클릭시 fr3으로 돌아가는 마우스 이벤트(뒤로가기 버튼)
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)		new fr_3_choR();}
    }
    public void showMenu(int i){
        imageLabel3.setIcon(handler3.getMenuImage(i));
        textLabel3.setText("[" + handler3.getMenuString(i,"BRAND") + "] " + handler3.getMenuString(i,"NAME")+ " "
                + handler3.getMenuString(i,"PRICE")+ "원 "
                + "커피 "+ handler3.getMenuString(i,"COFFEE"));
    }
}
