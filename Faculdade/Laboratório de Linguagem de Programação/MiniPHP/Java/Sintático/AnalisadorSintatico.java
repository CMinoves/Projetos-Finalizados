package Sintático;

import Interpretador.expr.ConstExpr;
import Interpretador.value.IntegerValue;
import Interpretador.value.StringValue;
import Léxico.AnaliseLexica;
import Léxico.Lexema;
import Léxico.TokenType;


public class AnalisadorSintatico {

	private final AnaliseLexica lex;
	private Lexema Atual;
	private int parseInt;

	public AnalisadorSintatico(final AnaliseLexica lex){ //construtor do analisador sintático
		this.lex = lex;
		this.Atual = lex.nextToken();

	}

	private void proximo(){ //ir para o próximo token
		this.Atual = lex.nextToken();
	}

	private void come(final TokenType tipo){//compara para saber se o proximo tipo é esperado, se não, lança erro
		if(tipo == Atual.tipo){
			proximo();
		}else{
			MostreErro();
		}
	}
	private void MostreErro(){ //mostrando erro
		System.out.println(lex.getLine());

		switch(Atual.tipo){
			case INVALID_TOKEN:
				System.out.println("Lexema inválido: "+ Atual.tipo);
			break;
			case UNEXPECTED_EOF:
			case END_OF_FILE:
				System.out.println("Fim de arquivo inesperado");
			break;
			default:
				System.out.println("Lexema não experado: "+ Atual.token);
			break;
		}
		System.exit(1);

	}
	private void inicio(){
		procCode();
		come(TokenType.END_OF_FILE);
	}
	//comecando os procedimentos para cada termo

	//<code> ::= { <statement> }
	private void procCode(){
		while(Atual.tipo == TokenType.IF || Atual.tipo == TokenType.WHILE  ||
		Atual.tipo == TokenType.FOREACH || Atual.tipo == TokenType.ECHO ||
		Atual.tipo == TokenType.INCREMENTO || Atual.tipo == TokenType.DECREMENTO ||
		Atual.tipo == TokenType.CIFRAO || Atual.tipo == TokenType.VAR ||
		Atual.tipo == TokenType.ABRE_PARENTESES){
			procStatement();
		}
	}

	//<statement> ::= <if> | <while> | <foreach> | <echo> | <assign>
	private void procStatement(){
		if(Atual.tipo == TokenType.IF){
			procIf();
		}else{
			if(Atual.tipo == TokenType.WHILE){
				procWhile();
			}else{
				if(Atual.tipo == TokenType.FOREACH){
					procForeach();
				}else{
					if(Atual.tipo == TokenType.ECHO){
						procEcho();
					}else{
						if(Atual.tipo == TokenType.INCREMENTO || Atual.tipo == TokenType.DECREMENTO ||
						Atual.tipo == TokenType.CIFRAO  || Atual.tipo == TokenType.VAR ||
						Atual.tipo == TokenType.ABRE_PARENTESES){
						procAssign();
						}else{
							MostreErro();
						}
					}
				}
			}
		}
	}


	//<if> ::= if '(' <boolexpr> ')' '{' <code> '}'
 			//{ elseif '(' <boolexpr> ')' '{' <code> '}' } [ else '{' <code> '}' ]
	private void procIf(){
		come(TokenType.IF);
		come(TokenType.ABRE_PARENTESES);
		procBoolexpr();
		come(TokenType.FECHA_PARENTESES);
		come(TokenType.ABRE_CHAVES);
		procCode();
		come(TokenType.FECHA_CHAVES);
		while(Atual.tipo == TokenType.ELSEIF){
				proximo();
				come(TokenType.ABRE_PARENTESES);
				procBoolexpr();
				come(TokenType.FECHA_PARENTESES);
				come(TokenType.ABRE_CHAVES);
				procCode();
				come(TokenType.FECHA_CHAVES);
			}
		if(Atual.tipo == TokenType.ELSE){
			proximo();
			come(TokenType.ABRE_CHAVES);
			procCode();
			come(TokenType.FECHA_CHAVES);
		}
}

	//<while> ::= while '(' <boolexpr> ')' '{' <code> '}'
	private void procWhile(){
		come(TokenType.WHILE);
		come(TokenType.ABRE_PARENTESES);
		procBoolexpr();
		come(TokenType.FECHA_PARENTESES);
		come(TokenType.ABRE_CHAVES);
		procCode();
		come(TokenType.FECHA_CHAVES);
	}

	//<foreach> ::= foreach '(' <expr> as <var> [ '=>' <var> ] ')' '{' <code> '}'
	private void procForeach(){
		come(TokenType.FOREACH);
		come(TokenType.ABRE_PARENTESES);
		procExpr();
		come(TokenType.AS);
		come(TokenType.VAR);
		if(Atual.tipo == TokenType.APONTA){
			proximo();
			come(TokenType.VAR);
		}
		come(TokenType.FECHA_PARENTESES);
		come(TokenType.ABRE_CHAVES);
		procCode();
		come(TokenType.FECHA_CHAVES);

	}

	//<echo> ::= echo <expr> ';'
	private void procEcho(){
		come(TokenType.ECHO);
		procExpr();
		come(TokenType.PONTO_VIRGULA);
	}

	//<assign> ::= <value> [ ('=' | '+=' | '-=' | '.=' | '*=' | '/=' | '%=') <expr> ] ';'
	private void procAssign(){
		procValue();
		switch (Atual.tipo){
			case ATRIBUICAO:
			come(TokenType.ATRIBUICAO);
			procExpr();
			break;

			case ATRIBUICAO_ADC:
			come(TokenType.ATRIBUICAO_ADC);
			procExpr();
			break;

			case ATRIBUICAO_SUB:
			come(TokenType.ATRIBUICAO_SUB);
			procExpr();
			break;

			case ATRIBUICAO_CON:
			come(TokenType.ATRIBUICAO_CON);
			procExpr();
			break;

			case ATRIBUICAO_MUL:
			come(TokenType.ATRIBUICAO_MUL);
			procExpr();
			break;

			case ATRIBUICAO_DIV:
			come(TokenType.ATRIBUICAO_DIV);
			procExpr();
			break;

			case ATRIBUICAO_RES:
			come(TokenType.ATRIBUICAO_RES);
			procExpr();
			break;
		}
		come(TokenType.PONTO_VIRGULA);
	}

	//<boolexpr> ::= [ '!' ] <cmpexpr> [ (and | or) <boolexpr> ]
	private void procBoolexpr(){
		if(Atual.tipo == TokenType.NEGACAO)
			proximo();
		procCmpexpr();
		if(Atual.tipo == TokenType.AND || Atual.tipo == TokenType.OR){
			proximo();
			procBoolexpr();
		}
	}

	//<cmpexpr> ::= <expr> ('==' | '!=' | '<' | '>' | '<=' | '>=') <expr>
	private void procCmpexpr(){
		procExpr();
		switch(Atual.tipo){
			case IGUAL:
			 come(TokenType.IGUAL);
			break;

			case DIFERENTE:
			 come(TokenType.DIFERENTE);
			break;

			case MENOR:
			 come(TokenType.MENOR);
			break;

			case MAIOR:
			 come(TokenType.MAIOR);
			break;

			case MENOR_IGUAL:
			 come(TokenType.MENOR_IGUAL);
			break;

			case MAIOR_IGUAL:
			 come(TokenType.MAIOR_IGUAL);
			break;
		}
		procExpr();
	}

	//<expr> ::= <term> { ('+' | '-' | '.') <term> }
	private void procExpr(){
		procTerm();
		 while(Atual.tipo == TokenType.ADC || Atual.tipo == TokenType.SUB || Atual.tipo == TokenType.CON){
			proximo();
			procTerm();
		 }
	}

	//<term> ::= <factor> { ('*' | '/' | '%') <factor> }
	private void procTerm(){
		procFactor();
		while(Atual.tipo == TokenType.MUL || Atual.tipo == TokenType.DIV || Atual.tipo == TokenType.RES){
			proximo();
			procFactor();
		}
	}

	//<factor> ::= <number> | <string> | <array> | <read> | <value>
	private Expr procFactor(){
		switch(Atual.tipo){
			case NUMBER:
				IntegerValue v = new IntegerValue(Integer.parseInt(Atual.token));
				ConstExpr num = new ConstExpr(lex.getLine(), v);
				come(TokenType.NUMBER);
				return num;
			break;

			case STRING:
				StringValue s = new StringValue(Atual.token);
				ConstExpr st = new ConstExpr(lex.getLine(), s);
				come(TokenType.STRING);
				return st;
			break;

			case ARRAY:
				procArray();
			break;

			case READ:
				procRead();
			break;

			default:
				procValue();
			break;
		}

	}

	//<array> ::= array '(' [ <expr> '=>' <expr> { ',' <expr> '=>' <expr> } ] ')'
	private void procArray(){
		come(TokenType.ARRAY);
		come(TokenType.ABRE_PARENTESES);
		if(Atual.tipo == TokenType.NUMBER || Atual.tipo == TokenType.STRING ||
		Atual.tipo == TokenType.ARRAY || Atual.tipo == TokenType.READ ||
		Atual.tipo == TokenType.INCREMENTO || Atual.tipo == TokenType.DECREMENTO ||
		Atual.tipo == TokenType.VAR || Atual.tipo == TokenType.CIFRAO ||
		Atual.tipo == TokenType.ABRE_PARENTESES){
			procExpr();
			come(TokenType.APONTA);
			procExpr();
			while(Atual.tipo == TokenType.VIRGULA){
				proximo();
				procExpr();
				come(TokenType.APONTA);
				procExpr();
			}
		}
		come(TokenType.FECHA_PARENTESES);
	}

	//<read> ::= read <expr>
	private void procRead(){
		come(TokenType.READ);
		procExpr();
	}

	//<value> ::= [ ('++' | '—-') ] <access> | <access> [ ('++' | '--') ]
	private void procValue(){
		if(Atual.tipo == TokenType.INCREMENTO || Atual.tipo == TokenType.DECREMENTO){
			proximo();
		}
		if(Atual.tipo == TokenType.VAR || Atual.tipo == TokenType.CIFRAO || Atual.tipo ==TokenType.ABRE_PARENTESES){
			procAcess();
			if(Atual.tipo == TokenType.INCREMENTO || Atual.tipo == TokenType.DECREMENTO){
				proximo();
			}
		}
	}

	//<access> ::= ( <varvar> | '(' <expr> ')' ) [ '[' <expr> ']' ]
	private void procAcess(){
		if( Atual.tipo == TokenType.CIFRAO || Atual.tipo == TokenType.VAR){
			procVarvar();
		}else{
			if(Atual.tipo == TokenType.ABRE_PARENTESES){
				proximo();
				procExpr();
				come(TokenType.FECHA_PARENTESES);
			}
		}
		if(Atual.tipo == TokenType.ABRE_COLCHETES){
			proximo();
			procExpr();
			come(TokenType.FECHA_COLCHETES);
		}
	}

	//<varvar> ::= '$' <varvar> | <var>
	private void procVarvar(){
		if(Atual.tipo == TokenType.CIFRAO){
			proximo();
			procVarvar();
		}else{
			if(Atual.tipo == TokenType.VAR){
				proximo();
			}
		}
	}
}
