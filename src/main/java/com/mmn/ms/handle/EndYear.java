package com.mmn.ms.handle;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Mmn on 2019/5/22.
 * To be a happy coder!
 */
public class EndYear {
    public static void main(String[] args) throws ParseException {
        System.out.println(getEndYear("2018-01-02"));
    }

    public static String getEndYear(String startDayStr) throws ParseException {
        Date r;

        Date today = new Date();
        Date startDay = DateUtils.parseDate(startDayStr, "yyyy-MM-dd");
        Date endDay = DateUtils.addYears(startDay, 1);

        while (today.after(endDay)) {
            startDay = DateUtils.addDays(endDay, 1);
            endDay = DateUtils.addYears(startDay, 1);
        }

        r = endDay;

        return DateFormatUtils.format(r, "yyyy-MM-dd");
    }
}
