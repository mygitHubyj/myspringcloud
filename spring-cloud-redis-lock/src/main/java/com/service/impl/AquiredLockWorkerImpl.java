package com.service.impl;

import com.service.AquiredLockWorker;

public class AquiredLockWorkerImpl implements AquiredLockWorker {
    @Override
    public Object invokeAfterLockAquire() throws Exception {

        new Thread(new Runnable() {

            @Override
            public void run() {
                for(int i=0;i<5000;i++){
                    Math.random();
                }
            }
        }).start();
        Thread.sleep(500);
        System.out.println("测试线程"+Thread.currentThread().getId());
        return null;
    }
}
