import java.util.GregorianCalendar;

public class Perfil {
	//atributos
	private char sexo;
	private GregorianCalendar dataNascimento;
	private String cidade;
	private String estado;
	private String telefone;
	private String descricao;
	private String foto;
	
	//Método construtor
	public Perfil(char sexo, GregorianCalendar dataNascimento, String cidade, String estado, String telefone, String descricao, String foto) {
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.descricao = descricao;
		this.foto = foto;
	}
	
	//Demais métodos
	///sexo
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	///dataNascimento
	public String getDataNascimento() {
		return (String)(dataNascimento.get(GregorianCalendar.DAY_OF_MONTH) + "/" + dataNascimento.get(GregorianCalendar.MONTH) + "/" + dataNascimento.get(GregorianCalendar.YEAR));
	}
	
	public void setDataNascimento(GregorianCalendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setDataNascimento(int dia, int mes, int ano) {
		dataNascimento.set(GregorianCalendar.DATE, dia);
		dataNascimento.set(GregorianCalendar.MONTH, mes);
		dataNascimento.set(GregorianCalendar.YEAR, ano);
	}
		
	///cidade
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	///estado
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	///telefone
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	///descricao
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	///foto
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto= foto;
	}
	
	//toString
	@Override
	public String toString() {
		String out = "Sexo: " + getSexo() + "\n";
		out = out + "Data de Nascimento: " + getDataNascimento() + "\n";
		out = out + "Cidade: " + getCidade() + "\n";
		out = out + "Estado: " + getEstado() + "\n";
		out = out + "Telefone: " + getTelefone() + "\n";
		out = out + "Descrição: " + getDescricao() + "\n";
		out = out + "Foto: " + getFoto();
		return out;
	}
}
