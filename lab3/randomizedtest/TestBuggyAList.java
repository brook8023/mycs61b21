package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> fixedList = new AListNoResizing<>();
        BuggyAList<Integer> bugList = new BuggyAList<>();
        for (int i = 0; i < 10; i++) {
            fixedList.addLast(i);
            bugList.addLast(i);
        }

        for (int i = 0; i < 10; i++) {
            assertEquals(fixedList.removeLast(), bugList.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> bugList = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                bugList.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int bugListSize = bugList.size();
                assertEquals(size,bugListSize);
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() == 0 ) {
                    continue;
                }
                int item = L.getLast();
                int bugListItem = bugList.getLast();
                assertEquals(item,bugListItem);
            } else if (operationNumber == 3) {
                // removeLast
                if (L.size() == 0 ) {
                    continue;
                }
                int item = L.removeLast();
                int bugListItem = bugList.removeLast();
                assertEquals(item,bugListItem);
            }
        }
    }
}
