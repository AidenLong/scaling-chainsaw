package com.me.gupao;

import java.util.List;

/**
 * @Autor syl
 * @Date 2019/3/8 21:37
 **/
public class StatData {

    public int last10SecondAverage;
    public int last10MinuteAverage;
    public int last60MinuteAverage;
    public List<Integer> last60SecondHistory;

    @Override
    public String toString() {
        return "StatData{" +
                "last10SecondAverage=" + last10SecondAverage +
                ", last10MinuteAverage=" + last10MinuteAverage +
                ", last60MinuteAverage=" + last60MinuteAverage +
                ", last60SecondHistory=" + last60SecondHistory +
                '}';
    }
}
