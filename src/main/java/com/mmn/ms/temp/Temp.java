package com.mmn.ms.temp;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Mmn on 2019/4/4.
 * To be a happy coder!
 */
public class Temp {
    static final String FORMAT = "yyyy-MM-dd";

    public static void main(String[] args) throws ParseException {
        Date bs = toDate("2018-02-01");
        Date be = toDate("2018-02-10");

        calc(bs, be, toDate("2018-01-28"), toDate("2018-01-30"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-01-28"), toDate("2018-01-31"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-01-28"), toDate("2018-02-01"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-01-28"), toDate("2018-02-02"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-01-28"), toDate("2018-02-03"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-01-28"), toDate("2018-02-10"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-01-28"), toDate("2018-02-11"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-01-28"), toDate("2018-03-20"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-02-01"), toDate("2018-02-01"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-02-01"), toDate("2018-02-05"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-02-01"), toDate("2018-02-10"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-02-01"), toDate("2018-02-11"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-02-03"), toDate("2018-02-03"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-02-03"), toDate("2018-02-04"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-02-03"), toDate("2018-02-10"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-02-03"), toDate("2018-02-11"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-02-10"), toDate("2018-02-10"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-02-10"), toDate("2018-02-11"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-02-20"), toDate("2018-02-20"));
        System.out.println("-------------------------------------------");

        calc(bs, be, toDate("2018-02-20"), toDate("2018-02-25"));
        System.out.println("-------------------------------------------");

        System.out.println(111111);

        List<BillDO> r = Lists.newArrayList(
                BillDO.builder().billId(true).sort(1).build(),
                BillDO.builder().billId(null).sort(null).build(),
                BillDO.builder().billId(true).sort(1).build(),
                BillDO.builder().billId(null).sort(null).build(),
                BillDO.builder().billId(true).sort(1).build()
        );

        r.sort((o1, o2) -> {
            Integer v1 = o1.getSort();
            Integer v2 = o2.getSort();

            if (v1 == null) v1 = 2;
            if (v2 == null) v2 = 2;

            return v1.compareTo(v2);
        });

        System.out.println(r);
    }

    private static List<BillDO> calc(Date sourceStartDay, Date sourceEndDay, Date paySt, Date payEt) {
        List<BillDO> result = Lists.newArrayList();

        if (sourceStartDay != null && sourceEndDay != null && sourceStartDay.before(sourceEndDay)
                && paySt != null && payEt != null && !paySt.after(payEt)
                && !payEt.before(sourceStartDay) && !paySt.after(sourceEndDay)) {
            List<Date> days = Lists.newArrayList(DateUtils.addDays(sourceEndDay, 1), paySt, DateUtils.addDays(payEt, 1))
                    .stream()
                    .sorted(Date::compareTo).collect(Collectors.toList());//真正有效的拆分时间点

            Date startDay = sourceStartDay;
            for (Date day : days) {
                Date endDay = DateUtils.addDays(day, -1);

                if (endDay.before(startDay)) continue;

                if (startDay.after(sourceEndDay)) break;

                //result.add(createSimpleBill(source, startDay, endDay, !startDay.before(paySt) && !endDay.after(payEt) ? source.getId() : null));
                result.add(BillDO.builder().billId(!startDay.before(paySt) && !endDay.after(payEt)).e(endDay).s(startDay).build());

                startDay = DateUtils.addDays(endDay, 1);
            }
        } else {
            result.add(BillDO.builder().billId(true).e(sourceEndDay).s(sourceStartDay).build());
        }


        /*List<Date> days = Lists.newArrayList(DateUtils.addDays(billEndDay, 1), paySt, DateUtils.addDays(payEt, 1))
                .stream()
                //.filter(d -> !d.before(billStartDay) && !d.after(billEndDay))
                .sorted(Date::compareTo).collect(Collectors.toList());//真正有效的拆分时间点

        List<BillDO> splitBillList = Lists.newArrayList();

        Date startDay = billStartDay;
        for (Date day : days) {
            Date endDay = DateUtils.addDays(day, -1);

            if (endDay.before(startDay)) {
                continue;
            }

            result.add(BillDO.builder().billId(!startDay.before(paySt) && !endDay.after(payEt)).e(endDay).s(startDay).build());

            startDay = DateUtils.addDays(endDay, 1);
        }*/

        System.out.println(toText(paySt) + ", " + toText(payEt) + ", " + result);

        return result;
    }

    private static Date toDate(String string) throws ParseException {
        return DateUtils.parseDate(string, FORMAT);
    }

    static String toText(Date string) {
        if (string == null) return "";
        return DateFormatUtils.format(string, FORMAT);
    }
}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
class BillDO {
    Date s;
    Date e;
    Boolean billId;
    Integer sort;

    @Override
    public String toString() {
        return "BillDO{" +
                "s=" + Temp.toText(s) +
                ", e=" + Temp.toText(e) +
                ", billId=" + billId +
                '}';
    }
}
