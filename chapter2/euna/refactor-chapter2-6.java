public static final int NUMBER_OF_TASKS = 34;
public static final int REAL_DAYS_PER_IDEAL_DAY = 4;
public static final int WORK_DAYS_PER_WEEK = 5;

int sum = 0;
int[] taskEstimate = new int[NUMBER_OF_TASKS];

for (int j = 0; j < NUMBER_OF_TASKS; j++) {
  int realTaskDays = taskEstimate[j] * realDaysPerIdealDay;
  int realTaskWeeks = (realTaskDays / WORK_DAYS_PER_WEEK);
  sum += (t[j] * REAL_DAYS_PER_IDEAL_DAY) / WORK_DAYS_PER_WEEK;
}