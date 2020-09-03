import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class fr3_choBr extends JFrame{
    public fr3_choBr() {
        setTitle("카페메뉴판_VA스_메뉴 보여주기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);																			/*프레임윈도우 닫을때 스윙 프로그램 같이 종료*/

        Container BR = getContentPane();
        BR.setLayout(null);																										//컨텐트판 (null-제거)배치관리자 설정

        JButton s = new JButton("스타벅스");	JButton p = new JButton("빽다방");	JButton g = new JButton("공차");	JButton h = new JButton("할리스커피"); JButton B = new JButton("◀");
        s.setLocation(65,80);	p.setLocation(270,80);	g.setLocation(65,270);	h.setLocation(270,270);	B.setLocation(213,460);	//버튼 위치 설정
        s.setSize(150,150);	 	p.setSize(150,150);		g.setSize(150,150);		h.setSize(150,150);		B.setSize(50,50);		//버튼 크기 설정
        s.setBackground(new Color(193,253,237));	 p.setBackground(new Color(193,253,237));									//버튼 배경색 설정
        g.setBackground(new Color(193,253,237));	 h.setBackground(new Color(193,253,237));	B.setBackground(Color.WHITE);	
        s.setFont(new Font("맑은 고딕", Font.PLAIN, 18));		p.setFont(new Font("맑은 고딕", Font.PLAIN, 18));						//텍스트 폰트, 크기 설정
        g.setFont(new Font("맑은 고딕", Font.PLAIN, 18));		h.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
        
        BR.add(s); BR.add(p); BR.add(g); BR.add(h); BR.add(B);																	//버튼을 컨텐트팬에 부착

        s.addMouseListener(new IIItoS());	p.addMouseListener(new IIItoP());													//버튼에 마우스 이벤트 리스너 등록
        g.addMouseListener(new IIItoG());	h.addMouseListener(new IIItoH());  B.addMouseListener(new IIItoII());	

        setSize(500,600);																										//프레임 크기
        setVisible(true);
    }
    class IIItoS extends MouseAdapter{																							//'스타벅스' 클릭시 fr4로 넘어가는 마우스 이벤트
        public void mouseClicked(MouseEvent e) {		
            if(e.getButton() == MouseEvent.BUTTON1)		new fr4_showA(1);}
    }
    class IIItoP extends MouseAdapter{																							//'빽다방' 클릭시 fr4으로 넘어가는 마우스 이벤트
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)		new fr4_showA(4);}
    }	
    class IIItoG extends MouseAdapter{																							//'공차' 클릭시 fr4으로 넘어가는 마우스 이벤트
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)		new fr4_showA(2);}
    }
    class IIItoH extends MouseAdapter{																							//'할리스커피' 클릭시 fr4으로 넘어가는 마우스 이벤트
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)		new fr4_showA(3);}
    }
    class IIItoII extends MouseAdapter{																							//'◀' 클릭시 fr2로 돌아가는 마우스 이벤트(뒤로가기 버튼)
        public void mouseClicked(MouseEvent e) {																				
            if(e.getButton() == MouseEvent.BUTTON1)		new fr2_choWD();}
    }
}