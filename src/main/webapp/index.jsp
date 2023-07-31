<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Autorizador de Procedimentos Médicos</title>
<script type="text/javascript" src="controller/index-controller.js"></script>
<script type="text/javascript" src="services/index-services.js"></script>
<link rel="stylesheet" type="text/css" href="style/style.css">
<link rel="icon" type="image/x-icon" href="favicon.ico">
</head>
<body onload="init();">
	<h1 id="titulo">Solicitação de procedimentos</h1>
	<div id="formAutorizador">
		<label for="procedimento">Procedimento:</label>
	    <select id="procedimento" name="procedimento">
	    	<option value="">Selecione um procedimento</option>
	    </select>
	    <label for="idade">Idade:</label>
	    <input id="idade" name="idade" type="number"/>
	    <label for="sexo">Sexo:</label>
	    <select id="sexo" name="sexo">
	    	<option value="">Selecione o sexo do paciente</option>
	    	<option value="M">Masculino</option>
	    	<option value="F">Feminino</option>
	    </select>
	    <button onclick="postSolicitacao()">Salvar</button>
	</div>
	<div id="divListaSol">
		<h2 id="subtitulo">Lista de solicitações</h2>
		<table id="listaSol">
			<thead>
				<tr>
					<th>Código Procedimento</th>
					<th>Nome Procedimento</th>
					<th>Idade</th>
					<th>Sexo</th>
					<th>Permitido</th>
				</tr>
			</thead>
			<tbody id="corpoListaSol">
			</tbody>
		</table>
	</div>
</body>
</html>