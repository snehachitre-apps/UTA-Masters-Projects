package Problem3;

public class MathsExpression_Main {

	public static void main(String[] args) {
		MathExpressionClass me=new MathExpressionClass();
		
			double x = 0;
			for (x=-4;x<=8;x+=0.01){
				double d;
				d=me.calcY(x);
				System.out.println("x="+x+"\t"+"y="+d);
			
		
	}

}
}

