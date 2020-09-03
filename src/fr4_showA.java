import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class fr4_showA extends JFrame {
    private final static int STARBUCKS = 0;	private final static int GONGCHA = 200;
    private final static int HOLLYS = 300;	private final static int PAIKS = 400;

    private JLabel imageLabel;		private JLabel textLabel;
    private JButton button_next;	private JButton button_prev;
    int id;
    private int menu_size;
    static int start_id;
    private MySQL_Handler handler = new MySQL_Handler();
    private static ArrayList<Integer> idList = new ArrayList<>();

    public fr4_showA(int brandNum) {

        setTitle("메뉴 보여주기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout(50,50));
        
        button_prev = new JButton("<");					button_next = new JButton(">");	      			JButton B = new JButton("◀");	
       	button_prev.addMouseListener(new mousePrev());	button_next.addMouseListener(new mouseNext());	B.addMouseListener(new IVtoIII());
       
        imageLabel = new JLabel();				        textLabel = new JLabel();
        c.add(textLabel, BorderLayout.NORTH);	        c.add(imageLabel, BorderLayout.CENTER);

        textLabel.setFont(new Font("함초롬바탕", Font.PLAIN, 20));
       
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(20, 20));
        
        panel.add(button_prev, BorderLayout.WEST);			panel.add(button_next,BorderLayout.EAST);   		panel.add(B,BorderLayout.SOUTH);
        button_prev.setLocation(180,430);					button_next.setLocation(250,430);					B.setLocation(214,500);
        button_prev.setSize(50,50); 						button_next.setSize(50,50);							B.setSize(50,30);
        button_prev.setBackground(new Color(125,221,253));	button_next.setBackground(new Color(125,221,253));	B.setBackground(Color.WHITE);
        panel.setSize(200,500);
        c.add(panel,BorderLayout.SOUTH);
        
        handler.conectDB(); //DB연결
        switch (brandNum){
            case 1:
                start_id = STARBUCKS;
                idList = handler.brand_starbucks();
                break;
            case 2:
                start_id = GONGCHA;
                idList = handler.brand_gongcha();
                break;
            case 3:
                start_id = HOLLYS;
                idList = handler.brand_hollys();
                break;
            case 4:
                start_id = PAIKS;
                idList = handler.brand_paikdabang();
                break;
        }
        id = start_id;
        menu_size = idList.size();
        textLabel.setText("                           > 버튼을 누르세요!");

        setSize(500, 600);
        setVisible(true);
    }

    class mouseNext extends MouseAdapter{
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1) {
                if(start_id+menu_size>id){
                    id++;
                    showMenu(id);
                }
                else{
                    showNothing();
                }
            }
        }
    }
    class mousePrev extends MouseAdapter{
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1) {
                if(id-start_id>1){
                    id--;
                    showMenu(id);
                }
                else {
                    showNothing();
                }
            }
        }
    }
    class IVtoIII extends MouseAdapter{																//'◀' 클릭시 fr3으로 돌아가는 마우스 이벤트(뒤로가기 버튼)
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)		new fr3_choBr();}
    }	
    public void showMenu(int i){
        imageLabel.setIcon(handler.getMenuImage(i));
        textLabel.setText(handler.getMenuString(i,"NAME")+ " "
                + handler.getMenuString(i,"PRICE")+ "원 "
                + "커피 "+ handler.getMenuString(i,"COFFEE"));
    }
    public void showNothing(){
        imageLabel.setIcon(null);
        textLabel.setText("끝!");
    }
}