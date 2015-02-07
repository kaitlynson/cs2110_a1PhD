import static org.junit.Assert.*;

import org.junit.Test;


public class PhDTester {

	@Test
	public void  testConstructor1() {
		PhD p1 = new PhD("Kathryn Zimmerman" ,'F',2015,2);
		assertEquals("Kathryn Zimmerman", p1.getName());
		assertEquals(true, p1.isFemale());
		assertEquals(2015, p1.getYear());
		assertEquals(2, p1.getMonth());
		assertEquals(null, p1.getAdvisor1());
		assertEquals(null, p1.getAdvisor2());
		assertEquals(0, p1.numAdvisees());
		PhD p2 = new PhD("Dillon Zimmerman" ,'M',2015,2);
		assertEquals(false, p2.isFemale());
	}
	@Test
	public void  testAddAdvisors() {
		PhD p1 = new PhD("Kathryn Zimmerman" ,'F',1995,9);
		PhD p2 = new PhD("Erin Moore" ,'F',1996,4);
		PhD p3 = new PhD("Dillon Zimmerman" ,'M',1997,9);
		p3.addAdvisor1(p1);
		p3.addAdvisor2(p2);
		p2.addAdvisor1(p1);
		assertEquals(p1, p3.getAdvisor1());
		assertEquals(p2, p3.getAdvisor2());
		assertEquals(2, p1.numAdvisees());
		assertEquals(1, p2.numAdvisees());
	}
	@Test	
	public void  testConstructors2and3() {
		PhD p1 = new PhD("Kathryn Zimmerman" ,'F',1995,2);
		PhD p2 = new PhD("Erin Moore" ,'F',1996,4, p1);
		assertEquals("Erin Moore", p2.getName());
		assertEquals(true, p2.isFemale());
		assertEquals(1996, p2.getYear());
		assertEquals(4, p2.getMonth());
		assertEquals(p1, p2.getAdvisor1());
		assertEquals(null, p2.getAdvisor2());
		assertEquals(0, p2.numAdvisees());
		assertEquals(1, p1.numAdvisees());
		PhD p3 = new PhD("Dillon Zimmerman" ,'M',1997,9, p1, p2);
		assertEquals("Dillon Zimmerman", p3.getName());
		assertEquals(false, p3.isFemale());
		assertEquals(1997, p3.getYear());
		assertEquals(9, p3.getMonth());
		assertEquals(p1, p3.getAdvisor1());
		assertEquals(p2, p3.getAdvisor2());
		assertEquals(0, p3.numAdvisees());
		assertEquals(1, p2.numAdvisees());
		assertEquals(2, p1.numAdvisees());
	}
	@Test	
	public void  testComparisonMethods() {
		PhD p1 = new PhD("Kathryn Zimmerman" ,'F',1995,2);
		PhD p2 = new PhD("Erin Moore" ,'F',1996,4, p1);
		PhD p3 = new PhD("Dillon Zimmerman" ,'M',1997,9, p1);
		PhD p4 = new PhD("Megan Olivola" ,'F',1996,6, p1);
		assertEquals(true, p1.isOlderThan(p2));
		assertEquals(true, p1.isOlderThan(p3));
		assertEquals(true, p2.isPhDSibling(p3));
		assertEquals(true, p3.isPhDSibling(p2));
		assertEquals(false, p4.isOlderThan(p2));
		PhD p5 = new PhD("Julia Kruk" ,'F',1996,4, p1, p2);
		PhD p6 = new PhD("Erica Sadler" ,'F',1996,3, p2);
		assertEquals(true, p5.isPhDSibling(p6));
	}
}
