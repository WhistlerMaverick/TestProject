package Comm_test;

//import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNGPC2 extends BaseClass {
	@Test(priority = 0)
//	@Ignore
	public void B() {
		System.out.println("This is the B");
	}

	@Test(priority = 1)
//	@Ignore
	public void A() {
		System.out.println("This is the A");
	}


}
