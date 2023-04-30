package sample3;

public class Sato implements Human {
	private String name;
	public Sato(String name) {
		this.name=name;
	}
	private Item item;
	
	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public void has() {
		System.out.println(name+"입니다. 다음의 상품을 가지고 있습니다.");
		item.showName();
	}

}
