package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MemberFrame extends JFrame implements ActionListener,PropertyChangeListener{
	//필드
	JTextField text_name;
	JTextField text_addr;
	
	DefaultTableModel model;
	JTable table;
	
	//생성자
	public MemberFrame(String title) {
		
		super(title);
		//프레임의 레아아웃 법칙 지정하기
		setLayout(new BorderLayout());
		
		//상단 패널
		JPanel topPanel=new JPanel();
		topPanel.setBackground(Color.PINK);
		
		//패널을 상단에 배치하기
		add(topPanel, BorderLayout.NORTH);
		
		//패널에 UI 객체를 생성해서
		JLabel label_name=new JLabel("이름");
		JLabel label_addr=new JLabel("주소");
		text_name=new JTextField(10);
		text_addr=new JTextField(10);
		JButton btn_add=new JButton("추가");
		
		//패널에 순서대로 추가하기
		topPanel.add(label_name);
		topPanel.add(text_name);
		topPanel.add(label_addr);
		topPanel.add(text_addr);
		topPanel.add(btn_add);
		
		//버튼에 ActionListener 등록
		btn_add.addActionListener(this);
		//버튼에 Action command 지정
		btn_add.setActionCommand("add");
		
		//회원 목록을 출력할 테이블
		table=new JTable();
		
		//칼럼명을 String[]에 순서대로 준비하기
		String[] colNames= {"번호", "이름", "주소"};
		
		//테이블에 연결할 기본 모델 객체
		model=new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				System.out.println(row+"|"+column);
				if(column==0) {
					return false;
				}else {
					return true;
				}
			}
		};
			
		
		//모델을 테이블에 연결하기
		table.setModel(model);
		
		//테이블을 내용이 scroll 될 수 있도록 스크롤 패널로 감싸기.
		JScrollPane scPane=new JScrollPane(table);
		
		//스크롤 패널을 프레임의 중앙에 배치하기
		add(scPane, BorderLayout.CENTER);
		
		//회원 목록을 테이블에 출력하기
		printMember();
		
		/* 
		 * 삭제버튼 - 특정 로우를 선택한 다음에 삭제를 누르면 삭제되게 하기.
		 * (선택한 num을 이용해서 삭제하기. 삭제하고 목록 불러오기.)
		 */
		
		JButton btn_delete=new JButton("삭제");
		topPanel.add(btn_delete);
		
		btn_delete.addActionListener(this);
		btn_delete.setActionCommand("delete");
		
		table.addPropertyChangeListener(this);
	}
	
	//main 메소드
	public static void main(String[] args) {
		MemberFrame f=new MemberFrame("회원 정보 관리");
		f.setBounds(100, 100, 800, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	//ActionListener 메소드 재정의
	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		
		if(command.equals("add")) {
			addMember();
			
		}else if(command.equals("delete")){
			deleteMember();
		}
	}
	
	//회원 목록을 테이블에 출력하는 메소드 3가지 방법
	/* 1 */
//	public void printMember() {
//		MemberDao dao=new MemberDao();
//		List<MemberDto> list=dao.selectAll();
//		model.setRowCount(0);
//		
//		for(int i=0; i<list.size(); i++) {
//			Vector<Object> row=new Vector<>();
//			row.add(list.get(i).getNum());
//			row.add(list.get(i).getName());
//			row.add(list.get(i).getAddr());
//			
//			model.addRow(row);
//		}
//	}
	
	/* 2 */
//	public void printMember() {
//		MemberDao dao=new MemberDao();
//		List<MemberDto> list=dao.selectAll();
//		model.setRowCount(0);
//		
//		for(MemberDto tmp:list) {
//			Vector<Object> row=new Vector<Object>();
//			row.add(tmp.getNum());
//			row.add(tmp.getName());
//			row.add(tmp.getAddr());
//			
//			model.addRow(row);
//		}
//	}
	
	/* 3 생각해보기. object로 만드는 법 다시 보고 for문 일반for문으로 고쳐보기*/
	public void printMember() {
		MemberDao dao=new MemberDao();
		List<MemberDto> list = dao.selectAll();
		model.setRowCount(0);
		
		//model.setRowCount(0); // 0 개의 row 로 강제로 초기화 하고
		      
		for (MemberDto tmp : list) {
			Object[] row ={tmp.getNum(),tmp.getName(),tmp.getAddr() };
		   model.addRow(row);
		}
	}
	
	//회원 정보를 추가하는 메소드
	public void addMember() {
		String name=text_name.getText();
		String addr=text_addr.getText();
		
		MemberDao dao=new MemberDao();
		
		MemberDto dto=new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		boolean isSuccess=dao.insert(dto);
		
		if(isSuccess) {
			JOptionPane.showMessageDialog(this, name+" 의 정보 추가 성공");
			printMember();
			
		}else {
			JOptionPane.showMessageDialog(this, "추가 실패");
		}
	}
	
	//회원 정보를 삭제하는 메소드
	public void deleteMember() {
		int selectedIndex=table.getSelectedRow();
		if(selectedIndex==-1) {
			JOptionPane.showMessageDialog(this, "삭제할 row를 선택해주세요.");
			return;
		}
		int num=(int)table.getValueAt(selectedIndex, 0);
		
		int result=JOptionPane.showConfirmDialog(this, num+" 번 회원을 삭제 하시겠습니까?");
		if(result==JOptionPane.YES_OPTION) {
			new MemberDao().delete(num);
			printMember();
		}
		
		MemberDao dao=new MemberDao();
		dao.delete(num);
		printMember();
	}
	
	class UpdateThread extends Thread {
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(5000);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
				printMember();
			}
		}
	}

	//회원정보를 수정하는 메소드
	
	//필드
	boolean isEditing=false;
	
	//PropertyChangeListener 메소드 재정의
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("change");
		System.out.println(evt.getPropertyName());
		if(evt.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) {
				int selectedIndex=table.getSelectedRow();
				
				int num=(int)model.getValueAt(selectedIndex, 0);
				String name=(String)model.getValueAt(selectedIndex, 1);
				String addr=(String)model.getValueAt(selectedIndex, 2);
				
				MemberDto dto=new MemberDto(num, name, addr);
				new MemberDao().update(dto);
			}
			isEditing=!isEditing;
		}
		
	}
}
