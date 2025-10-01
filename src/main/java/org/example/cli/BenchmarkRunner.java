package org.example.cli;

import org.example.algorithms.HeapSort;
import org.example.csvWriter.CSVWriter;
import org.example.metrics.Metrics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int size = (args.length > 0) ? Integer.parseInt(args[0]) : 10000;
        int trials = (args.length > 1) ? Integer.parseInt(args[1]) : 5;

        CSVWriter csv = new CSVWriter("results.csv");
        Metrics metrics = new Metrics();

        for (int t = 0; t < trials; t++) {
            int[] arr = generate(size, t);
            int[] copy = Arrays.copyOf(arr, arr.length);

            metrics.reset();
            long start = System.nanoTime();

            HeapSort.heapSort(copy, metrics);

            long timeMs = (System.nanoTime() - start) / 1_000_000;
            csv.write("heap", size, timeMs, metrics);
            System.out.printf("algorithm=heap trial=%d n=%d time=%dms comps=%d swaps=%d accesses=%d\n",
                    t, size, timeMs,
                    metrics.getComparisons(),
                    metrics.getSwaps(),
                    metrics.getArrayAccesses());
        }
    }

    private static int[] generate(int n,  int seed) {
        Random r = new Random(12345 + seed);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(); // fill with random ints
        }
        return a;
    }

}
