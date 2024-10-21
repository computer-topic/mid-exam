public static final REAL_DAYS_PER_IDEAL_DAY = 4;
public static final WORK_DAYS_PER_WEEK = 5;
public static final NUMBER_OF_TASKS = 34;
int sum = 0;

for (int j = 0; j < NUMBER_OF_TASKS; j++) {
  const realTaskDays = taskEstimate[j] * REAL_DAYS_PER_IDEAL_DAY;
  int realTaskWeeks= realTaskDays / WORK_DAYS_PER_WEEK;
  sum += realTaskWeeks;
}