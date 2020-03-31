package main.java;

class Main {
    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = partion(arr, lo, hi);
            quickSort(arr, lo, p - 1);
            quickSort(arr, p + 1, hi);
        }
    }

    private static int partion(int[] arr, int lo, int hi) {
        // int midValue = middleOfThree(arr, lo, hi, (int) Math.ceil(arr.length / 2));
        int pivot = arr[hi];
        int i = lo;
        for (int j = lo; j <= hi; j++) {
            if (arr[j] < pivot) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        int tmp = arr[i];
        arr[i] = arr[hi];
        arr[hi] = tmp;
        return i;
    }

    private static int middleOfThree(int[] arr, int lo, int hi, int mid) {
        if (arr[lo] > arr[hi]) {
            if (arr[hi] > arr[mid]) {
                return hi;
            } else if (arr[lo] > arr[mid]) {
                return mid;
            } else {
                return lo;
            }
        } else {
            if (arr[lo] > arr[mid]) {
                return lo;
            } else if (arr[hi] > arr[mid]) {
                return mid;
            } else {
                return hi;
            }
        }
    }

    private static void shellSort(int[] arr) {
        int interval = 0;
        while (interval < arr.length / 3) {
            interval = interval * 3 + 1;
        }

        while (interval > 0) {
            for (int outer = interval; outer < arr.length; outer++) {
                int valueToInsert = arr[outer];
                int inner = outer;

                while (inner > interval - 1 && arr[inner - interval] >= valueToInsert) {
                    arr[inner] = arr[inner - interval];
                    inner = inner - interval;
                }
                arr[inner] = valueToInsert;
            }
            interval = (interval - 1) / 3;
        }
    }

    private static void mergeSort(int[] arr, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = (lo + hi) / 2;
        mergeSort(arr, lo, mid);
        mergeSort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int left[] = new int[mid - lo + 1];
        int right[] = new int[hi - mid];
        for (int i = 0; i < left.length; i++) {
            left[i] = arr[lo + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = arr[mid + i + 1];
        }

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = lo; i < hi + 1; i++) {
            if (leftIndex < left.length && rightIndex < right.length) {
                if (left[leftIndex] < right[rightIndex]) {
                    arr[i] = left[leftIndex];
                    leftIndex++;
                } else {
                    arr[i] = right[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < left.length) {
                arr[i] = left[leftIndex];
                leftIndex++;
            } else {
                arr[i] = right[rightIndex];
                rightIndex++;
            }
        }
    }

    private static void print(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] orginal_values = { 23, 67, 13, 18, 92, 8, 6 };
        int[] values = orginal_values.clone();
        quickSort(values, 0, values.length - 1);
        print(values);

        values = orginal_values.clone();
        shellSort(values);
        print(values);

        values = orginal_values.clone();
        mergeSort(values, 0, values.length - 1);
        print(values);
    }
}