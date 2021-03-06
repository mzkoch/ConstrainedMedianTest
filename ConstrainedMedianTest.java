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
	
	@Test
    public void test5() {
        int n = 21;
        int[] xPresent = {-256, 256, 23, 12, -199, -63, 32, 187, 199, -72, 20, 44, 39, 26, 144, 135, 244, -167, -33, 12};
        int[] yPresent = {15, 32, 39, 6, 12, 21, 256, -256, 24, -87, -92, -233, -196, -85, 123, 12, 135, 243, -222, 19 };
        int xMissing = 15;
        int yMissing = 5;
        int k = 8;

        ConstrainedMedian cm = new ConstrainedMedian(n, xPresent, yPresent, xMissing, yMissing);
        assertEquals(455, cm.minimizeDistance(k));
	}
	
	@Test
    public void test6() {
        int n = 7;
        int[] xPresent = {30,41,5,11,2,19};
        int[] yPresent = {15,32,39,6,12,21};
        int xMissing = 0;
        int yMissing = 5;
        int k = 6;

        ConstrainedMedian cm = new ConstrainedMedian(n, xPresent, yPresent, xMissing, yMissing);
        assertEquals(15, cm.minimizeDistance(k));
    }

	@Test
    public void test7() {
		final int n = 7;
        final int[] xPresent = new int[] { 158, -214, 38, -172, 149, -104 };
        final int[] yPresent = new int[] { -141, -145, 120, -223, 174, -141 };
        final int xMissing = 1;
        final int yMissing = 0;
        final int k = 38;

        ConstrainedMedian cm = new ConstrainedMedian(n, xPresent, yPresent, xMissing, yMissing);
        assertEquals(82, cm.minimizeDistance(k));
    }

	@Test
    public void test8() {
    	int n = 7;
    	int[] xPresent = {2,4,6,12,14,16};
    	int[] yPresent = {-20,6,8,14,16,18};
    	int xMissing = 0;
    	int yMissing = 1;
    	int k = 6; 

        ConstrainedMedian cm = new ConstrainedMedian(n, xPresent, yPresent, xMissing, yMissing);
        assertEquals(10, cm.minimizeDistance(k));
    }
	
	@Test
    public void test9() {
        int n = 5;
        int[] xPresent = {1,2,7,8};
        int[] yPresent = {0,1,6,7};
        int xMissing = 0;
        int yMissing = 0;
        int k = 3;

        ConstrainedMedian cm = new ConstrainedMedian(n, xPresent, yPresent, xMissing, yMissing);
        assertEquals(3, cm.minimizeDistance(k));
    }

    @Test
    public void test10() {
        int n = 5;
        int[] xPresent = {1,2,7,8};
        int[] yPresent = {0,1,2,3};
        int xMissing = 0;
        int yMissing = 0;
        int k = 3;

        ConstrainedMedian cm = new ConstrainedMedian(n, xPresent, yPresent, xMissing, yMissing);
        assertEquals(5, cm.minimizeDistance(k));
    }
}
