package ex01; 
import java.io.Serializable;
import java.util.Arrays;

public class ElectricCircle implements Serializable {
private double[] voltages = new double[3];
private double flowPower;

private static final long serialVersionUID = 1L; 

//default empty constructor
public ElectricCircle() {
	voltages = new double[]{0,0,0};
	flowPower = 0;
}
//constructor with two parameters in it
public ElectricCircle(double[] voltages, double flowPower) 
{
this.voltages = validateVoltages(voltages); //all assignments are done through validators to minimize user caused errors
this.flowPower = validateFlowPower(flowPower); 
}
//setter for voltages
public void SetVoltages(double[] voltages) 
{
this.voltages = validateVoltages(voltages);
}
//getter for voltages
public double[] GetVoltages() 
{  
return voltages; 
}
//setter for flow power
public void SetFlowPower(double flowPower) {  
this.flowPower = validateFlowPower(flowPower); 
}
//getter for flow power
public double GetFlowPower() {  
return flowPower;
}
//combined getter for both voltages and flow power
public void setFlowPowerAndVoltages(double[] voltages, double flowPower) {
SetVoltages(voltages);
SetFlowPower(flowPower);
}
//silent override for toString() method
public String toString() {
	StringBuilder message = new StringBuilder();
	message.append("Current variables shown below \n");
    message.append(String.format("Flow power: %sA\n", flowPower));
    for(int i = 0; i < voltages.length; i++)
    {
        message.append(String.format("Voltage %d: %sV\n", i, voltages[i]));
    }
    
    return message.toString();
}
//private validator - checks correct input for voltages
private double[] validateVoltages(double[] voltages) {
	if (voltages.length != 3) 
	 {
        throw new IllegalArgumentException("voltages array must have 3 elements in it"); //to prevent some of assign to .this errors
    }
	
	return voltages; 
}
//private validator - checks correct input for flowPower
private double validateFlowPower(double flowPower) {
	
	if(flowPower < 0) 
	{
		throw new IllegalArgumentException("flow power can't be negative"); //physics rule
	}
	
	return flowPower; 
}
//override for basic == operator
@Override 
public boolean equals(Object obj) {  
if (this == obj) 
return true;  
if (obj == null) 
return false; 
if (getClass() != obj.getClass())  
return false;

ElectricCircle other = (ElectricCircle) obj;
if (!Arrays.equals(voltages, other.voltages)) return false;
if (Double.doubleToLongBits(flowPower) != Double.doubleToLongBits(other.flowPower)) return false;
return true;
} 
} 
