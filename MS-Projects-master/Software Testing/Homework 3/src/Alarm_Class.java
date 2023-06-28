import javax.swing.*;

public class Alarm_Class {
	private  boolean red_light_on=false;
	private  boolean green_light_on=false;
	private  boolean yellow_light_on=false;
	private  boolean chime_on=false;

	public void compute_alarms(double gas_tank_reading) {
		
			
			if (gas_tank_reading >= 0.0 && gas_tank_reading <= 50.0)
			{
				red_light_on=true;
				yellow_light_on=true;
				green_light_on=true;
				chime_on=false;
				JOptionPane.showMessageDialog(null,"Red_Light On: "+red_light_on+"\nYellow Light On: "+yellow_light_on+"\nGreen Light On: "+green_light_on+"\nChime On:"+chime_on);
				}
			else if(gas_tank_reading >= 50.1 && gas_tank_reading <= 99.9)
			{
				red_light_on=true;
				yellow_light_on=true;
				green_light_on=true;
				chime_on=true;
				JOptionPane.showMessageDialog(null,"Red_Light On: "+red_light_on+"\nYellow Light On: "+yellow_light_on+"\nGreen Light On: "+green_light_on+"\nChime On:"+chime_on);
			}
			else if(gas_tank_reading >= 100.0 && gas_tank_reading <= 199.9)
			{
				red_light_on=true;
				yellow_light_on=true;
				green_light_on=false;
				chime_on=true;
				JOptionPane.showMessageDialog(null,"Red_Light On: "+red_light_on+"\nYellow Light On: "+yellow_light_on+"\nGreen Light On: "+green_light_on+"\nChime On:"+chime_on);
			}
			else if(gas_tank_reading >= 200.0 && gas_tank_reading <= 299.9)
			{
				red_light_on=true;
				yellow_light_on=false;
				green_light_on=false;
				chime_on=true;
				JOptionPane.showMessageDialog(null,"Red_Light On: "+red_light_on+"\nYellow Light On: "+yellow_light_on+"\nGreen Light On: "+green_light_on+"\nChime On:"+chime_on);
			}
			else if(gas_tank_reading >= 300.0 && gas_tank_reading <=500.0)
			{
				red_light_on=false;
				yellow_light_on=false;
				green_light_on=false;
				chime_on=true;
				JOptionPane.showMessageDialog(null,"Red_Light On: "+red_light_on+"\nYellow Light On: "+yellow_light_on+"\nGreen Light On: "+green_light_on+"\nChime On:"+chime_on);
			}
			
	
	}

	public void setRed_light_on(boolean red_light_on){
		this.red_light_on=red_light_on;
		
	}
	
	public boolean isRed_light_on(){
		return red_light_on;
		
	}
	
	public void setGreen_light_on(boolean green_light_on){
		this.green_light_on=green_light_on;
		
	}
	
	public boolean isGreen_light_on(){
		return green_light_on;
		
	}
	public void setYellow_light_on(boolean yellow_light_on){
		this.yellow_light_on=yellow_light_on;
		
	}
	
	public boolean isYellow_light_on(){
		return yellow_light_on;
		
	}
	public void setChime_on(boolean chime_on){
		this.chime_on=chime_on;
		
	}
	
	public boolean isChime_on(){
		return chime_on;
		
	}
	
	
	
}



