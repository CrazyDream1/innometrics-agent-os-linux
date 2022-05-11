package com.application.gpu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class IntelGpu implements Gpu {
    @Override
    public int GetGpuUsage() {
        /*
         * intel_gpu_top
         * */
        var command = "intel_gpu_top -l -s 5000";
        String s;
        try {
            Process p = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(p.getInputStream()));
            if ((s = br.readLine()) != null) {
                if (!s.equals(" Freq MHz      IRQ RC6 Power     IMC MiB/s           RCS/0           BCS/0           VCS/0          VECS/0 ")) {
                    System.out.println("Wrong version of intel_gpu_top");
                    return 0;
                }
            }
            br.readLine();

            if (s.equals(" Freq MHz      IRQ RC6 Power     IMC MiB/s           RCS/0           BCS/0           VCS/0          VECS/0 ") || s.equals("  req  act       /s   %     W     rd     wr       %  se  wa       %  se  wa       %  se  wa       %  se  wa ")) {
                return 0;
            }
            Scanner parser = new Scanner(s);
            // System.out.println("line: " + s);
            for (int i = 0; i < 7; i++) {
                parser.next();
            }
            // overall_gpu_usage.add(parser.nextDouble());

            return Integer.parseInt(parser.next());

        } catch (Exception ignored) {
        }
        return 0;
    }
}