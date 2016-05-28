<%@page import="models.Pergunta"%>
<%@ page language="java" contentType="text/html"%>
<!DOCTYPE html>
<html>
<head>
<title>Indiana Jones - Em busca do pacote perdido</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<link rel="stylesheet" href="index.css">
</head>
<body class="container">
	<main>
	<div class="col-md-6"></div>

	<div class="col-md-6 pergunta">
		<br><br><br><br>
		<h2>Em busca do pacote perdido</h2>
		<br><br>

		<%
			Pergunta p = (Pergunta) request.getAttribute("perguntaAleatoria");
			Integer indicePergunta = (Integer) request.getAttribute("indicePergunta");
		%>
		<div>
			<div><%=p.getPergunta()%></div>
			<div>
				<%
					for (int i = 0; i < p.getRespostas().length; i++) {
				%>
				<form action="main?s=verifica" method="post">
					<button class="myButton"><%=p.getRespostas()[i]%></button>
					<br> <input type="hidden" name="resposta" value="<%=i%>">
					<input type="hidden" name="indicePergunta"
						value="<%=indicePergunta%>">
				</form>
				<%
					}
				%>
			</div>
		</div>
	</div>
	</main>

</body>
</html>