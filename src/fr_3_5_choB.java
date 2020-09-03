import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class fr_3_5_choB extends JFrame{
	public fr_3_5_choB() {
		setTitle("메뉴 추천해주기_브랜드별 메뉴 추천");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);																			/*프레임윈도우 닫을때 스윙 프로그램 같이 종료*/
		
		Container BR = getContentPane();
		BR.setLayout(null);																										//컨텐트판 (null-제거)배치관리자 설정				
								
		JButton s = new JButton("스타벅스"); JButton p = new JButton("빽다방"); JButton g = new JButton("공차"); JButton h = new JButton("할리스커피"); JButton B = new JButton("◀");		
        
        s.setLocation(65,80);	p.setLocation(270,80);	g.setLocation(65,270);	h.setLocation(270,270);	B.setLocation(215,460);	//버튼 위치 설정
        s.setSize(150,150);		p.setSize(150,150);		g.setSize(150,150);		h.setSize(150,150);		B.setSize(50,50);		//버튼 크기 설정
        s.setBackground(new Color(0,185,0));	 p.setBackground(new Color(0,111,221));											//버튼 배경색 설정
        g.setBackground(new Color(219,0,0));	 h.setBackground(new Color(255,47,47));	B.setBackground(Color.WHITE);	
        s.setFont(new Font("맑은 고딕", Font.PLAIN, 18));		p.setFont(new Font("맑은 고딕", Font.PLAIN, 18));						//텍스트 폰트, 크기 설정
        g.setFont(new Font("맑은 고딕", Font.PLAIN, 18));		h.setFont(new Font("맑은 고딕", Font.PLAIN, 18));
        s.setForeground(Color.WHITE); p.setForeground(Color.WHITE); g.setForeground(Color.WHITE); h.setForeground(Color.WHITE);	//텍스트 글자색 설정
   
        BR.add(s); BR.add(p); BR.add(g); BR.add(h); BR.add(B); 																	//버튼을 컨텐트팬에 부착

        s.addMouseListener(new III_VtoS());	p.addMouseListener(new III_VtoP());													//버튼에 마우스 이벤트 리스너 등록
        g.addMouseListener(new III_VtoG());	h.addMouseListener(new III_VtoH());	B.addMouseListener(new III_VtoIII());		
        
		setSize(500,600);																										//프레임 크기
		setVisible(true);																										/*프레임을 화면에 출력*/
	}	
	class III_VtoS extends MouseAdapter{																						//'스타벅스' 클릭시 fr_4로 넘어가는 마우스 이벤트
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)		new fr_4_recB(1); }
    }
    class III_VtoP extends MouseAdapter{																						//'빽다방' 클릭시 fr_4으로 넘어가는 마우스 이벤트
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)		new fr_4_recB(4);}
    }
    class III_VtoG extends MouseAdapter{																						//'공차' 클릭시 fr_4으로 넘어가는 마우스 이벤트
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)		new fr_4_recB(2);}
    }
    class III_VtoH extends MouseAdapter{																						//'할리스커피' 클릭시 fr_4으로 넘어가는 마우스 이벤트
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)		new fr_4_recB(3);}
    }
    class III_VtoIII extends MouseAdapter{																						//'◀' 클릭시 fr3으로 돌아가는 마우스 이벤트(뒤로가기 버튼)
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)		new fr_3_choR();}
    }
}