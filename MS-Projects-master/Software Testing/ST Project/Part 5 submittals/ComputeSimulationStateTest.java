package ADV;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComputeSimulationStateTest {
	public static final String R = "R";
	public static final String D = "D";
	public static final String MP1 = "MP1";
	public static final String MP2 = "MP2";
	public static final String OFF = "Off";
	public static final int TEST_CASE_COUNT = 26;
	public static final boolean T = true;
	public static final boolean F = false;
	
	
	public double[] in_alt = {253.1, 253.2, 253.2, 1.5, 15.4, 15.4, 25.2, 51.3, 25.2, 253.2, 0.0, 
			0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 15.6, 25.2,  0.0, 0.0, 0.0, 0.0, 0.0};
	
	public double[] in_vd = {-6.787, -6.787, -6.787, -1.764, -1.096, -1.096, -1.763, -6.763, -1.763, 
			-6.787, -0.005, -0.005, -0.005, -0.005, -0.005, -0.005, -0.005, -0.005, -0.005, -1.097, -1.764,
			-0.005, -0.005, -0.005, -0.005, -0.005};
	
	public double[] in_vf = {101.805, 101.805, 101.805, 26.460, 16.440, 16.440, 26.445, 101.445, 26.445, 
			101.805, 0.075, 0.075, 0.075, 0.075, 0.075, 0.075, 0.075, 0.075, 0.075, 16.455, 26.455, 
			0.075, 0.075, 0.075, 0.075, 0.075};
	
	public double[] in_random = {0.59, 0.59, 0.59, 0.59, 0.59, 0.59, 0.59, 0.59, 0.59, 0.59, 0.3, 0.3, 
			0.3, 0.3, 0.59, 0.59, 0.59, 0.61, 0.61, 0.59, 0.59, 0.59, 0.59, 0.61, 0.59, 0.61};
	
	public int[] in_power_rem = {182, 182, 182, 180, 166, 166, 173, 181, 173, 182, 155, 155, 155, 155, 
			155, 155, 155, 155, 155, 155, 166, 173, 155, 155, 155, 155};
	
	public int[] in_shld_damage_cnt = {8, 8, 8, 8, 8, 8, 8, 7, 7, 11, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 0, 11, 5, 11, 11};
	public int[] in_esr_persistance_cnt = {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, 0, 0, 0, 0, 0, 0};
	public int[] in_cum_att = {5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, -6, 4, -4, 5, 6, 5, 5, 6, 5, 5, 5, 6, 6, 4, -4};
	public int[] in_ter_att = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -2};
	
	public boolean[] in_esr_latch = {F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F};
	
	public String[] in_shld_pos = {R, R, R, D, D, D, D, R, D, R, R, R, R, R, R, R, R, R, R, D, D, R, R, D, R, R};
	public String[] in_shld_cmd = {R, R, R, D, D, R, D, R, D, R, R, R, R, R, R, R, R, R, R, D, D, D, R, D, R, R}; 
	
	public boolean[] out_power60 = {F, F, F, T, T, T, T, T, T, F, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T, T};
	public boolean[] out_pos =     {T, T, T, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F};
	public boolean[] out_pdmg =    {F, F, F, F, F, F, F, F, F, T, F, F, F, F, F, F, F, F, F, F, F, F, T, F, T, T};
	public boolean[] out_pnd =     {F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, T, F, F, T, T, T, F, T};
	public boolean[] out_dc =      {F, F, F, F, F, F, F, F, F, F, T, F, F, F, F, T, F, F, T, F, F, F, T, T, F, F};
	public boolean[] out_esr =     {F, F, F, F, T, T, F, F, F, F, F, F, F, F, F, F, F, F, F, F, F, T, F, T, F, F};
	public boolean[] out_isrz =    {F, F, F, F, F, F, T, T, T, T, T, T, T, F, F, F, F, F, F, F, F, F, F, F, F, F};
	public boolean[] out_pd =      {F, F, F, F, F, F, F, F, F, F, F, T, T, T, T, F, T, T, F, F, F, F, F, F, T, F};
	
	public double[] out_alt =          {249.9, 250.0, 250.0, 0.1, 14.0, 14.0, 23.8, 48.0, 23.8, 250.0, 0.0, 0.0, 0.0, 
			                            0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 14.2, 23.8, 0.0, 0.0, 0.0, 0.0, 0.0};
	
	public double[] out_vf =           {100.005, 100.005, 100.005, 25.005, 14.985, 14.985, 24.990, 99.645, 24.990, 
			                           100.005, 0.075, 0.075, 0.075, 0.075, 0.075, 0.075, 0.075, 0.075, 0.075, 15.000, 25.005,
			                           0.075, 0.075, 0.075, 0.075, 0.075};
	
	public double[] out_vd =           {-6.667, -6.667, -6.667, -1.667, -0.999, -0.999, -1.666, -6.643, -1.666, -6.667, -0.005, 
			                           -0.005, -0.005, -0.005, -0.005, -0.005, -0.005, -0.005, -0.005, -1.000, -1.667, 
			                           -0.005, -0.005, -0.005, -0.005, -0.005};
	
	public String[] out_motor_state =  {MP1, MP1, MP1, MP2, MP2, MP2, MP2, MP1, MP2, MP1, OFF, OFF, OFF, 
			                           OFF, OFF, OFF, OFF, OFF, OFF, MP2, MP2, OFF, OFF, OFF, OFF, OFF};
	
	public int[] out_power_rem =       {180, 180, 180, 179, 165, 165, 172, 179, 172, 180, 155, 155, 155, 155, 155, 155, 155, 155, 
			                           155, 154, 165, 173, 155, 155, 155, 155};
	
	public String[] out_shld_pos =     {R, R, R, D, D, R, D, R, D, R, R, R, R, R, R, R, R, R, R, D, D, D, R, D, R, R};
	public String[] out_shld_cmd =     {R, R, R, D, R, R, D, R, D, R, R, R, R, R, R, R, R, R, R, R, D, R, R, R, R, R};
	

	
	@Test
	public void test() {
		Alerts alerts = new Alerts();
		Measurements measurements = new Measurements();
		ComputeSimulationState state = new ComputeSimulationState();
		
		//Total of 26 test cases has been identified to achieve full coverage 
		//of ComputeSimulationState.compute_state() method. 
		for (int tc_no = 0; tc_no < TEST_CASE_COUNT; tc_no++) {
			System.out.println("TestCase :" + tc_no);
			System.out.println("O/Ps :- ");
			clearAlerts(alerts);
			measurements.setAltitude(in_alt[tc_no]);
			measurements.setshield_position(in_shld_pos[tc_no]);
			measurements.setshield_cmd(in_shld_cmd[tc_no]);
			measurements.setVf(in_vf[tc_no]);
			measurements.setVd(in_vd[tc_no]);
			measurements.setpower_remaining(in_power_rem[tc_no]);
			alerts.setRand_value(in_random[tc_no]);
			alerts.setShield_damage_count(in_shld_damage_cnt[tc_no]);
			alerts.setESR_latch(in_esr_latch[tc_no]);
			alerts.setEsr_persistence_count(in_esr_persistance_cnt[tc_no]);
			measurements.setCum_attitude(in_cum_att[tc_no]);
			measurements.setTerr_attitude(in_ter_att[tc_no]);
			state.compute_state(measurements, alerts, 1);
			assertEquals(out_power60[tc_no],alerts.isPWR60());
			assertEquals(out_pos[tc_no],alerts.isPOS());
		    assertEquals(out_pdmg[tc_no],alerts.isPDMG());
			assertEquals(out_pnd[tc_no],alerts.isPND());
			assertEquals(out_dc[tc_no],alerts.isDC());
			assertEquals(out_esr[tc_no],alerts.isESR());
			assertEquals(out_isrz[tc_no],alerts.isISRZ());
			assertEquals(out_pd[tc_no],alerts.isPD());
			assertEquals(out_alt[tc_no],measurements.getAltitude(),0.1);
			assertEquals(out_vf[tc_no],measurements.getVf(),0.001);
			assertEquals(out_vd[tc_no],measurements.getVd(),0.001);
			assertEquals(out_motor_state[tc_no],measurements.getMotor_state());
			assertEquals(out_power_rem[tc_no],measurements.getpower_remaining(),1);
			assertEquals(out_shld_pos[tc_no],measurements.getshield_position());
			assertEquals(out_shld_cmd[tc_no],measurements.getshield_cmd());
			
		}
		
		//Default test case to achieve full coverage for  (t != 0) condition.
		 measurements.setAltitude(1.0);
		 state.compute_state(measurements, alerts, 0);
		 
		

	}

	private void clearAlerts (Alerts alerts) {
    	alerts.setESR(false);
    	alerts.setPWR60(false);
    	alerts.setISRZ(false);
    	alerts.setDC(false);
    	alerts.setPD(false);
    	alerts.setPOS(false);
    	alerts.setPND(false);
    	alerts.setPDMG(false);
	}
}
