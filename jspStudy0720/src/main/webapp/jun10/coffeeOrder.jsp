<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
String menu=request.getParameter("MENU"); //Ŀ�� �̸�
String quan=request.getParameter("NUM"); //Ŀ�� ����
String brea=request.getParameter("BREAD"); //�� �̸�
String num=request.getParameter("QUAN"); //�� ����
// int totCoPrice=findTotal(menu,quan); //Ŀ�� �Ѱ�
// 						//����� �����ִ� JSP(coffeeResult.jsp)�� ��ȯ
// 						//Redirect, forward, �� ��� �������
// int totBrePrice=findBreaTotal(brea,num); //�� �Ѱ�
int grandTotal=findAllPrice(menu,quan,brea,num); //Ŀ��+�� �Ѱ�
	// response.sendRedirect("coffeeResult.jsp?Tot="+grandTotal);
	request.setAttribute("total",grandTotal);
	RequestDispatcher rd=request.getRequestDispatcher("coffeeResult.jsp");
	rd.forward(request, response);
%>
<%!
int findAllPrice(String m1 , String m2 , String m3 , String m4) {
	int drinksnu=Integer.parseInt(m2); //Ŀ�� ����
	int breadnu=Integer.parseInt(m4); //�� ����
	int totalPrice=0;
	switch (m1) {
	case "A": totalPrice=totalPrice+drinksnu*2000; break;
	case "B": totalPrice=totalPrice+drinksnu*3000; break;
	case "C": totalPrice=totalPrice+drinksnu*3500; break;
	case "D": totalPrice=totalPrice+drinksnu*3300; break;
	case "E": totalPrice=totalPrice+drinksnu*3800; break;
	}
	switch (m3) {
	case "A": totalPrice=totalPrice+drinksnu*4000; break;
	case "B": totalPrice=totalPrice+drinksnu*3000; break;
	case "C": totalPrice=totalPrice+drinksnu*3000; break;
	case "D": totalPrice=totalPrice+drinksnu*4000; break;
	case "E": totalPrice=totalPrice+drinksnu*4500; break;
	}
	return totalPrice;
}
int findTotal(String name,String number) {
	int num=Integer.parseInt(number);
	int price=0;
	if (name.equals("A")){//�Ƹ޸�ī��:2000
		price=2000;
	}else if(name.equals("B")){//īǪġ��:3000
		price=3000;
	}else if(name.equals("C")){//ī�����:3500
		price=3500;
	}else if(name.equals("D")){//ī�����:3300
		price=3300;
	}else {//ī���ī:3800
		price=3800;
	}
	int totalprice=price*num; //�Ѿ� ���
	return totalprice;
}
int findBreaTotal (String name, String number) {
	int num=Integer.parseInt(number);
	int price=0;
	if (name.equals("A")) {//�ֵ���
		price=4000;
	} else if(name.equals("B")) {//ũ��ƻ�
		price=3000;
	} else if(name.equals("C")) {//ũ����
		price=3000;
	} else if(name.equals("D")) {//ȣ�л�
		price=4000;
	} else {//�����
		price=4500;
	}
	int totBre=price*num;
	return totBre;
}
%>
</body>
</html>