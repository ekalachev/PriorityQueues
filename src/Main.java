public class Main {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
//        DynamicMedian dm = new DynamicMedian();
//
//        for (int i : a) {
//            dm.insert(i);
//        }
//
//        while (!dm.isEmpty()) {
//            StdOut.println(dm.findMedian());
//            dm.removeMedian();
//        }

        MinHeap mh = new MinHeap();
        for (int i : a) {
            mh.add(i);
        }

        while (!mh.isEmpty()){
            StdOut.println(mh.delRandom());
        }
    }
}
