package items;

public class Item {
	private String id; //상품번호
	private int num; //개수
	private String name; //상품이름
	private int price; //가격
	private String spec; //설명
	private String origin; //원산지
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPric() {
		return price;
	}
	public void setPric(int pric) {
		this.price = pric;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public String getOrig() {
		return origin;
	}
	public void setOrig(String orig) {
		this.origin = orig;
	}
	
}
