package ex4_2;

/**
 * 2theme
 * exercise4_2
 * @author Vitalii Reshetnyk
 */public class ex4_2 {
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static void main(String[] args)
    {
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int totalDays = 0;
        int maxGap = 0;
        int prevDayOfWeek = 0;
        int prevTotalDays = 0;

        for (int year = 1; year <= 400; year++) {
            for (int month = 0; month < 12; month++) {
                int days = daysInMonth[month];
                if (month == 1 && isLeapYear(year)) {
                    days += 1;
                }

                for (int day = 1; day <= days; day++) {
                    totalDays += 1;
                    int dayOfWeek = (prevDayOfWeek + 1) % 7;

                    if (day == 13 && dayOfWeek == 4) {
                        if (prevDayOfWeek != 0) {
                            int gap = totalDays - prevTotalDays;
                            maxGap = Math.max(maxGap, gap);
                        }
                        prevTotalDays = totalDays;
                    }
                    prevDayOfWeek = dayOfWeek;
                }
            }
        }

        maxGap -= 1;
        System.out.println("The maximum number of days between two Friday13 in a 400-year interval is: " + maxGap + " days.");
    }


}
