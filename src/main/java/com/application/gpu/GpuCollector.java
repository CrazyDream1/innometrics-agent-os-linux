package com.application.gpu;

public class GpuCollector {
    public int GetGpuUsage(){
        var nvidiaRes = new NvidiaGpu().GetGpuUsage();
        if (nvidiaRes > 0) {
            return nvidiaRes;
        }
        var amdRes = new AmdGpu().GetGpuUsage();
        if (amdRes > 0){
            return amdRes;
        }
        return new IntelGpu().GetGpuUsage();
    }
}
