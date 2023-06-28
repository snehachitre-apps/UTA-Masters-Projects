import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Alarm_MainTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		Alarm_Class tc01=new Alarm_Class();
		tc01.compute_alarms(0.0);
		assertEquals(true,tc01.isRed_light_on());
		assertEquals(true,tc01.isYellow_light_on());
		assertEquals(true,tc01.isGreen_light_on());
		assertEquals(false,tc01.isChime_on());
		
		
		Alarm_Class tc02=new Alarm_Class();
		tc02.compute_alarms(50.0);
		assertEquals(true,tc02.isRed_light_on());
		assertEquals(true,tc02.isYellow_light_on());
		assertEquals(true,tc02.isGreen_light_on());
		assertEquals(false,tc02.isChime_on());
		
		Alarm_Class tc03=new Alarm_Class();
		tc03.compute_alarms(50.1);
		assertEquals(true,tc03.isRed_light_on());
		assertEquals(true,tc03.isYellow_light_on());
		assertEquals(true,tc03.isGreen_light_on());
		assertEquals(true,tc03.isChime_on());
		
		
		Alarm_Class tc04=new Alarm_Class();
		tc04.compute_alarms(99.9);
		assertEquals(true,tc04.isRed_light_on());
		assertEquals(true,tc04.isYellow_light_on());
		assertEquals(true,tc04.isGreen_light_on());
		assertEquals(true,tc04.isChime_on());
		
		
		Alarm_Class tc05=new Alarm_Class();
		tc05.compute_alarms(100.0);
		assertEquals(true,tc05.isRed_light_on());
		assertEquals(true,tc05.isYellow_light_on());
		assertEquals(false,tc05.isGreen_light_on());
		assertEquals(true,tc05.isChime_on());
		
		
		Alarm_Class tc06=new Alarm_Class();
		tc06.compute_alarms(199.9);
		assertEquals(true,tc06.isRed_light_on());
		assertEquals(true,tc06.isYellow_light_on());
		assertEquals(false,tc06.isGreen_light_on());
		assertEquals(true,tc06.isChime_on());
		
		
		Alarm_Class tc07=new Alarm_Class();
		tc07.compute_alarms(200.0);
		assertEquals(true,tc07.isRed_light_on());
		assertEquals(false,tc07.isYellow_light_on());
		assertEquals(false,tc07.isGreen_light_on());
		assertEquals(true,tc07.isChime_on());
		
		
		Alarm_Class tc08=new Alarm_Class();
		tc08.compute_alarms(299.9);
		assertEquals(true,tc08.isRed_light_on());
		assertEquals(false,tc08.isYellow_light_on());
		assertEquals(false,tc08.isGreen_light_on());
		assertEquals(true,tc08.isChime_on());
		
		
		Alarm_Class tc09=new Alarm_Class();
		tc09.compute_alarms(300.0);
		assertEquals(false,tc09.isRed_light_on());
		assertEquals(false,tc09.isYellow_light_on());
		assertEquals(false,tc09.isGreen_light_on());
		assertEquals(true,tc09.isChime_on());
		
		
		Alarm_Class tc10=new Alarm_Class();
		tc10.compute_alarms(500.0);
		assertEquals(false,tc10.isRed_light_on());
		assertEquals(false,tc10.isYellow_light_on());
		assertEquals(false,tc10.isGreen_light_on());
		assertEquals(true,tc10.isChime_on());
		
	}

}
