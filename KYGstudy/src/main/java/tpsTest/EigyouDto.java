package tpsTest;

public class EigyouDto {
	private int eigyouId;
	private String eigyouSyainbango;
	private String eigyouName;
	
	public int getEigyouId() {
		return eigyouId;
	}
	public void setEigyouId(int eigyouId) {
		this.eigyouId = eigyouId;
	}
	public String getEigyouSyainbango() {
		return eigyouSyainbango;
	}
	public void setEigyouSyainbango(String eigyouSyainbango) {
		this.eigyouSyainbango = eigyouSyainbango;
	}
	public String getEigyouName() {
		return eigyouName;
	}
	public void setEigyouName(String eigyouName) {
		this.eigyouName = eigyouName;
	}
	
	public void printDetail() {
		String eId=String.format("%03d", this.eigyouId);

		if(this.eigyouId < 10) {
			System.out.println(this.eigyouName+"씨의 영업ID는 "+eId+"이며, 사원번호는"+
					this.eigyouSyainbango);
		} else if(getEigyouId() < 100) {
			System.out.println(getEigyouName()+"씨의 영업ID는 "+eId+"이며, 사원번호는"+
					this.eigyouSyainbango); 
		} else {
			System.out.println(getEigyouName()+"씨의 영업ID는 "+eId+"이며, 사원번호는"+
					this.eigyouSyainbango); 
		}
	}
}
