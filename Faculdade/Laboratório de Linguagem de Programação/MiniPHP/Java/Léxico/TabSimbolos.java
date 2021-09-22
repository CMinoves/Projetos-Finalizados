package Léxico;

import java.util.HashMap;
import java.util.Map;

public class TabSimbolos {

	public Map<String, TokenType> ts;

	public TabSimbolos(){

		ts = new HashMap<String, TokenType>();

		ts.put("{", TokenType.ABRE_CHAVES);			//SÍMBOLO
		ts.put("[", TokenType.ABRE_COLCHETES);		//SÍMBOLO
		ts.put("(", TokenType.ABRE_PARENTESES);		//SÍMBOLO
		ts.put("+", TokenType.ADC);					//OPERADOR ARITMÉTICO
		ts.put("and", TokenType.AND);				//OPERADOR ARITMÉTICO
		ts.put("=>", TokenType.APONTA);				//SÍMBOLO
		ts.put("array", TokenType.ARRAY);			//PALAVRA RESERVADA
		ts.put("as", TokenType.AS);					//PALAVRA RESERVADA
		ts.put("=", TokenType.ATRIBUICAO);			//OPERADOR ARITMÉTICO
		ts.put("+=", TokenType.ATRIBUICAO_ADC);		//OPERADOR ARITMÉTICO
		ts.put(".=", TokenType.ATRIBUICAO_CON);		//OPERADOR ARITMÉTICO
		ts.put("/=", TokenType.ATRIBUICAO_DIV);		//OPERADOR ARITMÉTICO
		ts.put("*=", TokenType.ATRIBUICAO_MUL);		//OPERADOR ARITMÉTICO
		ts.put("%=", TokenType.ATRIBUICAO_RES);		//OPERADOR ARITMÉTICO
		ts.put("-=", TokenType.ATRIBUICAO_SUB);		//OPERADOR ARITMÉTICO
		ts.put(".", TokenType.CON);					//OPERADOR ARITMÉTICO
		ts.put("--", TokenType.DECREMENTO);			//OPERADOR ARITMÉTICO
		ts.put("!=", TokenType.DIFERENTE);			//OPERADOR LÓGICO
		ts.put("/", TokenType.DIV);					//OPERADOR ARITMÉTICO
		ts.put("echo", TokenType.ECHO);				//PALAVRA RESERVADA
		ts.put("else", TokenType.ELSE);				//PALAVRA RESERVADA
		ts.put("elseif", TokenType.ELSEIF);			//PALAVRA RESERVADA
		ts.put("}", TokenType.FECHA_CHAVES);		//SÍMBOLO
		ts.put("]", TokenType.FECHA_COLCHETES);		//SÍMBOLO
		ts.put(")", TokenType.FECHA_PARENTESES);	//SÍMBOLO
		ts.put("foreach", TokenType.FOREACH);		//PALAVRA RESERVADA
		ts.put("if", TokenType.IF);					//PALAVRA RESERVADA
		ts.put("==", TokenType.IGUAL);				//OPERADOR LÓGICO
		ts.put("++", TokenType.INCREMENTO);			//OPERADOR ARITMÉTICO
		ts.put(">", TokenType.MAIOR);				//OPERADOR LÓGICO
		ts.put(">=", TokenType.MAIOR_IGUAL);		//OPERADOR LÓGICO
		ts.put("<", TokenType.MENOR);				//OPERADOR LÓGICO
		ts.put("<=", TokenType.MENOR_IGUAL);		//OPERADOR LÓGICO
		ts.put("*", TokenType.MUL);					//OPERADOR ARITMÉTICO
		ts.put("!", TokenType.NEGACAO);				//OPERADOR LÓGICO
		ts.put("or", TokenType.OR);					//PALAVRA RESERVADA
		ts.put(";", TokenType.PONTO_VIRGULA);		//SÍMBOLO
		ts.put("read", TokenType.READ);				//PALAVRA RESERVADA
		ts.put("%", TokenType.RES);					//OPERADOR ARITMÉTICO
		ts.put("$", TokenType.CIFRAO);				//SÍMBOLO
		ts.put("-", TokenType.SUB);					//OPERADOR ARITMÉTICO
		ts.put(",", TokenType.VIRGULA);				//SÍMBOLO
		ts.put("while", TokenType.WHILE);			//PALAVRA RESERVADA

	}

	public boolean contains(String token) {
		return ts.containsKey(token);
	}

	public TokenType find(String token) {
		return this.contains(token) ?
					ts.get(token) : TokenType.VAR;
	}

}
