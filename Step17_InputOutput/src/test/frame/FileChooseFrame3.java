package test.frame;
/*
 * FileChooseFrame2의 ActionPerformed를 정리해보자!
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooseFrame3 extends JFrame implements ActionListener{
	
	//필드
	JButton selectBtn, selectBtn2;
	JTextArea area;
	
	//생성자
	public FileChooseFrame3(String title) {
		
		super(title);
		
		setLayout(new BorderLayout());
		
		selectBtn=new JButton("파일 선택하기");
		add(selectBtn, BorderLayout.NORTH);
		selectBtn.addActionListener(this);
		
		selectBtn2=new JButton(".txt 파일 선택하기");
		add(selectBtn2, BorderLayout.SOUTH);
		selectBtn2.addActionListener(this);
		
		area=new JTextArea();
		add(area, BorderLayout.CENTER);
		area.setBackground(Color.PINK);
		
	}
	
	//액션리스너 정리하기!
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		
		if(obj==selectBtn) {
			this.selectGeneral();
		}else if(obj==selectBtn2) {
			this.selecText();
		}
		System.out.println("actionPerformed() 메소드가 종료 됩니다.");
	}
	
	//일반 파일을 선택하는 메소드
	public void selectGeneral() {
		JFileChooser fc=new JFileChooser("c:/myFolder2");
		int result=fc.showOpenDialog(this);
		
		if(result==JFileChooser.APPROVE_OPTION) {
			File selectedFile=fc.getSelectedFile();
			String fileName=selectedFile.getName();
			JOptionPane.showMessageDialog(this, fileName+"파일을 선택했네요?");
		}else if(result==JFileChooser.CANCEL_OPTION) {
			JOptionPane.showMessageDialog(this, "취소 버튼을 눌렀네요?");
		}
	}
	
	//텍스트 파일을 선택하는 메소드
	public void selecText() {
		JFileChooser fc=new JFileChooser("c:/myFolder2");
		FileNameExtensionFilter filter=new FileNameExtensionFilter("텍스트 파일", "txt");
		fc.setFileFilter(filter);
		
		int result=fc.showOpenDialog(this);
		if(result==JFileChooser.APPROVE_OPTION) {
			File selectedFile=fc.getSelectedFile();
			
			try {
				FileReader fr=new FileReader(selectedFile);
				BufferedReader br=new BufferedReader(fr);
				
				while (true) {
					String line=br.readLine();
					if (line==null) {
						break;
					}
					area.append(line+"\r\n");
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//main 메소드
	public static void main(String[] args) {
		FileChooseFrame3 f=new FileChooseFrame3("파일 선택하는 프레임");
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
}
