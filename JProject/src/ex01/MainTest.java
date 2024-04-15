package ex01; 
import org.junit.Test; 
import static org.junit.Assert.assertEquals;  
import junit.framework.Assert; 
import java.io.IOException;  

public class MainTest {
@Test
public void testCalc() {  
Calc calc = new Calc();
calc.Init(new double[] {100,120,140}, 30); //initializing new ElectricCircle with 30 A and 100V,120V,140V
assertEquals(12.0, calc.GetResistance(), .1e-10);   //Expected double resist is 12.0 
assertEquals(30.0, calc.GetResult().GetFlowPower(), .1e-10);  //Expected saved flow power is 30 
assertEquals(Long.toHexString((long) 12.0),calc.HexadecimalRepresentation()); //Expected Hexadecimal representation is 0xc
assertEquals(Long.toOctalString((long) 12.0), calc.OctalRepresentation(), calc.OctalRepresentation());  //Expected Octal representation is 0o14
calc.Init(new double[] {100,120,160}, 10); //double check but for bigger resistance
assertEquals(38.0, calc.GetResistance(), .1e-10);   
assertEquals(10, calc.GetResult().GetFlowPower(), .1e-10);  
assertEquals(Long.toHexString((long) 38.0),calc.HexadecimalRepresentation());
assertEquals(Long.toOctalString((long) 38.0), calc.OctalRepresentation());  
}
@Test 
public void testRestore() {  
Calc calc = new Calc();
double[] testArray = new double[] {111.0,222.0,333.0}; //initializing new ElectricCircle with certain data
double testFlow = 10;
calc.Init(testArray,10);
try{ 
calc.Save(); //trying to save current parameters to file
} 
catch (IOException e) 
{  
Assert.fail(e.getMessage()); 
}
calc.Init(new double[] {Math.random() * 360,Math.random() * 360,Math.random() * 360}, Math.random() * 360); //overriding of current parameters
try{ 
calc.Restore(); //restoring current parameters with the ones that in file
} 
catch (Exception e)
{  
Assert.fail(e.getMessage()); 
}
for (int i = 0; i < testArray.length; i++) {
	assertEquals(testArray[i], calc.GetResult().GetVoltages()[i], .1e-10); //for some reason assertArrayEquals doesn't work as intended (maybe JUnit 4 doesn't have overload for double[], double[])
}

assertEquals(testFlow, calc.GetResult().GetFlowPower(), .1e-10); //Compare of current parameters with the one that was setted on a start of the test
} 
} 
 
