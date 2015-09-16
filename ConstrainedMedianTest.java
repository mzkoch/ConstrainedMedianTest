import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;


public class ConstrainedMedianTest {
	
	private static final int MAX_RUNTIME = 500;

    @Rule
    public Timeout globalTimeout = new Timeout(MAX_RUNTIME);

	@Test
	public void test1() {
		int n = 3;
		int[] xPresent = {0,1};
		int[] yPresent = {0,1};
		int xMissing = 1;
		int yMissing = 0;
		int k = 1;
		
		ConstrainedMedian cm = new ConstrainedMedian(n, xPresent, yPresent, xMissing, yMissing);
		assertEquals(1, cm.minimizeDistance(k));
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
		assertEquals(0, cm.minimizeDistance(k));
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
		assertEquals(2, cm.minimizeDistance(k));
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
		assertEquals(19, cm.minimizeDistance(k));
	}

}
