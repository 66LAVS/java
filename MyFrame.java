package aa;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;


public class MyFrame {
	 public static JLabel statusLabel;
	 public static JLabel statusLabel1;
	 public static JTextArea area;

    public static void main(String[] args) {
        JFrame frame = new JFrame("FrameDemo");// создаем окно с заголовком FrameDemo
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);// задаем размер окна
        
        setNorth(frame); // вызываем метод для заполнения левой области
        setWest(frame);
        setEast(frame); // вызываем метод для заполнения правой области
        setCenter(frame); // вызываем метод для заполнения центральной области
        setSouth(frame); // вызываем метод для заполнения нижней области
        
        statusLabel = new JLabel("Статус: ");
        statusLabel.addMouseListener(new MyFrame().new MyMouseListener());
        frame.add(statusLabel, BorderLayout.NORTH);
        
        statusLabel1 = new JLabel("Нажитие");
        statusLabel1.addMouseListener(new MyFrame().new MyMouseListener());
        frame.add(statusLabel1, BorderLayout.SOUTH);
        
        frame.setVisible(true);// делаем окно видимым
        frame.pack(); // упаковываем его
        frame.setMinimumSize(frame.getSize());

	}

class MyMouseListener implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

		statusLabel1.setText("Нажата кнопка коррдинаты Х " + e.getComponent().getX() + "Y " + e.getComponent().getY());
		if (e.getComponent() instanceof JButton) {
            JButton button = (JButton) e.getComponent();
            String buttonText = button.getText();
            area.append("Нажата кнопка: " + buttonText + "\n");
            if ("Стереть".equals(buttonText)) {
           	 area.setText("");
           }
        }
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getComponent() instanceof JLabel) {
            JLabel label = (JLabel) e.getComponent();
            String text = label.getText();
            statusLabel.setText("Текст внутри - " + text);
        } else if (e.getComponent() instanceof JButton) {
            JButton button = (JButton) e.getComponent();
            String text = button.getText();
            statusLabel.setText("Текст внутри - " + text);
           
        }
	}

	@Override
	public void mouseExited(MouseEvent e) {
		statusLabel1.setText("Ничего не нажато");
		statusLabel.setText("Текст внтури - ");
		
	}
 } 

	public static void setNorth(JFrame fr) { // верх ^
		Box myBox1 = new Box(BoxLayout.X_AXIS);
		for (int i = 0; i < 6; i++) {
			myBox1.add(Box.createHorizontalStrut(5));
			myBox1.add(new JLabel("Метка" + i));
			if (i == 2) {
				myBox1.add(Box.createHorizontalGlue());
			}
		}
		fr.add(myBox1, BorderLayout.NORTH);
	}

	public static void setEast(JFrame fr) { // метод для заполнения правой области ->
		ButtonGroup myGroup = new ButtonGroup();
		JPanel myPanel2 = new JPanel();
		ArrayList<JRadioButton> masRB = new ArrayList<JRadioButton>();
		myPanel2.setLayout(new GridLayout(11, 1));
		for (int i = 0; i < 10; i++) {
			masRB.add(new JRadioButton("Выбор " + i));
			myGroup.add(masRB.get(i));
			myPanel2.add(masRB.get(i));
		}
		masRB.get(0).setSelected(true);
		
		fr.add(myPanel2, BorderLayout.EAST);
	}

	public static void setWest(JFrame fr) { //левая <---
		Box myBox1 = new Box(BoxLayout.Y_AXIS);
		for (int i = 0; i < 10; i++) {
			JButton button1 = new JButton("Кнопка " + i);
			button1.addMouseListener(new MyFrame().new MyMouseListener()); 
			myBox1.add(button1);
			myBox1.add(Box.createVerticalStrut(10));
		}
		fr.add(myBox1, BorderLayout.WEST);

	}

	public static void setCenter(JFrame fr) { // метод для заполнения центральной области
		Box myBox1 = new Box(BoxLayout.Y_AXIS);
		
		Box myBox2 = new Box(BoxLayout.X_AXIS);
		
		
		 area = new JTextArea();
	        area.addMouseListener(new MyFrame().new MyMouseListener());
	        myBox1.add(area);
		
		myBox2.add(Box.createVerticalStrut(5));
		JButton Button1 = new JButton("Стереть");
		Button1.addMouseListener(new MyFrame().new MyMouseListener());
		myBox2.add(Button1);
		
		myBox2.add(Box.createVerticalStrut(5));
		myBox2.add(new JButton("Кнопка 12"));
		myBox2.add(Box.createVerticalStrut(5));
		
		JPanel myPanel1=new JPanel(new BorderLayout());//

		myPanel1.add(myBox2, BorderLayout.NORTH);//добавляем кнопку
		
		myBox1.add(myPanel1);	
		fr.add(myBox1, BorderLayout.CENTER);
	}

	public static void setSouth(JFrame fr) { // метод для заполнения нижней области |
		JPanel myPanel2 = new JPanel(new BorderLayout());
		Box myBox2 = new Box(BoxLayout.X_AXIS);
		
		myBox2.add(new JTextField()); 
		myBox2.add(new JButton("Кнопка 1"));
		myPanel2.add(myBox2, BorderLayout.EAST);
		
		fr.add(myPanel2, BorderLayout.SOUTH);
	}
}