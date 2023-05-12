package aula6.com.meupacote;

public class Usuario {
String nome;
String endereco;
String telefone;
String cpf;
String dataDeNascimento;

public Usuario() {

}

public Usuario(String nome) {
this.nome = nome;
}

public Usuario(String nome, String endereco, String telefone, String cpf, String dataDeNascimento) {
super();
this.nome = nome;
this.endereco = endereco;
this.telefone = telefone;
this.cpf = cpf;
this.dataDeNascimento = dataDeNascimento;
}

public String getNome() {
return nome;
}

public void setNome(String nome) {
this.nome = nome;
}

public String getEndereco() {
return endereco;
}

public void setEndereco(String endereco) {
this.endereco = endereco;
}

public String getTelefone() {
return telefone;
}

public void setTelefone(String telefone) {
this.telefone = telefone;
}

public String getCPF() {
return cpf;
}

public void setCPF(String cpf) {
this.cpf = cpf;
}

public String getDataDeNascimento() {
return dataDeNascimento;
}

public void setDataDeNascimento(String dataDeNascimento) {
this.dataDeNascimento = dataDeNascimento;
}

@Override
public String toString() {
return "Usuario [nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", cpf=" + cpf
+ ", dataDeNascimento=" + dataDeNascimento + "]";
}


}
