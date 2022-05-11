package com.application.gpu;

import java.util.Scanner;

public class NvidiaGpu implements Gpu{
    @Override
    public int GetGpuUsage() {
        /*
         * nvidia-smi
         * */
        var command = "nvidia-smi --query-gpu=utilization.gpu --format=csv,noheader";
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
