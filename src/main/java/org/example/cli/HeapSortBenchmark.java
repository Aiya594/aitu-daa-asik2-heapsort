package org.example.cli;

import org.example.algorithms.HeapSort;
import org.example.metrics.Metrics;
import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class HeapSortBenchmark {

    @Param({"1000", "10000", "50000"})
    private int size;

    private int[] data;
    private Metrics metrics;

    @Setup(Level.Iteration)
    public void setup() {
        Random random = new Random(12345);
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt();
        }
        metrics = new Metrics();
    }

    @Benchmark
    public void heapSortBenchmark() {
        int[] copy = data.clone();
        HeapSort.heapSort(copy, metrics);
    }
}