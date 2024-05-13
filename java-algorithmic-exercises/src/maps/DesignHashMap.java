package maps;

import java.util.Arrays;

public class DesignHashMap {
    class MyHashMap {
        int[] data;

        public MyHashMap() {
            data = new int[1000001];
            Arrays.fill(data, -1);
        }

        public void put(int key, int val) {
            data[key] = val;
        }

        public int get(int key) {
            return data[key];
        }

        public void remove(int key) {
            data[key] = -1;
        }
    }

    public static void main(String[] args) {

    }
}
