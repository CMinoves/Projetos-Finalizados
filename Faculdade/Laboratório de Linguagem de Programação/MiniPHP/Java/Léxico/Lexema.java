package Léxico;

public class Lexema {

	public String token;
	public TokenType tipo;

	public Lexema(String token, TokenType tipo){
		this.tipo = tipo;
		this.token = token;
	}

}
