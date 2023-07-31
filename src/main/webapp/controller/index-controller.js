function init() {
	let req = getListaProcedimentos();

	req.onload = function() {
		if (ajax.status >= 200 && ajax.status < 400) {
			let data = JSON.parse(ajax.response);
			data.forEach((element) => {
				let select = document.getElementById('procedimento');
				let option = document.createElement('option');

				option.text = element.nomeProcedimento;
				option.value = element.idProcedimento;
				select.appendChild(option);
			});

			getSolicitacoes();
		}
	};
}

function getSolicitacoes() {
	let req = getListaSolicitacoes();

	req.onload = function() {
		if (ajax.status >= 200 && ajax.status < 400) {
			let tbodyTable = document.getElementById("corpoListaSol");
			
			let data = JSON.parse(ajax.response);
			
			if (data.length > 0) {
				data.forEach(element => {
					let trTable = document.createElement("tr");

					let idProcedimento = document.createElement("td");

					idProcedimento.innerHTML = element.procedimento.idProcedimento;

					let nomeProcedimento = document.createElement("td");

					nomeProcedimento.innerHTML = element.procedimento.nomeProcedimento;

					let idadeElement = document.createElement("td");

					idadeElement.innerHTML = element.idade;
					
					let sexoElement = document.createElement("td");

					sexoElement.innerHTML = element.sexo == 'M'? 'Masculino' : 'Feminino';
					
					let permitidoElement = document.createElement("td");

					permitidoElement.innerHTML = element.permitido == 'S'? 'Sim' : 'Não';
					
					trTable.appendChild(idProcedimento);
					trTable.appendChild(nomeProcedimento);
					trTable.appendChild(idadeElement);
					trTable.appendChild(sexoElement);					
					trTable.appendChild(permitidoElement);
					
					tbodyTable.appendChild(trTable);
				});
				
			}
		}
	};
}

function postSolicitacao() {
	let idProcedimento = document.getElementById('procedimento').value;
	let idade = document.getElementById('idade').value;
	let sexo = document.getElementById('sexo').value;
	
	let invalid = false;
	
	if (!idProcedimento) {
		document.getElementById('procedimento').ariaInvalid = 'true';
		invalid = true;
	}
	
	if (!idade) {
		document.getElementById('idade').ariaInvalid = 'true';
		invalid = true;
	}
	
	if (!sexo) {
		document.getElementById('sexo').ariaInvalid = 'true';
		invalid = true;
	}
	
	if (!invalid) {
		let data = {
			procedimento: {
				idProcedimento: idProcedimento
			},
			idade: idade,
			sexo: sexo
		};
		
		let req = saveSolicitacoes(data);
		
		req.onload = function () {
			if (req.status >= 200 && req.status < 400) {
				alert('Solicitação enviada');
				window.location.reload();
			}
		}
		
	} else {
		alert('Preencha todos os campos!');
	}
	
}

