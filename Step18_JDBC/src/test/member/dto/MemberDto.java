package test.member.dto;
/* 
 * row 하나의 정보를 객체 1개에 넣기 -> MemberDto
 * row 여러개의 정보를 list<>제네릭? list<MemberDto>에 담는 연습하기
 */
public class MemberDto {
	//필드 (private 설정 객체 내부에서만 참조 가능)
	private int num;
	private String name;
	private String addr;
	
	//디폴트 생성자
	public MemberDto() {}
	
	//생성자 (Generate Constructor using fields)
	public MemberDto(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}

	//getter, setter 설정
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
