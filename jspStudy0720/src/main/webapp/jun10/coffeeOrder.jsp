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
String menu=request.getParameter("MENU"); //커피 이름
String quan=request.getParameter("NUM"); //커피 개수
String brea=request.getParameter("BREAD"); //빵 이름
String num=request.getParameter("QUAN"); //빵 개수
// int totCoPrice=findTotal(menu,quan); //커피 총계
// 						//결과를 보여주는 JSP(coffeeResult.jsp)로 전환
// 						//Redirect, forward, 두 방법 상관없음
// int totBrePrice=findBreaTotal(brea,num); //빵 총계
int grandTotal=findAllPrice(menu,quan,brea,num); //커피+빵 총계
	// response.sendRedirect("coffeeResult.jsp?Tot="+grandTotal);
	request.setAttribute("total",grandTotal);
	RequestDispatcher rd=request.getRequestDispatcher("coffeeResult.jsp");
	rd.forward(request, response);
%>
<%!
int findAllPrice(String m1 , String m2 , String m3 , String m4) {
	int drinksnu=Integer.parseInt(m2); //커피 개수
	int breadnu=Integer.parseInt(m4); //빵 개수
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
	if (name.equals("A")){//아메리카노:2000
		price=2000;
	}else if(name.equals("B")){//카푸치노:3000
		price=3000;
	}else if(name.equals("C")){//카페라테:3500
		price=3500;
	}else if(name.equals("D")){//카페오레:3300
		price=3300;
	}else {//카페모카:3800
		price=3800;
	}
	int totalprice=price*num; //총액 계산
	return totalprice;
}
int findBreaTotal (String name, String number) {
	int num=Integer.parseInt(number);
	int price=0;
	if (name.equals("A")) {//핫도그
		price=4000;
	} else if(name.equals("B")) {//크루아상
		price=3000;
	} else if(name.equals("C")) {//크림빵
		price=3000;
	} else if(name.equals("D")) {//호밀빵
		price=4000;
	} else {//고로케
		price=4500;
	}
	int totBre=price*num;
	return totBre;
}
%>
</body>
</html>