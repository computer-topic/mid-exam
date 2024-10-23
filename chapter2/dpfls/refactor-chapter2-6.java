public static final NUMBER_OF_TASKS = 34;
public static final REAL_DAYS_PER_IDEAL_DAY = 4;
public static final WORK_DAYS_PER_WEEK = 5;
int sum = 0;

for (int i = 0; j < NUMBER_OF_TASKS; j++) {
    int realTaskDays = taskEstimate[i] * REAL_DAYS_PER_IDEAL_DAY;
    int realTaskWeeks = realTaskDays / WORK_DAYS_PER_WEEK;
    sum += realTaskWeeks;
}