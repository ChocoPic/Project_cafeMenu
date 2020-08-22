import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class fr4_showA extends JFrame {
    final static int STARBUCKS = 1;
    final static int GONGCHA = 201;
    final static int HOLLYS = 301;
    final static int PAIKS = 401;

    JLabel imageLabel;
    JLabel textLabel;
    JButton button;
    static int id = 0;
    MySQL_Handler handler = new MySQL_Handler();

    public fr4_showA(int brandNum) {
        switch (brandNum){
            case 1:
                id = STARBUCKS; break;
            case 2:
                id = GONGCHA; break;
            case 3:
                id = HOLLYS; break;
            case 4:
                id = PAIKS; break;
        }

        setTitle("카페메뉴판_VA스_전체 메뉴 보여주기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        button = new JButton("▶");
        button.addMouseListener(new mouseE());
        imageLabel = new JLabel();
        textLabel = new JLabel();
        c.add(textLabel, BorderLayout.NORTH);
        c.add(imageLabel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setSize(50, 50);
        panel.add(button);
        c.add(panel,BorderLayout.SOUTH);

        handler.conectDB(); //DB연결
        showMenu(id); //메뉴보여주기

        setSize(400, 600);
        setVisible(true);
    }

    class mouseE extends MouseAdapter{
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON1)
            {showMenu(id);	id++; System.out.println(id);;}}
    }


    public void showMenu(int i){
        imageLabel.setIcon(handler.getMenuImage(i));
        textLabel.setText(handler.getMenuString(i,"NAME")+ " "
                + handler.getMenuString(i,"PRICE")+ "원 "
                + "커피 "+ handler.getMenuString(i,"COFFEE"));
    }

}

