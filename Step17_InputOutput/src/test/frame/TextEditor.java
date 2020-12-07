package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class TextEditor extends JFrame implements ActionListener{

	//필드
	public static final String COMMAND_NEW="new";
	public static final String COMMAND_OPEN="open";
	public static final String COMMAND_SAVE="save";
	
	JTextArea area;
	
	//생성자
	public TextEditor(String title) {
		super(title);
		setLayout(new BorderLayout());
		
		JMenu menu1=new JMenu("File");
		JMenu menu2=new JMenu("Help");
		
		JMenuBar mb=new JMenuBar();
		
		mb.add(menu1);
		mb.add(menu2);
		
		this.setJMenuBar(mb);
		
		JMenuItem item1=new JMenuItem("New");
		JMenuItem item2=new JMenuItem("Open");
		JMenuItem item3=new JMenuItem("Save");
		
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		
		area=new JTextArea();
		add(area, BorderLayout.CENTER);
		area.setBackground(Color.PINK);
		
		area.setVisible(false);
	}
	
	//ActionListener 메소드
	/*
	 * 할 일
	 * save-new 파일에 텍스트 입력해서 저장하기
	 * open-저장된 txt 파일 불러오기
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command=e.getActionCommand();
		
		if(command.equals(COMMAND_NEW)) {
			
			area.setVisible(true);
			area.grabFocus();
			
		}else if(command.equals(COMMAND_OPEN)) {
			
			JFileChooser fc=new JFileChooser("c:/myFolder2");
			int result=fc.showOpenDialog(this);
			
		}else if(command.equals(COMMAND_SAVE)) {
			
			JFileChooser fc=new JFileChooser("c:/myFolder2");
			int result=fc.showOpenDialog(this);
			
		}
	}

	//main 메소드
	public static void main(String[] args) {
		TextEditor te=new TextEditor("텍스트 편집기1");
		te.setBounds(100, 100, 500, 500);
		te.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		te.setVisible(true);
	}
}
