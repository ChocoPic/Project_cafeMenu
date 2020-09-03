import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class fr2_choWD extends JFrame{
	public fr2_choWD() {
		setTitle("카페메뉴판_VA스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);															/*프레임윈도우 닫을때 스윙 프로그램 같이 종료*/
		
		Container WD = getContentPane();
		WD.setLayout(null);																						//컨텐트판 (null-제거)배치관리자 설정				

		JButton s = new JButton("메뉴 보여주기");				JButton r = new JButton("메뉴 추천해주기"); 
		s.setLocation(90,210);								r.setLocation(270,210);	 							//버튼 위치 설정
		s.setSize(130,100);									r.setSize(130,100); 	 							//버튼 크기 설정
		s.setBackground(new Color(193,253,237));			r.setBackground(new Color(255,170,170));			//버튼 배경색 설정
		s.setFont(new Font("맑은 고딕", Font.PLAIN, 15));		r.setFont(new Font("맑은 고딕", Font.PLAIN, 13));		//텍스트 폰트, 크기 설정
		
		WD.add(s);	WD.add(r);																					//버튼을 컨텐트팬에 부착
		
		s.addMouseListener(new IItoIII());	r.addMouseListener(new IIto_III());									//버튼에 마우스 이벤트 리스너 등록
											
		setSize(500,600);																						//프레임 크기
		setVisible(true);																						/*프레임을 화면에 출력*/
	}
	class IItoIII extends MouseAdapter{																			//'보여주기' 클릭시 fr3으로 넘어가는 마우스 이벤트 
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1)		new fr3_choBr();}		
	}
	class IIto_III extends MouseAdapter{																		//'추천해주기' 클릭시 fr_3으로 넘어가는 마우스 이벤트 
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1)		new fr_3_choR();}		
	}
}