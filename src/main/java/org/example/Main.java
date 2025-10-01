package org.example;

import org.example.cli.BenchmarkRunner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        if (args.length <1) {
            help();
            return;
        }
        for (String arg : args) {
            if (arg.equals("--help") || arg.equals("help")) {
                help();
                break;
            } else{
                BenchmarkRunner.main(args);
                break;
            }
        }
    }

    private static void help() {
        System.out.println("""
            Usage:
                java -cp target/daa_asik2_heapSort-1.0-SNAPSHOT.jar org.example.Main [int size] [int trials]
            
            Algorithms:
              --algorithm <name>    only heapSort supported

            Other options:
              --size <n>            Size of the array (default: 10000)
              --trials <t>          Number of trials to average (default: 5)
              --help                Show this help message
              
            Example:
                java -cp target/daa_asik2_heapSort-1.0-SNAPSHOT.jar org.example.Main  200 5
                
            """);
    }
}