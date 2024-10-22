public static final int NUMBER_OF_TASKS = 34;
public static final int REAL_DAYS_PER_IDEAL_DAY = 4;
public static final int WORK_DAYS_PER_WEEK = 5;

int sum = 0;
int[] taskEstimate = new int[NUMBER_OF_TASKS];

// taskEstimate에 값을 채우는 로직이 있을 것

for (int j = 0; j < NUMBER_OF_TASKS; j++) {
  int realTaskDays = taskEstimate[j] * REAL_DAYS_PER_IDEAL_DAY;
  int realTaskWeeks = (realTaskDays / WORK_DAYS_PER_WEEK);
  sum += realTaskWeeks
}