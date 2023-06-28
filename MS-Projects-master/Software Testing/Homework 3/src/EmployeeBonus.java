
import javax.swing.*;


public class EmployeeBonus {

	public double bonus_to_be_paid;
	public boolean gift_card_earned;
	public double gift_card_amount;
	public boolean fee_charged;
	public double fee_amount;
	public static Sales_status  sales_stat;
	
	public static void main(String args[]){
	String SalesVolume;
	Double SalesVolumeNew;
	SalesVolume= JOptionPane.showInputDialog("Enter Sales Volume in currency format($):");
//	if (SalesVolume.contains("-"))
		SalesVolumeNew = Double.parseDouble(SalesVolume);
	
//	calculate_bonus(SalesVolumeNew);
	   
 //JOptionPane.showMessageDialog(null, "Amount Paid: ");
	
	}
 
  public void calculate_bonus(double sales_volume) {
		
			if(sales_volume < 0 )
			{
				bonus_to_be_paid = -500.00;
				fee_charged=true;
				fee_amount=500.00;
				gift_card_earned = false;
					
				gift_card_amount = 0.00;
				sales_stat= Sales_status.NO_SALES;
				
				JOptionPane.showMessageDialog(null, "Bonus to be  Paid: $" +bonus_to_be_paid+"\nSales_Status: "+sales_stat+"\nFee Charged: "+fee_charged +"\nFee Amount: $"+fee_amount+"\nGift Card Earned: "+gift_card_earned+"\nGift Card Ampount: $"+gift_card_amount);
				
				//return sales_volume;
				
				
			}
			else if(sales_volume >= 0.00 && sales_volume <=24999.99 )
			{
		    bonus_to_be_paid = (2.00*sales_volume)/100;
			
			gift_card_earned = false;
			gift_card_amount = 0.00;
			sales_stat= Sales_status.ORDINARY_SALES;
			fee_charged=false;
			fee_amount=0.00;
			System.out.println("Bonus to be  Paid: $" + bonus_to_be_paid + "\nSales_Status: " + sales_stat + "\nFee Charged: " + fee_charged + "\nFee Amount: $" + fee_amount + "\nGift Card Earned: " + gift_card_earned + "\nGift Card Ampount: $" + gift_card_amount);
			JOptionPane.showMessageDialog(null, "Bonus to be  Paid: $" +bonus_to_be_paid+"\nSales_Status: "+sales_stat+"\nFee Charged: "+fee_charged +"\nFee Amount: $"+fee_amount+"\nGift Card Earned: "+gift_card_earned+"\nGift Card Ampount: $"+gift_card_amount);
			
		    }
             else if(sales_volume >= 25000.00 && sales_volume <=99999.99)
             {
            	  bonus_to_be_paid = (2.75*sales_volume)/100;
      			
      			gift_card_earned = false;
      			gift_card_amount = 0.00;
      			sales_stat= Sales_status.ORDINARY_SALES;
      			fee_charged=false;
      			fee_amount=0.00;
      			JOptionPane.showMessageDialog(null, "Bonus to be  Paid: $" +bonus_to_be_paid+"\nSales_Status: "+sales_stat+"\nFee Charged: "+fee_charged +"\nFee Amount: $"+fee_amount+"\nGift Card Earned: "+gift_card_earned+"\nGift Card Ampount: $"+gift_card_amount);
      		  }
             else if(sales_volume >= 100000.00 && sales_volume <=200000.00)
             {
            	  bonus_to_be_paid = (3.50*sales_volume)/100;
      			
      			gift_card_earned = false;
      			gift_card_amount = 0.00;
      			sales_stat= Sales_status.ORDINARY_SALES;
      			fee_charged=false;
      			fee_amount=0.00;
      			JOptionPane.showMessageDialog(null, "Bonus to be  Paid: $" +bonus_to_be_paid+"\nSales_Status: "+sales_stat+"\nFee Charged: "+fee_charged +"\nFee Amount: $"+fee_amount+"\nGift Card Earned: "+gift_card_earned+"\nGift Card Ampount: $"+gift_card_amount);
      		  }
             else if(sales_volume >= 200000.01 && sales_volume <=400000.00)
             {
            	  bonus_to_be_paid = (3.75*sales_volume)/100;
      			
      			gift_card_earned = false;
      			gift_card_amount = 0.00;
      			sales_stat= Sales_status.ORDINARY_SALES;
      			fee_charged=false;
      			fee_amount=0.00;
      			JOptionPane.showMessageDialog(null, "Bonus to be  Paid: $" +bonus_to_be_paid+"\nSales_Status: "+sales_stat+"\nFee Charged: "+fee_charged +"\nFee Amount: $"+fee_amount+"\nGift Card Earned: "+gift_card_earned+"\nGift Card Ampount: $"+gift_card_amount);
      		  }             
             else if(sales_volume >= 400000.01)
             {
            	  bonus_to_be_paid = (4.00*sales_volume)/100;
      			
      			gift_card_earned = true;
      			gift_card_amount = 250.00;
      			sales_stat= Sales_status.TOP_SELLER;
      			fee_charged=false;
      			fee_amount=0.00;
      			JOptionPane.showMessageDialog(null, "Bonus to be  Paid: $" +bonus_to_be_paid+"\nSales_Status: "+sales_stat+"\nFee Charged: "+fee_charged +"\nFee Amount: $"+fee_amount+"\nGift Card Earned: "+gift_card_earned+"\nGift Card Ampount: $"+gift_card_amount);
      		  }	
			
			
			
}
  


	
	public boolean isGift_card_earned(){
		return gift_card_earned;
		
	}
	public double getBonus_to_be_paid(){
		return bonus_to_be_paid;
	}
	
	public Sales_status getSales_stat(){
		return sales_stat;
		
	}
	
	
	
  
}


