import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class fr1_START extends JFrame{
	public fr1_START() {
		setTitle("카페메뉴판_VA스");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);																/*프레임윈도우 닫을때 스윙 프로그램 같이 종료*/
		
		Container c = getContentPane();
		c.setLayout(null);																							//컨텐트판 (null-제거)배치관리자 설정				
			
		JLabel t = new JLabel("< 카페 메뉴판 >");					JLabel n = new JLabel("VA스");					
		t.setLocation(130,70); 									n.setLocation(220,350);								//텍스트 위치 설정
		t.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 30));		n.setFont(new Font("휴먼엑스포", Font.PLAIN, 20));		//텍스트 폰트, 크기 설정
		t.setSize(350,200);										n.setSize(150,150);									//컴포넌트 크기 설정		
		c.add(t); c.add(n); 																						//텍스트를 컨텐트팬에 부착
		
		c.addMouseListener(new ItoII());																			//컨텐트팬에 마우스 이벤트 리스너 등록
		
		setSize(500,600);																							//프레임 크기
		setVisible(true);																							/*프레임을 화면에 출력*/
	}	
	class ItoII extends MouseAdapter{																				//fr1 클릭시 fr2로 넘어가는 마우스 이벤트 
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1)		new fr2_choWD();}		
	}
	public static void main(String[] args) {
		new fr1_START();																							//>>>>>전체 프로그램 시작<<<<<
	}
}