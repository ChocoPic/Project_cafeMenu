/*
----------------------------------------------------------
브랜드 전체에서 메뉴를 추천해주는 fr_recom_all 클래스

랜덤 추천 방식 : 모든 메뉴의 id가 저장된 arraylist의 인덱스
               범위 내의 난수 값을 자바에 내장된 난수 함수로
               생성하여(Math.random()) 지정된 랜덤 id값에
               대한 데이터를 불러오는 방식

이 코드는 sql의 수정, 삭제, 추가 등의 update 이후에도 유효합니다.

마지막 수정 날짜 : 2020-08-28  6:09 AM
수정 내용 : -
 ----------------------------------------------------------
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class fr_4_recA extends JFrame {
    private JLabel imageLabel1;    private JLabel textLabel1;    private ImageIcon img1 = null;
    private static int id1;
    private MySQL_Handler handler1 = new MySQL_Handler();
    private static double DValue1;
    private static ArrayList<Integer> idList_allmenu = new ArrayList<>();

    public fr_4_recA() {
        setTitle("메뉴 추천해주기_전체 메뉴 추천");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        imageLabel1 = new JLabel();			textLabel1 = new JLabel();		JButton B = new JButton("◀");
        imageLabel1.setLocation(25,80);		textLabel1.setLocation(25,30);	B.setLocation(215,460);					//버튼 위치 설정
		imageLabel1.setSize(350,400);		textLabel1.setSize(450,30);		B.setSize(50,50);						//버튼 크기 설정		
		B.setBackground(Color.WHITE);	B.addMouseListener(new IVtoIII()); textLabel1.setFont(new Font("함초롬바탕", Font.PLAIN, 20));
		c.add(textLabel1); c.add(imageLabel1); c.add(B); 	  
        
        JPanel panel = new JPanel();
        panel.setSize(50, 50);
        c.add(panel,BorderLayout.SOUTH);

        handler1.conectDB(); //DB연결
        idList_allmenu = handler1.allmenu();

        DValue1 = Math.random();

        int random_num1 = (int)(DValue1 * idList_allmenu.size()) - 1;
        int get_id1 = (int)(idList_allmenu.get(random_num1));
        id1= get_id1;

        showMenu(id1); //메뉴보여주기

        setSize(500, 600);
        setVisible(true);
    }
    class IVtoIII extends MouseAdapter{																				//'◀' 클릭시 fr_3으로 돌아가는 마우스 이벤트(뒤로가기 버튼)
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)		new fr_3_choR();}
    }
    public void showMenu(int i){
        imageLabel1.setIcon(handler1.getMenuImage(i));
        textLabel1.setText("[" + handler1.getMenuString(i,"BRAND") + "] " + handler1.getMenuString(i,"NAME")+ " "
                + handler1.getMenuString(i,"PRICE") + "원 "
                + "커피 "+ handler1.getMenuString(i,"COFFEE"));
    }
}
