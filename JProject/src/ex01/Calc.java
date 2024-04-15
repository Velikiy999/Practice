package ex01; 
import java.io.IOException; 
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.ObjectInputStream;  
import java.io.ObjectOutputStream;

public class Calc { 
private static final String FNAME = "ElectricCircle.bin";
private ElectricCircle result; 

public Calc() { 
result = new ElectricCircle(); //inits empty ElectricCircle
}
	//getter for ElectricCircle object instance
	public void SetResult(ElectricCircle result) {
	this.result = result; 
	}

	public ElectricCircle GetResult() {  
	return result; 
	}
	//calculation of Ohm law
	public double GetResistance() {
		double totalResistance = 0;
		
		for (double voltage : result.GetVoltages()) 
		{
	        totalResistance += voltage / result.GetFlowPower(); //since ElectricCircle is sequenced, resists are simply added to each other
	    }
		
		return totalResistance;
	}
	
	public String OctalRepresentation() {
		return Long.toOctalString((long) GetResistance()); //Octal representation of double resistance 
	}

	public String HexadecimalRepresentation() {
		return Long.toHexString((long) GetResistance()); //Hexadecimal representation of double resistance
	}
	
	//initiator based on double setter
	public void Init(double[] voltages, double flowPower) {
		this.result.setFlowPowerAndVoltages(voltages, flowPower);
	} 
	//call of overrided toString() method
	public void Show() { 
	System.out.println(this.result.toString()); 
	}
	
	//save method on file system 
	public void Save() throws IOException {  
	ObjectOutputStream os = new ObjectOutputStream(new 
	FileOutputStream(FNAME));  
	os.writeObject(result);  
	os.flush(); 
	os.close(); 
	System.out.println("Success!");
	}
	
	//restore method, returns last saved parameters
	public void Restore() throws Exception { 
	ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));  result = (ElectricCircle)is.readObject(); 
	is.close();
	System.out.println("Success! Restored variables shown below:");
	Show();
	}

	} 
