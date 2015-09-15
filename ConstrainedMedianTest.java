import static org.junit.Assert.*;
import org.junit.Test;


public class ConstrainedMedianTest {
	
	private String runtimeMsg = "Runtime was greater than 500ms.";

	@Test
	public void test1() {
		int n = 3;
		int[] xPresent = {0,1};
		int[] yPresent = {0,1};
		int xMissing = 1;
		int yMissing = 0;
		int k = 1;
		
		ConstrainedMedian cm = new ConstrainedMedian(n, xPresent, yPresent, xMissing, yMissing);
		long start = System.nanoTime();
		int minDist = cm.minimizeDistance(k);
		long end = System.nanoTime();
		assertEquals(1, minDist);
		assertTrue(runtimeMsg, (end-start)/1000000 <= 500);
	}

	@Test
	public void test2() {
		int n = 5;
		int[] xPresent = {1,2,3,4};
		int[] yPresent = {0,1,2,3};
		int xMissing = 0;
		int yMissing = 4;
		int k = 0;
		
		ConstrainedMedian cm = new ConstrainedMedian(n, xPresent, yPresent, xMissing, yMissing);
		long start = System.nanoTime();
		int minDist = cm.minimizeDistance(k);
		long end = System.nanoTime();
		assertEquals(0, minDist);
		assertTrue(runtimeMsg, (end-start)/1000000 <= 500);
	}

	@Test
	public void test3() {
		int n = 5;
		int[] xPresent = {1,2,3,4};
		int[] yPresent = {0,1,2,3};
		int xMissing = 4;
		int yMissing = 0;
		int k = 2;
		
		ConstrainedMedian cm = new ConstrainedMedian(n, xPresent, yPresent, xMissing, yMissing);
		long start = System.nanoTime();
		int minDist = cm.minimizeDistance(k);
		long end = System.nanoTime();
		assertEquals(2, minDist);
		assertTrue(runtimeMsg, (end-start)/1000000 <= 500);
	}

	@Test
	public void test4() {
		int n = 7;
		int[] xPresent = {30,41,5,11,2,19};
		int[] yPresent = {15,32,39,6,12,21};
		int xMissing = 0;
		int yMissing = 5;
		int k = 10;
		
		ConstrainedMedian cm = new ConstrainedMedian(n, xPresent, yPresent, xMissing, yMissing);
		long start = System.nanoTime();
		int minDist = cm.minimizeDistance(k);
		long end = System.nanoTime();
		assertEquals(19, minDist);
		assertTrue(runtimeMsg, (end-start)/1000000 <= 500);
	}

}
