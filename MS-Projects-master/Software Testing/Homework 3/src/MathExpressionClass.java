package Problem3;

public class MathExpressionClass {
	private double y;

	
	public  double calcY (double x) {
			if (x<-2.0)
				this.y=0.0;
			else 
				if (x<0.0)
					this.y=4*x+8.0;
				else
					if (x<4.0)
						this.y=-x*x+2*x+8.0;
					else
						if (x<6.0)
							this.y=-4.0*x+16;
						else
							this.y=-8.0;
	return this.y;
	}
}
	

