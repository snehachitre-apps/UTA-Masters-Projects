import javax.swing.JOptionPane;

public class Alarm_Main {
	
	 

	public static void main(String args[]){
		
		Alarm_Class alarm = new Alarm_Class();
		String gas_tank_reading;
		gas_tank_reading= JOptionPane.showInputDialog("Enter gas tank reading :");
		double gas_tank_readingNew = Double.parseDouble(gas_tank_reading);
		double gas_tank_capacity = 500.0;
		if((gas_tank_readingNew > gas_tank_capacity) || (gas_tank_readingNew < 0.0)) {
			JOptionPane.showMessageDialog(null, "Gas reading should be between 0.0 to 500.0");
		} else {
		    alarm.compute_alarms(gas_tank_readingNew);
		}
			
		
		
		
	}

}
