import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static boolean canFinish(int numberOfCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] incomingEdges = new int[numberOfCourses];

        for (int course = 0; course < numberOfCourses; course++) {
            graph.add(new ArrayList<>());
        }

        if (prerequisites != null) {
            for (int[] prerequisite : prerequisites) {
                if (prerequisite == null || prerequisite.length < 2) {
                    continue;
                }

                int course = prerequisite[0];
                int requiredCourse = prerequisite[1];

                if (course < 0 || course >= numberOfCourses
                        || requiredCourse < 0 || requiredCourse >= numberOfCourses) {
                    continue;
                }

                graph.get(requiredCourse).add(course);
                incomingEdges[course]++;
            }
        }

        Queue<Integer> readyCourses = new ArrayDeque<>();

        for (int course = 0; course < numberOfCourses; course++) {
            if (incomingEdges[course] == 0) {
                readyCourses.offer(course);
            }
        }

        int completedCourses = 0;

        while (!readyCourses.isEmpty()) {
            int currentCourse = readyCourses.poll();
            completedCourses++;

            for (int nextCourse : graph.get(currentCourse)) {
                incomingEdges[nextCourse]--;

                if (incomingEdges[nextCourse] == 0) {
                    readyCourses.offer(nextCourse);
                }
            }
        }

        return completedCourses == numberOfCourses;
    }
}
