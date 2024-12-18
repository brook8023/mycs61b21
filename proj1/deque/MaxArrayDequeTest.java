package deque;

import java.util.Comparator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaxArrayDequeTest {
    @Test
    public void compareTest() {
        MaxArrayDeque<String> maxd = new MaxArrayDeque<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        maxd.addFirst("front");
        maxd.addLast("backfsdf");
        maxd.addLast("middle");
        maxd.addLast("back");
        maxd.addLast("backwerwaae");
        maxd.addLast("backwerwaab");
        assertEquals("backwerwaae", maxd.max());
        assertEquals("middle", maxd.max(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        }));


    }

}
