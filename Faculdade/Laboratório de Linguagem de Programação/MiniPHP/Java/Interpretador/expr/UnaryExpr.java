package Interpretador.expr;

public class UnaryExpr extends Expr{

	private Expr termo;
	private UnaryOp op;

	public UnaryExpr(int linha, Expr termo, UnaryOp op{
		super(linha);
		this.termo = termo;
		this.op = op;
	}

	public int expr(){
		int num = termo.expr();
		switch(op){
			case PRE_ADC: return ++num;
			case PRE_SUB: return --num;
			case POS_ADC: return num++;
			case POS_SUB:
			default: return num--;
		}
	}


}
