package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TextEditor2 extends JFrame implements ActionListener{

	//필드
	public static final String COMMAND_NEW="new";
	public static final String COMMAND_OPEN="open";
	public static final String COMMAND_SAVE="save";
	
	JTextArea area;
	
	//생성자
	public TextEditor2(String title) {
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
		
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		
		item1.setActionCommand(TextEditor2.COMMAND_NEW);
		item2.setActionCommand(TextEditor2.COMMAND_OPEN);
		item3.setActionCommand(TextEditor2.COMMAND_SAVE);
	}
	
	//ActionListener 메소드 뚱뚱이 메소드 만들기
	/*
	 * 할 일
	 * save-new 파일에 텍스트 입력해서 저장하기(.txt를 붙여서 저장해야한다.)
	 * open-저장된 txt 파일 불러오기
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String command=e.getActionCommand();
		
		if(command.equals(COMMAND_NEW)) {
			
			area.setVisible(true);
			area.grabFocus();
			
		}else if(command.equals(COMMAND_OPEN)) {//완성!
			
			JFileChooser fc=new JFileChooser("c:/myFolder2");
			FileNameExtensionFilter filter=new FileNameExtensionFilter("텍스트 파일", "txt");
			fc.setFileFilter(filter);
			int result=fc.showOpenDialog(this);
			
			if(result==JFileChooser.APPROVE_OPTION) {
				File selectedFile=fc.getSelectedFile();
				
				try {
					FileReader fr=new FileReader(selectedFile);
					BufferedReader br=new BufferedReader(fr);
					while(true) {
						String line=br.readLine();
						if(line==null) {
							break;
						}
						area.append(line+"\r\n");
						area.setVisible(true);
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			
			
		}else if(command.equals(COMMAND_SAVE)) {
			JFileChooser fc=new JFileChooser("c:/myFolder2");
			FileNameExtensionFilter fileter=new FileNameExtensionFilter("텍스트 파일", "txt");
			fc.setFileFilter(fileter);
			int result=fc.showSaveDialog(this);
			
			if(result==JFileChooser.APPROVE_OPTION) {
				File selectedFile=fc.getSelectedFile();
				
				String content=area.getText();
				FileWriter fw=null;
				
				try {
					fw=new FileWriter(selectedFile);
					fw.write(content);
					JOptionPane.showMessageDialog(this, "파일에 저장했습니다.");
				}catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(this, "저장 실패");
				}finally {
					
					try {
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			
			
		}
	}
		
	

	//main 메소드
	public static void main(String[] args) {
		TextEditor2 te=new TextEditor2("텍스트 편집기2");
		te.setBounds(100, 100, 500, 500);
		te.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		te.setVisible(true);
	}
}
