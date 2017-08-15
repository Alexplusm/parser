package mypackage.model;

/**
 * Created by ASMogilevsky on 31.07.2017.
 */
public class MyDate {
    private Integer hrs;
    private Integer min;
    private Integer sec;
    private Integer msec;

    private Boolean dateIsNull;

    // example of input: 11:51:04,887
    public MyDate(String str) {
        if (str == "") {
            this.dateIsNull = true;
            this.hrs = 0;
            this.min = 0;
            this.sec = 0;
            this.msec = 0;
        }else {
            try {
                String s1[];
                String s2[];
                // разбиваем строку "11:51:04,887" на [11 ; 51 ; 04,887]
                s1 = str.split(":");
                //разбиваем строку "04,887" на [04 ; 887]
                s2 = s1[2].split(",");

                this.dateIsNull = false;
                this.hrs = Integer.parseInt(s1[0]);
                this.min = Integer.parseInt(s1[1]);
                this.sec = Integer.parseInt(s2[0]);
                this.msec = Integer.parseInt(s2[1]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean thisDateIsNull(){
        return this.dateIsNull;
    }

    public int getHours() {
        return this.hrs;
    }

    public int getMinutes() {
        return this.min;
    }

    public int getSeconds() {
        return this.sec;
    }

    public int getMiliSecons() {
        return this.msec;
    }


    //todo сделать красивее
    public void printMyDate() {
        int[] arr = {hrs, min, sec, msec};
        for(int i: arr) {
            System.out.print(i + ":");
        }
    }

    /**
     *  Сравнивает две даты:
     *  Если первая дата "больше", то возвращает true,
     *  иначе false
     *
     *  firstData.dataCompare(secondData)
     *
     * @param date
     * @return
     */
    public Boolean dateCompare (MyDate date) {
            if (this.hrs > date.getHours()) {
                return true;
            } else if ((this.hrs == date.getHours())
                    && (this.min > date.getMinutes())) {
                return true;
            } else if ((this.hrs == date.getHours())
                    && (this.min == date.getMinutes())
                    && (this.sec > date.getSeconds())) {
                return true;
            } else if ((this.hrs == date.getHours())
                    && (this.min == date.getMinutes())
                    && (this.sec == date.getSeconds())
                    && (this.msec > date.getMiliSecons())) {
                return true;
            } else {
                return false;
            }
    }
}
