package lab7_rama;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;

public class ListWithHashPopUp extends JFrame {
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JPanel panel1 = null;
	private static Image image;
	static File f1;
	private static HashMap<String, List<String>> myHash = new HashMap<String, List<String>>();
	private static HashMap<String, String> myHash1 = new HashMap<String, String>();
	static JPopupMenu myPopup;

	public static void main(String[] args) {
		ListWithHashPopUp window = new ListWithHashPopUp("Работа со списком");
		window.setVisible(true);
		window.pack();
		window.setMinimumSize(window.getSize());
	}

	public ListWithHashPopUp(String s) {
		super(s);

		myHash.put("Пастушок Никитос", List.of("Группа 3301", "Джава 2", ""));
		myHash.put("Овчиев Рамиль", List.of("Группа 3303", "Джава 5", ""));
		myHash.put("Бутяга Тимофей", List.of("Группа 3303", "Джава 4", ""));
		myHash.put("Мухамметова Карина", List.of("Группа 3304", "Робототехника 4", ""));
		myHash.put("Какой то тип", List.of("Группа 3305", "Робототехника 3", ""));

		final DefaultListModel myListModel = new DefaultListModel();
		for (String i : myHash.keySet()) {
			myListModel.addElement(i);
		}

		final JList myList = new JList();

		JScrollPane myScroll = new JScrollPane(myList);

		myList.setModel(myListModel);

		myPopup = new JPopupMenu();
		JMenuItem myItem1 = new JMenuItem("Связать с картинкой");
		myList.setComponentPopupMenu(myPopup);
		myItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadFromFile(myList.getSelectedValue().toString());
			}
		});
		myList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String path = myHash1.get(myList.getSelectedValue().toString());
				loadImage(path);
			}
		});
		myPopup.add(myItem1);
		myList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				try {
				myList.setSelectedIndex(myList.locationToIndex(e.getPoint()));
				String key1 = myList.getSelectedValue().toString();
				List<String> values = myHash.get(key1);
				label1.setText(values.get(0));
				label2.setText(values.get(1));
				}catch (Exception ex) {
					String key1 = myList.getSelectedValue().toString();
					myHash.put(key1, List.of("НОВЫЙ СТУДЕНТ", "НОВЫЙ СТУДЕНТ"));
				}
			}
		});

		Box myBox1 = new Box(BoxLayout.Y_AXIS);
		final JTextField myText = new JTextField();
		myBox1.add(myText);
		Box box1 = new Box(BoxLayout.X_AXIS);
		JButton button1 = new JButton("Добавить в список");
		box1.add(button1);
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myListModel.addElement(myText.getText());
			}
		});
		JButton button2 = new JButton("Убрать из списка");
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				while (myListModel.contains(myText.getText())) {
					myListModel.removeElement(myText.getText());
				}
			}
		});
		box1.add(button2);
		JButton buttonClear = new JButton("Очистить список");
		buttonClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myListModel.clear();
			}
		});
		box1.add(buttonClear);
		myBox1.add(box1);

		panel1 = new JPanel();

		myList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				String path = myHash1.get(myList.getSelectedValue().toString());
				loadImage(path);
			}
		});

		Box centerBox = new Box(BoxLayout.Y_AXIS);
		centerBox.add(myScroll);
		centerBox.add(panel1);
		Box box2 = new Box(BoxLayout.X_AXIS);
		label1 = new JLabel("");
		box2.add(label1, BorderLayout.CENTER);
		box2.add(Box.createHorizontalStrut(20)); // Или другой размер
		label2 = new JLabel("");
		box2.add(label2, BorderLayout.NORTH);
		centerBox.add(box2);
		add(centerBox, BorderLayout.CENTER);
		add(myBox1, BorderLayout.NORTH);
	}

	public void loadImage(String path) {
		try {
			if (path != null) {
				f1 = new File(path);
				image = ImageIO.read(f1);
				Graphics2D g = (Graphics2D) panel1.getGraphics();
				g.setColor(panel1.getBackground());
				g.clearRect(0, 0, panel1.getWidth(), panel1.getHeight());
				g.drawImage(image, 0, 0, null);
			} else
				throw new IOException();
		} catch (IOException e1) {
			panel1.repaint();
		}
	}

	public void loadFromFile(String s) {
		FileDialog fdlg = new FileDialog(this, "Загрузить картинку", FileDialog.LOAD);
		fdlg.setFile("*.jpg");
		fdlg.setVisible(true);
		myHash1.put(s, fdlg.getDirectory() + fdlg.getFile());
		loadImage(fdlg.getDirectory() + fdlg.getFile());
	}
}
