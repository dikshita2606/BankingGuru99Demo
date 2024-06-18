package TestNGDemo;

import org.testng.annotations.Test;

public class InvocationCountDemo {

	@Test(invocationCount = 10)
	public void TestMethod() {
		System.out.println("testing!!!");
	}
}
