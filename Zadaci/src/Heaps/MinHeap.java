package Heaps;
import java.util.ArrayList;
import java.util.List;

public class MinHeap {

        private List<Integer> heap;

        public MinHeap() {
            this.heap = new ArrayList<>();
        }

        public List<Integer> getHeap() {
            return new ArrayList<>(heap);
        }

        private int leftChild(int index) {
            return 2 * index + 1;
        }

        private int rightChild(int index) {
            return 2 * index + 2;
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        private void swap(int index1, int index2) {
            int temp = heap.get(index1);
            heap.set(index1, heap.get(index2));
            heap.set(index2, temp);
        }

        public void insert(int value) {
            heap.add(value);
            int index = heap.size() - 1;
            while (index >= 0 && heap.get(index) < heap.get(parent(index))) {
                swap(index, parent(index));
                index = parent(index);
            }
        }
        public Integer removeMin() {
            if (heap.size() ==0) {return null;}
            if (heap.size() ==1) {
                return heap.remove(0);
            }
            int maxValue = heap.get(0);
            heap.set(0, heap.get(heap.size() - 1));
            sinkDown(0);
            return maxValue;
        }

        public void sinkDown(int index) {
            int minIndex = index;
            while (true){
                int leftChild = leftChild(minIndex);
                int rightChild = rightChild(minIndex);
                if (leftChild < heap.size() && heap.get(leftChild) < heap.get(rightChild)) {
                    minIndex = leftChild;
                }
                if (rightChild < heap.size() && heap.get(rightChild) < heap.get(minIndex)) {
                    minIndex = rightChild;
                }
                if (minIndex != index) {
                    swap(minIndex, index);
                    index = minIndex;
                }else {
                    return;
                }
            }
        }

        // WRITE THE INSERT METHOD HERE //
        //                              //
        //                              //
        //                              //
        //                              //
        //////////////////////////////////

    }

