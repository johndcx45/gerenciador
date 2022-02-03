<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Nova Empresa</title>
	</head>
	<body>
		<form action="${ linkServletNovaEmpresa }">
			Nome: <input type="text" name="nome">
			Quantidade de Funcionarios: <input type="text" name="qtdFuncionarios">
			Localizacao: <input type="text" name="localizacao">
			Faturamento: <input type="text" name="faturamento">
			<input type="submit">
		</form>
	</body>
</html>