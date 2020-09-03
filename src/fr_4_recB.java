/*
------------------------------------------------------------------
각 브랜드 별 메뉴를 추천해주는 fr_recom_brand 클래스

랜덤 추천 방식 : 모든 메뉴의 id가 저장된 arraylist의 인덱스
               범위 내의 난수 값을 자바에 내장된 난수 함수로
               생성하여(Math.random()) 지정된 랜덤 id값에
               대한 데이터를 불러오는 방식

이 코드는 sql의 수정, 삭제, 추가 등의 update 이후에도 유효합니다.

마지막 수정 날짜 : 2020-08-28  7:55 PM
수정 내용 : 각 브랜드 별 메뉴를 추천해주는 클래스를 합침
 ------------------------------------------------------------------
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class fr_4_recB extends JFrame {
    private JLabel imageLabel2;    private JLabel textLabel2;    private ImageIcon img2 = null;
    private static int id2;
    private MySQL_Handler handler2 = new MySQL_Handler();
    private static ArrayList<Integer> idList_brand_starbucks = new ArrayList<>();
    private static ArrayList<Integer> idList_brand_gongcha = new ArrayList<>();
    private static ArrayList<Integer> idList_brand_hollys = new ArrayList<>();
    private static ArrayList<Integer> idList_brand_paikdabang = new ArrayList<>();

    public fr_4_recB(int brandNum) {
        switch (brandNum){
        case 1:
        	fr_recom_brand_starbucks(); break;
        case 2:
        	fr_recom_brand_gongcha(); break;
        case 3:
        	fr_recom_brand_hollys(); break;
        case 4:
        	fr_recom_brand_paikdabang(); break;
    }
        }

    public void fr_recom_brand_starbucks() {
        setTitle("브랜드별 메뉴 추천_스타벅스");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        imageLabel2 = new JLabel();			textLabel2 = new JLabel();		JButton B = new JButton("◀");
        imageLabel2.setLocation(25,80);		textLabel2.setLocation(25,30);	B.setLocation(215,460);				//버튼 위치 설정
		imageLabel2.setSize(350,400);		textLabel2.setSize(450,30);		B.setSize(50,50);					//버튼 크기 설정
		
		B.setBackground(Color.WHITE);	B.addMouseListener(new IVtoIII_V()); textLabel2.setFont(new Font("함초롬바탕", Font.PLAIN, 20));
		c.add(textLabel2); c.add(imageLabel2); c.add(B); 	  
        
        handler2.conectDB(); //DB연결
        idList_brand_starbucks = handler2.brand_starbucks();

        double DValue2a = Math.random();

        int random_num2a = (int) (DValue2a * idList_brand_starbucks.size()) - 1;
        int get_id2a = (int) (idList_brand_starbucks.get(random_num2a));
        int id2a = get_id2a;

        showMenu(id2a); //메뉴보여주기

        setSize(500, 600);
        setVisible(true);
    }
    public void fr_recom_brand_gongcha() {
        setTitle("브랜드별 메뉴 추천_공차");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        c.setLayout(null);

        imageLabel2 = new JLabel();			textLabel2 = new JLabel();		JButton B = new JButton("◀");
        imageLabel2.setLocation(25,80);		textLabel2.setLocation(25,30);	B.setLocation(215,460);					//버튼 위치 설정
		imageLabel2.setSize(350,400);		textLabel2.setSize(450,30);		B.setSize(50,50);						//버튼 크기 설정
		
		B.setBackground(Color.WHITE);	B.addMouseListener(new IVtoIII_V()); textLabel2.setFont(new Font("함초롬바탕", Font.PLAIN, 20));
		c.add(textLabel2); c.add(imageLabel2); c.add(B); 	

        handler2.conectDB(); //DB연결
        idList_brand_gongcha = handler2.brand_gongcha();

        double DValue2b = Math.random();

        int random_num2b = (int) (DValue2b * idList_brand_gongcha.size()) - 1;
        int get_id2b = (int) (idList_brand_gongcha.get(random_num2b));
        int id2b = get_id2b;

        showMenu(id2b); //메뉴보여주기

        setSize(500, 600);
        setVisible(true);
    }
    public void fr_recom_brand_hollys(){
        setTitle("브랜드별 메뉴 추천_할리스커피");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        imageLabel2 = new JLabel();			textLabel2 = new JLabel();		JButton B = new JButton("◀");
        imageLabel2.setLocation(25,80);		textLabel2.setLocation(25,30);	B.setLocation(215,460);					//버튼 위치 설정
		imageLabel2.setSize(350,400);		textLabel2.setSize(450,30);		B.setSize(50,50);						//버튼 크기 설정
		
		B.setBackground(Color.WHITE);	B.addMouseListener(new IVtoIII_V()); textLabel2.setFont(new Font("함초롬바탕", Font.PLAIN, 20));
       
		c.add(textLabel2); c.add(imageLabel2); c.add(B); 	

        handler2.conectDB(); //DB연결
        idList_brand_hollys = handler2.brand_hollys();

        double DValue2c = Math.random();

        int random_num2c = (int)(DValue2c * idList_brand_hollys.size()) - 1;
        int get_id2c = (int)(idList_brand_hollys.get(random_num2c));
        int id2c = get_id2c;

        showMenu(id2c); //메뉴보여주기

        setSize(500, 600);
        setVisible(true);
    }
    public void fr_recom_brand_paikdabang(){
        setTitle("브랜드별 메뉴 추천_빽다방");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        imageLabel2 = new JLabel();			textLabel2 = new JLabel();		JButton B = new JButton("◀");
        imageLabel2.setLocation(25,80);		textLabel2.setLocation(25,30);	B.setLocation(215,460);					//버튼 위치 설정
		imageLabel2.setSize(350,400);		textLabel2.setSize(450,30);		B.setSize(50,50);						//버튼 크기 설정
		
		B.setBackground(Color.WHITE);	B.addMouseListener(new IVtoIII_V()); textLabel2.setFont(new Font("함초롬바탕", Font.PLAIN, 20));
		c.add(textLabel2); c.add(imageLabel2); c.add(B); 	

        handler2.conectDB(); //DB연결
        idList_brand_paikdabang = handler2.brand_paikdabang();

        double DValue2d = Math.random();

        int random_num2d = (int)(DValue2d * idList_brand_paikdabang.size()) - 1;
        int get_id2a = (int)(idList_brand_paikdabang.get(random_num2d));
        int id2d = get_id2a;

        showMenu(id2d); //메뉴보여주기

        setSize(500, 600);
        setVisible(true);
    }
    public void showMenu(int i) {
        imageLabel2.setIcon(handler2.getMenuImage(i));
        textLabel2.setText("[" + handler2.getMenuString(i, "BRAND") + "] " + handler2.getMenuString(i, "NAME") + " "
                + handler2.getMenuString(i, "PRICE") + "원 "
                + "커피 " + handler2.getMenuString(i, "COFFEE"));
    }
    class IVtoIII_V extends MouseAdapter{																		//'◀' 클릭시 fr_3.5로 돌아가는 마우스 이벤트(뒤로가기 버튼)
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)		new fr_3_5_choB();}
    }
 }

