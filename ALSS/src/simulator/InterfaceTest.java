package simulator;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InterfaceTest {

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
	public void test() throws InterruptedException {
		Inputs pilot = new Inputs();

		pilot.setSpeed(401);
		pilot.setAltitude(1000); 
		pilot.setTime(59);
		pilot.setGear("N");
		pilot.setGearAirSpeedAlarm(false);
		pilot.setAirBrakeWarning(true);
		pilot.setGearNotDownAlarm(true);
		pilot.setGearOverrideWarning(false);  
		Display_Controller display1=new Display_Controller(pilot);
		display1.setVisible(true);
		Thread.sleep(2000);
		
		pilot.setSpeed(401);
		pilot.setAltitude(1000); 
		pilot.setTime(59);
		pilot.setGear("Y");
		pilot.setGearAirSpeedAlarm(true);
		pilot.setAirBrakeWarning(true);
		pilot.setGearNotDownAlarm(false);
		pilot.setGearOverrideWarning(true);  
		Display_Controller display2=new Display_Controller(pilot);
		display2.setVisible(true);
		Thread.sleep(2000);
		
		pilot.setSpeed(401);
		pilot.setAltitude(1000); 
		pilot.setTime(60);
		pilot.setGear("Y");
		pilot.setGearAirSpeedAlarm(true);
		pilot.setAirBrakeWarning(false);
		pilot.setGearNotDownAlarm(false);
		pilot.setGearOverrideWarning(true);  
		Display_Controller display3=new Display_Controller(pilot);
		display3.setVisible(true);
		Thread.sleep(2000);
		
		pilot.setSpeed(401);
		pilot.setAltitude(1000); 
		pilot.setTime(60);
		pilot.setGear("N");
		pilot.setGearAirSpeedAlarm(false);
		pilot.setAirBrakeWarning(false);
		pilot.setGearNotDownAlarm(true);
		pilot.setGearOverrideWarning(false);  
		Display_Controller display4=new Display_Controller(pilot);
		display4.setVisible(true);
		Thread.sleep(2000);

		
		pilot.setSpeed(400);
		pilot.setAltitude(1000); 
		pilot.setTime(59);
		pilot.setGear("Y");
		pilot.setGearAirSpeedAlarm(true);
		pilot.setAirBrakeWarning(true);
		pilot.setGearNotDownAlarm(false);
		pilot.setGearOverrideWarning(false);  
		Display_Controller display5=new Display_Controller(pilot);
		display5.setVisible(true);
		Thread.sleep(2000);
		
		pilot.setSpeed(400);
		pilot.setAltitude(1000); 
		pilot.setTime(60);
		pilot.setGear("Y");
		pilot.setGearAirSpeedAlarm(true);
		pilot.setAirBrakeWarning(false);
		pilot.setGearNotDownAlarm(false);
		pilot.setGearOverrideWarning(false);  
		Display_Controller display6=new Display_Controller(pilot);
		display6.setVisible(true);
		Thread.sleep(2000);
		
		pilot.setSpeed(300);
		pilot.setAltitude(1000); 
		pilot.setTime(59);
		pilot.setGear("Y");
		pilot.setGearAirSpeedAlarm(false);
		pilot.setAirBrakeWarning(true);
		pilot.setGearNotDownAlarm(false);
		pilot.setGearOverrideWarning(false);  
		Display_Controller display7=new Display_Controller(pilot);
		display7.setVisible(true);
		Thread.sleep(2000);
		
		
		pilot.setSpeed(401);
		pilot.setAltitude(1000); 
		pilot.setTime(121);
		pilot.setGear("N");
		pilot.setGearAirSpeedAlarm(false);
		pilot.setAirBrakeWarning(false);
		pilot.setGearNotDownAlarm(false);
		pilot.setGearOverrideWarning(false);  
		Display_Controller display8=new Display_Controller(pilot);
		display8.setVisible(true);
		Thread.sleep(2000);

	} 

}
