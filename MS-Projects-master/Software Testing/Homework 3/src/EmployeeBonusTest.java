import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeBonusTest {

	

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
		EmployeeBonus tc01=new EmployeeBonus();
		tc01.calculate_bonus(-0.01);
		assertEquals(-500.00,tc01.getBonus_to_be_paid(),0.01);
		assertEquals(false,tc01.isGift_card_earned());
		assertEquals(Sales_status.NO_SALES,tc01.getSales_stat());
		
		EmployeeBonus tc02=new EmployeeBonus();
		tc02.calculate_bonus(0.00);
		assertEquals(0.00,tc02.getBonus_to_be_paid(),0.01);
		assertEquals(false,tc02.isGift_card_earned());
		assertEquals(Sales_status.ORDINARY_SALES,tc02.getSales_stat());
		
		EmployeeBonus tc03=new EmployeeBonus();
		tc03.calculate_bonus(24999.99);
		assertEquals(499.99,tc03.getBonus_to_be_paid(),0.01);
		assertEquals(false,tc03.isGift_card_earned());
		assertEquals(Sales_status.ORDINARY_SALES,tc03.getSales_stat());
		
		EmployeeBonus tc04=new EmployeeBonus();
		tc04.calculate_bonus(25000.00);
		assertEquals(687.50,tc04.getBonus_to_be_paid(),0.01);
		assertEquals(false,tc04.isGift_card_earned());
		assertEquals(Sales_status.ORDINARY_SALES,tc04.getSales_stat());
		
		EmployeeBonus tc05=new EmployeeBonus();
		tc05.calculate_bonus(99999.99);
		assertEquals(2749.99,tc05.getBonus_to_be_paid(),0.01);
		assertEquals(false,tc05.isGift_card_earned());
		assertEquals(Sales_status.ORDINARY_SALES,tc05.getSales_stat());
		
		EmployeeBonus tc06=new EmployeeBonus();
		tc06.calculate_bonus(100000.00);
		assertEquals(3500.00,tc06.getBonus_to_be_paid(),0.01);
		assertEquals(false,tc06.isGift_card_earned());
		assertEquals(Sales_status.ORDINARY_SALES,tc06.getSales_stat());
		
		EmployeeBonus tc07=new EmployeeBonus();
		tc07.calculate_bonus(200000.00);
		assertEquals(7000.00,tc07.getBonus_to_be_paid(),0.01);
		assertEquals(false,tc07.isGift_card_earned());
		assertEquals(Sales_status.ORDINARY_SALES,tc07.getSales_stat());
		
		EmployeeBonus tc08=new EmployeeBonus();
		tc08.calculate_bonus(200000.01);
		assertEquals(7500.00,tc08.getBonus_to_be_paid(),0.01);
		assertEquals(false,tc08.isGift_card_earned());
		assertEquals(Sales_status.ORDINARY_SALES,tc08.getSales_stat());
		
		EmployeeBonus tc09=new EmployeeBonus();
		tc09.calculate_bonus(400000.00);
		assertEquals(15000.00,tc09.getBonus_to_be_paid(),0.01);
		assertEquals(false,tc09.isGift_card_earned());
		assertEquals(Sales_status.ORDINARY_SALES,tc09.getSales_stat());
		
		EmployeeBonus tc10=new EmployeeBonus();
		tc10.calculate_bonus(400000.01);
		assertEquals(16000.00,tc10.getBonus_to_be_paid(),0.01);
		assertEquals(true,tc10.isGift_card_earned());
		assertEquals(Sales_status.TOP_SELLER,tc10.getSales_stat());
		
		
		
	}
}
