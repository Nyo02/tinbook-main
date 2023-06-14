function validar(){
	let titulo = frmLivro.titulo.value
	let genero = frmLivro.genero.value
	let autor = frmLivro.autor.value
	let status = frmLivro.status.value
	let data = frmLivro.data.value


	
	if (titulo === ""){
		alert("Prencha o campo titulo")
		return false
	}
	
	else if (genero === ""){
		alert("Prencha o campo genero")
		return false
	}
	else if (autor === ""){
		alert("Prencha o campo autor")
		return false
	}
	else if (status === ""){
		alert("Prencha o campo status")
		return false
	}
	else if (data === ""){
		alert("Prencha o campo data")
		return false
	}
	else {
		document.forms["frmLivro"].submit();}
	
	

}