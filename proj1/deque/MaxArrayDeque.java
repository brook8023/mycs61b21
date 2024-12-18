package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    private Comparator<T> c;

    public MaxArrayDeque(Comparator<T> c) {
        this.c = c;
    }

    public T max() {
        return max(this.c);
    }

    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        int maxi = 0;
        for (int i = 0; i < size(); i++) {
            if (c.compare(get(i), get(maxi)) > 0) {
                maxi = i;
            }
        }
        return get(maxi);
    }


}
