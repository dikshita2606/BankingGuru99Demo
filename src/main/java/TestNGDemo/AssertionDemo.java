package TestNGDemo;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class AssertionDemo {

	@Test
	public void soft_assert() {
		String s1 = "abc";
		String s2 = "abc";
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(s1, s2, "String are not same ");
		
		System.out.println("Soft Assert done");
		sa.assertAll();
	}
}
