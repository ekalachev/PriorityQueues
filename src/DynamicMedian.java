import java.util.Comparator;
import java.util.PriorityQueue;

public class DynamicMedian {
    private final PriorityQueue<Integer> lowers;
    private final PriorityQueue<Integer> highers;

    public DynamicMedian() {
        lowers = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a.compareTo(b) * -1;
            }
        });
        highers = new PriorityQueue<Integer>();
    }

    private void rebalance() {
        PriorityQueue<Integer> biggerHeap;
        PriorityQueue<Integer> smallerHeap;

        if (lowers.size() > highers.size()) {
            biggerHeap = lowers;
            smallerHeap = highers;
        } else {
            biggerHeap = highers;
            smallerHeap = lowers;
        }

        if (biggerHeap.size() - smallerHeap.size() > 1) {
            smallerHeap.add(biggerHeap.poll());
        }
    }

    public double findMedian() {
        PriorityQueue<Integer> biggerHeap;
        PriorityQueue<Integer> smallerHeap;

        if (lowers.size() > highers.size()) {
            biggerHeap = lowers;
            smallerHeap = highers;
        } else {
            biggerHeap = highers;
            smallerHeap = lowers;
        }

        if (biggerHeap.size() == smallerHeap.size()) {
            return ((double) biggerHeap.peek() + smallerHeap.peek()) / 2;
        } else {
            return biggerHeap.peek();
        }
    }

    public void removeMedian() {
        PriorityQueue<Integer> biggerHeap;
        PriorityQueue<Integer> smallerHeap;

        if (lowers.size() > highers.size()) {
            biggerHeap = lowers;
            smallerHeap = highers;
        } else {
            biggerHeap = highers;
            smallerHeap = lowers;
        }

        if (biggerHeap.size() == smallerHeap.size()) {
            smallerHeap.poll();
        } else {
            biggerHeap.poll();
        }
    }

    public void insert(int item) {
        if (lowers.size() == 0 || item < lowers.peek()) {
            lowers.add(item);
        } else {
            highers.add(item);
        }

        rebalance();
    }

    public boolean isEmpty() {
        return lowers.size() == 0 && highers.size() == 0;
    }
}
