var ajax = new XMLHttpRequest();

function getListaProcedimentos() {
	ajax.open('GET', '/autorizador_procedimentos_medicos/api/authorizer?method=procedimentos', true);
	
	ajax.send();
	
	return ajax;	
}

function getListaSolicitacoes() {
	ajax.open('GET', '/autorizador_procedimentos_medicos/api/authorizer?method=solicitacoes', true);
	
	ajax.send();
	
	return ajax;
}

function saveSolicitacoes(data) {
	let json = JSON.stringify(data);
	
	ajax.open('POST', '/autorizador_procedimentos_medicos/api/authorizer', true);
	
	ajax.send(json);
	
	return ajax;
}
