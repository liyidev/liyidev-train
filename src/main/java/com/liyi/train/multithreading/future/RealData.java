package com.liyi.train.multithreading.future;

import java.util.concurrent.Callable;

/**
 * @description:
 * @author: liyi
 * @create: 2018-10-16 20:30
 */
public class RealData implements Callable {
    private String result;

    public RealData (String result) {
        this.result = result;
    }

    @Override
    public Object call () throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append(result);
        //模拟耗时的构造数据过程
        Thread.sleep(5000);
        return sb.toString();
    }
}
