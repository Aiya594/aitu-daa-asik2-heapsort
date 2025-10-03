package org.example.cli;

import org.example.algorithms.HeapSort;
import org.example.metrics.Metrics;
import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)          // измеряем среднее время выполнения
@OutputTimeUnit(TimeUnit.MILLISECONDS)   // выводим в миллисекундах
public class HeapSortBenchmark {

    @Param({"1000", "10000", "50000"})   // размеры массивов для теста
    private int size;

    private int[] data;
    private Metrics metrics;

    @Setup(Level.Iteration)
    public void setup() {
        Random random = new Random(12345);  // фиксируем seed для воспроизводимости
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt();
        }
        metrics = new Metrics();
    }

    @Benchmark
    public void heapSortBenchmark() {
        int[] copy = data.clone();
        HeapSort.heapSort(copy, metrics);  // вызываем HeapSort с метрикой
    }
}