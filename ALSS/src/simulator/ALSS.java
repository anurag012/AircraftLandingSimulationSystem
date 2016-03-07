package simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ALSS {
	public static Map<Integer,Inputs> hmap_alss = new HashMap<Integer, Inputs>();
	public static int count=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Anurag\\Desktop\\ALSS Test Input.txt"));
		br.readLine(); 
		String line=""; 
		while((line=br.readLine())!=null){
			Inputs input=new Inputs();
			String parts[]=line.split("\t");
			input.setId(Integer.parseInt(parts[0]));
			input.setSpeed(Integer.parseInt(parts[1]));
			input.setGear(parts[2]);
			input.setAltitude(Integer.parseInt(parts[3]));
			input.setTime(Integer.parseInt(parts[4]));
			
			input.setGearNotDownAlarm(parts[5].equalsIgnoreCase("T"));
			input.setGearAirSpeedAlarm(parts[6].equalsIgnoreCase("T"));
			input.setAirBrakeWarning(parts[7].equalsIgnoreCase("T"));
			input.setGearOverrideWarning(parts[8].equalsIgnoreCase("T"));
			hmap_alss.put(input.getId(), input);
		} 

		System.out.println("id \t"+"speed \t"+ "gear \t"+"alt \t"+"time \t"+"expectdGearNotDown "+"expctdGearAirSpeed "+"expectedAirBrake "+"expctdOVerride "+
		"actualGearNotDown "+ "actualAirspeed "+ "actualAirBrake "+"actualOverride "+"TestResult");
		System.out.println("\n");
		
	for(Map.Entry<Integer, Inputs> entry : hmap_alss.entrySet()){	
		Inputs pilot=ComputeSimulationState(entry);
		count++;
		String result;
		boolean a1=pilot.getGearNotDownAlarm();
		boolean a2=pilot.getGearNotDownAlarmActual();
		boolean b1=pilot.getGearAirSpeedAlarm();
		boolean b2=pilot.getGearAirSpeedAlarmActual();
		boolean c1=pilot.getAirBrakeWarning();
		boolean c2=pilot.getAirBrakeWarningActual();
		boolean d1=pilot.getGearOverrideWarning();
		boolean d2=pilot.getGearOverrideWarningActual();
		if(a1==a2 & b1==b2 & c1==c2 & d1==d2){
			result="PASS";
		}else {
			result="FAIL";
		}
		System.out.println(count+"\t"+pilot.getSpeed()+"\t"+pilot.getGear()+"\t"+pilot.getAltitude()+"\t"+pilot.getTime()+"\t\t"+a1+"\t\t"+b1+"\t\t"+c1+"\t\t"+d1+"\t\t"+a2+"\t\t"+
		b2+"\t\t"+c2+"\t\t"+d2+"\t\t"+result);
	}
	br.close();
	}
	
	
	
	public static Inputs ComputeSimulationState(Entry<Integer, Inputs> entry) throws InterruptedException{
		int speed;
		int altitude;
		int time;
		String gear; 

		speed=entry.getValue().getSpeed();
		altitude=entry.getValue().getAltitude(); 
		time=entry.getValue().getTime();
		gear=entry.getValue().getGear();
		
	/**************************Expected Output***************************************************/	
		boolean exp_gear_not_down = entry.getValue().getGearNotDownAlarm();
		boolean exp_gear_override = entry.getValue().getGearOverrideWarning();
		boolean exp_air_brake = entry.getValue().getAirBrakeWarning();
		boolean exp_gear_air_speed = entry.getValue().getGearAirSpeedAlarm();
	
	/***************************Actual Output****************************************************/	
		boolean airbrake_warning=(speed >= 250) & (time < 60);
		boolean gear_override=(gear.equalsIgnoreCase("Y")) & (speed > 400);
		boolean gear_not_down_alarm = (gear.equalsIgnoreCase("N")) & ((time<=120) | (altitude < 1000));
		boolean gear_air_speed_alarm = (gear.equalsIgnoreCase("Y")) & (speed > 300);
		Inputs display = new Inputs(); 		 
		display.setSpeed(speed);
		display.setAltitude(altitude);
		display.setTime(time);
		display.setGear(gear);
	/******************Setting Expected and Actual Output to the object***********************************/	
		display.setAirBrakeWarning(exp_air_brake);
		display.setGearAirSpeedAlarm(exp_gear_air_speed);
		display.setGearNotDownAlarm(exp_gear_not_down);
		display.setGearOverrideWarning(exp_gear_override);
		
		display.setGearNotDownAlarmActual(gear_not_down_alarm);
		display.setGearOverrideWarningActual(gear_override);
		display.setAirBrakeWarningActual(airbrake_warning);
		display.setGearAirSpeedAlarmActual(gear_air_speed_alarm);
		
		return display;
	}
}

class Inputs{
	private int id;
	private int speed;
	private int altitude;
	private int time;
	private String gear_stat;
	private boolean gearNotDown;
	private boolean airSpeed;
	private boolean airBrake;
	private boolean override;
	private boolean gearNotDownActual;
	private boolean airSpeedActual;
	private boolean airBrakeActual;
	private boolean overrideActual;

	public int getId() {
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed){
		this.speed=speed;
	}
	public int getAltitude(){
		return altitude;
	}
	public void setAltitude(int altitude){
		this.altitude=altitude;
	}
	public int getTime(){
		return time;
	}
	public void setTime(int time){
		this.time=time;
	}
	public String getGear(){
		return gear_stat;
	}
	public void setGear(String gear_stat){
		this.gear_stat=gear_stat;
	}
	public boolean getGearNotDownAlarm(){
		return gearNotDown;
	}
	public void setGearNotDownAlarm(boolean gearNotDown){
		this.gearNotDown=gearNotDown;
	}
	public boolean getGearAirSpeedAlarm(){
		return airSpeed;
	} 
	public void setGearAirSpeedAlarm(boolean airSpeed){
		this.airSpeed=airSpeed;
	}
	public boolean getAirBrakeWarning(){
		return airBrake;
	}
	public void setAirBrakeWarning(boolean airBrake){
		this.airBrake=airBrake;
	}
	public boolean getGearOverrideWarning(){
		return override;
	}
	public void setGearOverrideWarning(boolean override){
		this.override=override;
	}
	public boolean getGearNotDownAlarmActual(){
		return gearNotDownActual;
	}
	public void setGearNotDownAlarmActual(boolean gearNotDownActual){
		this.gearNotDownActual=gearNotDownActual;
	} 
	public boolean getGearAirSpeedAlarmActual(){
		return airSpeedActual;
	}
	public void setGearAirSpeedAlarmActual(boolean airSpeedActual){
		this.airSpeedActual=airSpeedActual;
	}
	public boolean getAirBrakeWarningActual(){
		return airBrakeActual;
	}
	public void setAirBrakeWarningActual(boolean airbrakeActual){
		this.airBrakeActual=airbrakeActual;
	}
	public boolean getGearOverrideWarningActual(){
		return overrideActual;
	}
	public void setGearOverrideWarningActual(boolean overrideActual){
		this.overrideActual=overrideActual;
	}

}
