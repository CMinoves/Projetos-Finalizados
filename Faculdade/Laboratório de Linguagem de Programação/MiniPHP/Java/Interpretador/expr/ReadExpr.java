package Interpretador.expr;
import java.util.Scanner;

public class ReadExpr extends Expr{

	private static Scanner scanner;

	public ReadExpr(int linha){
		super(linha);
	}

	static{
		scanner = new Scanner(System.in);
	}

	public int expr(){
		try{
			String string = scanner.nextLine();
			int num = Integer.parseInt(string);
			return num;
		}catch(Exception e){
			return 0;
		}
	}

}
