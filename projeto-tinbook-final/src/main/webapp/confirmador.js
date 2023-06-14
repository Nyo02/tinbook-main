function confirmar(id){
	let resposta =  confirm("confirma a exclusao deste livro");
	
	if(resposta ===true){
		window.location.href = "delete?id=" + id;
	}
}