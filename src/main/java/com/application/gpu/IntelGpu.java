package com.application.gpu;

import java.util.Scanner;

public class IntelGpu implements Gpu{
    @Override
    public int GetGpuUsage() {
        /*
         * nvidia-smi --query-gpu=utilization.gpu --format=csv,noheader -> 0 %
         * */
        var command = "intel_gpu_top -l -s 5000";
        try {
            Process process = Runtime.getRuntime().exec(command);

            Scanner scanner = new Scanner(process.getInputStream());
            var percent = scanner.next();

            process.destroy();

            return Integer.parseInt(percent);
        }catch (Exception ignored){}
        return 0;
    }
}
