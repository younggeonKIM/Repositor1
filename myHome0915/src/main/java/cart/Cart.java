package cart;

import java.util.ArrayList;

import bbs.CRUD;
import items.CartItem;

public class Cart {
	public Cart(String id) {
		this.id=id;
	}
	private String id; //����
	private ArrayList<String> codeList = new ArrayList<String>(); //��ǰ��ȣ ����� ���� ����
	private ArrayList<Integer> numList = new ArrayList<Integer>(); //��ǰ���� ����� ���� ����
	
	public ArrayList<String> getCodeList() {
		return codeList;
	}

	public ArrayList<Integer> getNumList() {
		return numList;
	}

	public void addCart(String code, int num) {
		for(int i=0 ; i<codeList.size() ; i++) {
			if(codeList.get(i).equals(code)) {
				numList.set(i,numList.get(i)+num);
				//DB���� ����
				CRUD crud = new CRUD();
				CartItem ci=new CartItem();
				ci.setId(this.id); //���� ����
				ci.setCode(code); //��ǰ��ȣ ����
				ci.setNum(numList.get(i)); //��ǰ���� ����
				crud.updateCart(ci); //��ٱ��� ���̺� update
				//DB���� ��
				return; //�޼��� ����
			}//i��°�� �ִ� ��ǰ��ȣ�� code�� �ִ� ��ǰ��ȣ�� ������ ��
		}//codeList�� �ִ� ��ǰ��ȣ�� ������ŭ �ݺ�
		//codeList�� code�� �ִ� ��ǰ��ȣ�� �ִ��� �˻�
		//codeList�� ������ ��ǰ��ȣ�� ������ ������ ����
		codeList.add(code); numList.add(num);
		//DB���� ����
		CRUD crud=new CRUD();
		CartItem ci=new CartItem();
		ci.setSeq(crud.maxCart()+1); //�Ϸù�ȣ ����
		ci.setId(this.id); //���� ����
		ci.setCode(code); //��ǰ��ȣ ����
		ci.setNum(num); //��ǰ���� ����
		crud.addCart(ci); //��ٱ��� ���̺� ����
		//DB���� ��
	}
	
	public void modifyItem(String id, int num) {
		for(int i=0; i<codeList.size() ; i++) {
			if(codeList.get(i).equals(id)) {
				numList.set(i, num); //i��° ��ǰ������ num���� ����
				//DB���� ����
				CRUD crud=new CRUD();
				CartItem ci=new CartItem();
				ci.setId(this.id); ci.setCode(id);
				ci.setNum(numList.get(i));
				crud.updateCart(ci);
				//DB���� ��
				return; //�޼��� ����
			} //i��° ��ǰ��ȣ�� �����Ϸ��� ��ǰ��ȣ�� ���� ���
		}
	} //��ٱ��Ͽ��� ��ǰ�� ������ �����ϴ� �޼���
	
	public void deleteItem(String id) {
		for(int i=0 ; i < codeList.size() ; i++) {
			if(codeList.get(i).equals(id)) {
				codeList.remove(i); //i��° ��ǰ��ȣ ����
				numList.remove(i); //i��° ��ǰ���� ����
				//DB���� ����
				CRUD crud=new CRUD();
				CartItem ci=new CartItem();
				ci.setId(this.id);
				ci.setCode(id);
				crud.deleteCart(ci);
				//DB���� ��
				return; //�޼��� ����
			} //i��° ��ǰ��ȣ�� �����Ϸ��� ��ǰ��ȣ�� ���� ���
		}
	} //��ٱ��Ͽ��� ��ǰ�� �����ϴ� �޼���

} //��ٱ��Ͽ� ��ü
