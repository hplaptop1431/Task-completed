package sample;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeakCalls {

    public static void main(String[] args) throws IOException {
        
        File file = new File("call_log.txt");
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: call_log.txt");
        }

        
        Scanner scanner = new Scanner(file);
        List<Call> calls = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(":");
            calls.add(new Call(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
        }

        
        int peak = 0;
        int current = 0;
        for (Call call : calls) {
            for (int i = call.start; i < call.end; i++) {
                current += 1;
                if (current > peak) {
                    peak = current;
                }
                if (current == peak) {
                    
                }
            }
            current -= 1;
        }

        
        System.out.println("Peak: " + peak);
    }

    private static class Call {

        int start;
        int end;

        public Call(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}

