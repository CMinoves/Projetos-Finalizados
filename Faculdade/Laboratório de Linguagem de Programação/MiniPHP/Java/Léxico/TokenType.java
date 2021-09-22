package Léxico;

public enum TokenType {

	//SÍMBOLOS:
	PONTO_VIRGULA,
	VIRGULA,
	ABRE_PARENTESES,
	FECHA_PARENTESES,
	ABRE_CHAVES,
	FECHA_CHAVES,
	ABRE_COLCHETES,
	FECHA_COLCHETES,
	CIFRAO,
	APONTA,

	//OPERADORES LÓGICOS:
	IGUAL,
	DIFERENTE,
	MENOR,
	MENOR_IGUAL,
	MAIOR,
	MAIOR_IGUAL,
	NEGACAO,

	//OPERADORES ARITMÉTICOS:
	ADC,
	SUB,
	MUL,
	DIV,
	RES,
	CON,
	ATRIBUICAO,
	ATRIBUICAO_ADC,
	ATRIBUICAO_SUB,
	ATRIBUICAO_MUL,
	ATRIBUICAO_DIV,
	ATRIBUICAO_RES,
	ATRIBUICAO_CON,
	INCREMENTO,
	DECREMENTO,

	//PALAVRAS RESERVADAS:
	READ,
	IF,
	ELSE,
	ELSEIF,
	WHILE,
	FOREACH,
	ECHO,
	AND,
	OR,
	ARRAY,
	AS,

	//---------------------------

	//CASOS ESPECIAIS:
	UNEXPECTED_EOF,
	INVALID_TOKEN,
	END_OF_FILE,

	//OUTROS CASOS:
	VAR,
	NUMBER,
	STRING,

}


