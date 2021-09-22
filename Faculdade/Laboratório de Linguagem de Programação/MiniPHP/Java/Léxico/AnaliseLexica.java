package Léxico;

import java.io.FileInputStream;
import java.io.PushbackInputStream;

public class AnaliseLexica {

	private int linha = 1;
	private PushbackInputStream input;
	private TabSimbolos ts;

	public AnaliseLexica(String file){
		ts = new TabSimbolos();
		try{
			input = new PushbackInputStream(new FileInputStream(file));
		}catch(Exception e){
			throw new Excecao("Não foi possível abrir o arquivo");
		}

	}

	public Lexema nextToken(){
		int estado = 1;
		Lexema lexema = new Lexema("", TokenType.END_OF_FILE);
		int c = getC();

		while(estado != 13 || estado != 14){
			switch(estado){
				case 1:	if(c == '\t' || c == '\r' || c == ' '){
					estado = 1;
				}else if(c == '\n'){
					linha++;
					estado = 1;
				}else if(c == '[' || c == ']' || c == '{' || c == '}' || c == '(' || c == '}' || c == ',' || c == ';' || c == '$'){
					lexema.token += (char) c;
					estado = 13;
				}else if(c == '*' || c == '.' ||c == '!' ||c == '%' ||c == '>' ||c == '<'){
					lexema.token += (char) c;
					estado = 2;
				}else if(c == '+'){
					lexema.token += (char) c;
					estado = 3;
				}else if(c == '-'){
					lexema.token += (char) c;
					estado = 4;
				}else if(c == '='){
					lexema.token += (char) c;
					estado = 5;
				}else if(c == '/'){
					estado = 6;
				}else if(Character.isDigit(c)){
					lexema.token += (char) c;
					estado = 7;
				}else if(Character.isLetter(c)){
					lexema.token += (char) c;
					estado = 8;
				}else if(c == '\"'){
					estado = 11;
				}else{
					if(c == -1){
						lexema.token += TokenType.END_OF_FILE;
						estado = 14;
					}else {
						lexema.token += TokenType.INVALID_TOKEN;
						estado = 14;
					}

				}
					break;
				case 2:	if(c == '='){
					lexema.token+= (char) c;
					estado = 13;
				}else{
					if(c == -1){
						lexema.tipo = TokenType.UNEXPECTED_EOF;
						estado = 14;
					}else {
						ungetC(c);
						estado = 13;
					}
				}
					break;
				case 3:	if(c == '=' || c == '+'){
					lexema.token+= (char) c;
					estado = 13;
				}else{
					if(c == -1){
						lexema.tipo = TokenType.UNEXPECTED_EOF;
						estado = 14;
					}else {
						ungetC(c);
						estado = 13;
					}
				}
					break;
				case 4:	if(c == '=' || c == '-'){
					lexema.token+= (char) c;
					estado = 13;
				}else{
					if(c == -1){
						lexema.tipo = TokenType.UNEXPECTED_EOF;
						estado = 14;
					}else {
						ungetC(c);
						estado = 13;
					}
				}
					break;
				case 5:	if(c == '=' || c == '>'){
					lexema.token+= (char) c;
					estado = 13;
				}else{
					if(c == -1){
						lexema.tipo = TokenType.UNEXPECTED_EOF;
						estado = 14;
					}else {
						ungetC(c);
						estado = 13;
					}
				}
					break;
				case 6:	if(c == '='){
					lexema.token+= (char) c;
					estado = 13;
				}else if(c == '*'){
					estado = 9;
				}else{
					if(c == -1){
						lexema.tipo = TokenType.UNEXPECTED_EOF;
						estado = 14;
					}else {
						ungetC(c);
						estado = 13;
					}
				}
					break;
				case 7:	if(Character.isLetter(c) || c == '_' || Character.isDigit(c)){
					lexema.token+= (char) c;
					estado = 7;
				}else{
					if(c == -1){
						lexema.tipo = TokenType.UNEXPECTED_EOF;
						estado = 14;
					}else {
						ungetC(c);
						estado = 13;
					}
				}
					break;
				case 8:	if(Character.isDigit(c)){
					lexema.token+= (char) c;
					estado = 8;
				}else{
					if(c == -1){
						lexema.tipo = TokenType.UNEXPECTED_EOF;
						estado = 14;
					}else {
						ungetC(c);
						estado = 13;
					}
				}
					break;
				case 9: if(c == '*'){
					estado = 10;
				}else{
					if(c == -1){
						lexema.tipo = TokenType.UNEXPECTED_EOF;
						estado = 14;
					}else {
						estado = 9;
					}
				}
					break;
				case 10:	if(c == '/'){
					estado = 1;
				}else{
					if(c == -1){
						lexema.tipo = TokenType.UNEXPECTED_EOF;
						estado = 14;
					}else {
						estado = 9;
					}
				}
					break;
				case 11:	if(c == '\\'){
					estado = 12;
				}else{
					if(c == -1){
						lexema.tipo = TokenType.UNEXPECTED_EOF;
						estado = 14;
					}else {
						estado = 11;
					}
				}
					break;
				case 12:	if(c == 'n'){
					lexema.token+= '\n';
					estado = 11;
				}else if(c == '\"'){
					lexema.tipo = TokenType.STRING;
					estado = 14;
				}else if(c == '\t'){
					lexema.token+= '\t';
					estado = 11;
				}else if(c == '\r'){
					lexema.token+= '\r';
					estado = 11;
				}
					break;
				default:
			}
		}

		if(estado == 13){
			lexema.tipo = ts.find(lexema.token);
		}

		return lexema;

	}

	public int getLine(){
		return this.linha;
	}

	public void close(){
		try{
			input.close();
		}catch(Exception e){
			throw new Excecao("Não foi possível fechar o arquivo");
		}
	}

	public int getC(){
		try{
			return input.read();
		}catch(Exception e){
			throw new Excecao("Não foi poissível ler o arquivo");
		}
	}

	public void ungetC(int c){
		if(c != -1){
			try{
				input.unread(c);
			}catch(Exception e){
				throw new Excecao("ungetc erro");
			}
		}

	}

}

