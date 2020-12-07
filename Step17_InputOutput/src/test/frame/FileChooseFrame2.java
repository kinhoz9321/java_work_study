package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileChooseFrame2 extends JFrame implements ActionListener{

	//필드
	JButton selectBtn, selectBtn2;
	
	//생성자
	public FileChooseFrame2(String title) {
		super(title);
		setLayout(new BorderLayout());
		this.selectBtn=new JButton("파일 선택하기");//this 생략가능
		add(selectBtn, BorderLayout.NORTH);
		selectBtn.addActionListener(this);
		
		selectBtn2=new JButton(".txt 파일 선택하기");
		add(selectBtn2, BorderLayout.SOUTH);
		selectBtn2.addActionListener(this);
	}
	
	//액션 리스너 재정의
	@Override
	public void actionPerformed(ActionEvent e) {
		//.getSource() 액션이 일어난 UI(Button)의 참조값 얻어오기(파일 2개를 구분하기 위함)
		Object obj=e.getSource();
		
		if(obj==selectBtn) {//파일 선택하기 버튼을 눌렀을 때
			
			//폴더의 시작 위치 결정
			JFileChooser fc=new JFileChooser("c:/myFolder2");
			
			//.showOpenDialog 파일을 선택해서 열 수 있는 다이얼로그. 어떤 작업을 했는지 결과를 int로 받기
			int result=fc.showOpenDialog(this);
			
			//파일을 선택하고 확인을 눌렀을 때
			if(result==JFileChooser.APPROVE_OPTION) {
				
				//선택한 파일을 Access 할 수 있는 File 객체의 참조값 얻어오기
				File selectedFile=fc.getSelectedFile();
				
				//선택한 파일의 이름 얻어오기
				String fileName=selectedFile.getName();
				
				//메세지 다이얼로그 띄우기
				JOptionPane.showMessageDialog(this, fileName+"파일을 선택했네요?");
				
			//취소 버튼을 눌렀을 때
			}else if(result==JFileChooser.CANCEL_OPTION) {
				
				//메세지 다이얼로그 띄우기
				JOptionPane.showMessageDialog(this, "취소 버튼을 눌렀네요?");
				
			}else if(result==JFileChooser.ERROR_OPTION) {
				
				JOptionPane.showMessageDialog(this, "에러");
				
			}
			
		}else if(obj==selectBtn2) {//.txt 파일 선택 버튼을 눌렀을 때
			
			//폴더의 시작 위치 결정
			JFileChooser fc=new JFileChooser("c:/myFolder2");
			
			//파일 확장자가 .txt인 파일만 선택할 수 있도록 필터 설정
			FileNameExtensionFilter filter=new FileNameExtensionFilter("텍스트 파일", "txt");
			fc.setFileFilter(filter);
			
			/*선택된 텍스트 문서에 저장된 문자열을 읽어서 콘솔창에 모두 출력할 수 있습니까?*/
			
			//.showOpenDialog 파일을 선택해서 열 수 있는 다이얼로그. 어떤 작업을 했는지 결과를 int로 받기
			int result=fc.showOpenDialog(this);
			
			//파일을 선택하고 확인을 눌렀을 때
			if(result==JFileChooser.APPROVE_OPTION) {
				
				//선택한 파일을 Access 할 수 있는 File 객체의 참조값 얻어오기
				File selectedFile=fc.getSelectedFile();
				
				try {
					
					//File 객체를 이용해서 문자열 을 읽어들일 수 있는 FileReader 객체 생성하기
					FileReader fr = new FileReader(selectedFile);
					
					//FileReader를 BufferedReader에 전달해서 기능을 업시킨다.(문자열 한 줄 읽기)
					BufferedReader br=new BufferedReader(fr);
					
					//무한 반복문 돌기
					while(true) {
						
						//문자열을 한줄씩 읽어들인다.
						String line=br.readLine();
						
						//만일 읽어들일게 없다면
						if(line==null) {
							break;//반복문 탈출
						}
						//읽어들인 문자열 콘솔창에 출력
						System.out.println(line);
					}
				}catch(Exception e1) {
						e1.printStackTrace();
					}
			}
		}
	}
	
	//main 메소드
	public static void main(String[] args) {
		FileChooseFrame2 f=new FileChooseFrame2("파일 선택하는 프레임");
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
