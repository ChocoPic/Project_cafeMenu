import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class fr_3_choR extends JFrame{
	public fr_3_choR() {
		setTitle("카페메뉴판_VA스_메뉴 추천해주기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);																			/*프레임윈도우 닫을때 스윙 프로그램 같이 종료*/
		
		Container BR = getContentPane();
		BR.setLayout(null);																										//컨텐트판 (null-제거)배치관리자 설정				
								
		JButton a = new JButton("전체");	JButton b = new JButton("브랜드별"); JButton c = new JButton("커피"); JButton n = new JButton("논커피"); JButton B = new JButton("◀");		
		a.setLocation(65,80);	b.setLocation(270,80);	c.setLocation(65,270);	n.setLocation(270,270);	B.setLocation(215,460);	//버튼 위치 설정
		a.setSize(150,150);		b.setSize(150,150);		c.setSize(150,150);		n.setSize(150,150);		B.setSize(50,50);		//버튼 크기 설정
        a.setBackground(new Color(255,170,170));	 b.setBackground(new Color(255,170,170));									//버튼 배경색 설정
        c.setBackground(new Color(255,170,170));	 n.setBackground(new Color(255,170,170));	B.setBackground(Color.WHITE);	
        a.setFont(new Font("맑은 고딕", Font.PLAIN, 18));		b.setFont(new Font("맑은 고딕", Font.PLAIN, 18));						//텍스트 폰트, 크기 설정
        c.setFont(new Font("맑은 고딕", Font.PLAIN, 18));		n.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
        
		BR.add(a); BR.add(b); BR.add(c); BR.add(n); BR.add(B);																	//버튼을 컨텐트팬에 부착
		
		a.addMouseListener(new IIItoA());	b.addMouseListener(new IIItoIII_V());												//버튼에 마우스 이벤트 리스너 등록
        c.addMouseListener(new IIItoC());	n.addMouseListener(new IIItoN());   B.addMouseListener(new IIItoII());

		setSize(500,600);																										//프레임 크기
		setVisible(true);																										/*프레임을 화면에 출력*/
	}
	 	class IIItoA extends MouseAdapter{																						//'전체' 클릭시 fr4_전체 메뉴 추천으로 넘어가는 마우스 이벤트
	        public void mouseClicked(MouseEvent e) {
	            if(e.getButton() == MouseEvent.BUTTON1)		new fr_4_recA();}
	    }
	    class IIItoIII_V extends MouseAdapter{																					//'브랜드별' 클릭시 fr3.5으로 넘어가는 마우스 이벤트
	        public void mouseClicked(MouseEvent e) {
	            if(e.getButton() == MouseEvent.BUTTON1)		new fr_3_5_choB();}
	    }
	    class IIItoC extends MouseAdapter{																						//'커피' 클릭시 fr4_커피 메뉴 추천으로 넘어가는 마우스 이벤트
	        public void mouseClicked(MouseEvent e) {
	            if(e.getButton() == MouseEvent.BUTTON1)		new fr_4_recC();}
	    }
	    class IIItoN extends MouseAdapter{																						//'논커피' 클릭시 fr4_논커피메뉴 추천으로 넘어가는 마우스 이벤트
	        public void mouseClicked(MouseEvent e) {
	            if(e.getButton() == MouseEvent.BUTTON1)		new fr_4_recN();}
	        
	    }
	    class IIItoII extends MouseAdapter{																						//'◀' 클릭시 fr2로 돌아가는 마우스 이벤트(뒤로가기 버튼)
	        public void mouseClicked(MouseEvent e) {
	            if(e.getButton() == MouseEvent.BUTTON1)		new fr2_choWD();}
	    }
	}