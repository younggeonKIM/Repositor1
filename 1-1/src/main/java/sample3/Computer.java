package sample3;

public class Computer implements Item {
	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	public void showName() {
		System.out.println(name+"입니다.");
	}
}
