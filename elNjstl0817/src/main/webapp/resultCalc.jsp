<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
ù��° �� X=${param.N1 }
�ι�° �� Y=${param.N2 }<br/>
X+Y=${param.N1 +param.N2 }<br/>
X-Y=${param.N1+ param.N2 }<br/>
X*Y=${param.N1*param.N2	}<br/>
X/Y=${param.N1/param.N2 }<br/>
X%Y=${param.N1%param.N2 }<br/>
X�� �� Ů�ϱ�? ${param.N1-param.N2>0 }<br/>
Y�� �� Ů�ϱ�? ${param.N2-param.N1>0 }<br/>
X�� Y�� ��� ����Դϱ�? 
		${param.N1>0 && param.N2>0 }<br/>
X�� Y�� �����ϱ�?
		${param.N1 ==param.N2 ?"��":"�ƴϿ�" }<br/>
X�� ���� �ֳ��� ?
		${empty param.N1 }<br/>
X�� ���� ������ ? ${param.N2==null }<br/>
</body>
</html>