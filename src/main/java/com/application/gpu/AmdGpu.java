package com.application.gpu;

import java.util.Scanner;

public class AmdGpu implements Gpu{
    @Override
    public int GetGpuUsage() {
        /*
         * nvidia-smi --query-gpu=utilization.gpu --format=csv,noheader -> 0 %
         * */
        var command = "radeontop -l 1 -d -";
        try {
            Process process = Runtime.getRuntime().exec(command);

            Scanner scanner = new Scanner(process.getInputStream());

            scanner.useDelimiter("\\A");
            String commandOutput = scanner.next();

            String[] usageInfoEntries = commandOutput.split("\n")[1].split(":")[1].split(",");


            String gpuUtil = usageInfoEntries[1].split(" ")[2];

            return Integer.parseInt(gpuUtil);
        }catch (Exception ignored){}
        return 0;
    }
}
