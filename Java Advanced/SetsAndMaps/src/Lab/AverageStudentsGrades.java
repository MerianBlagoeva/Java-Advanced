package Lab;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int studentsCount = Integer.parseInt(sc.nextLine());
        Map<String, List<Double>> studentsGrades = new TreeMap<>();
        Map<String, Double> averageGrades = new LinkedHashMap<>();

        for (int i = 0; i < studentsCount; i++) {
            String[] info = sc.nextLine().split("\\s+");
            String name = info[0];
            double grade = Double.parseDouble(info[1]);



            studentsGrades.putIfAbsent(name, new ArrayList<>());
            studentsGrades.get(name).add(grade);

        }

//        for (Map.Entry<String, List<Double>> entry : studentsGrades.entrySet()) {
//            double avg = entry.getValue().stream()
//                    .mapToDouble(Double::doubleValue)
//                    .average()
//                    .getAsDouble();
//
//            averageGrades.put(entry.getKey(), avg);
//        }


        studentsGrades.forEach((key, value) -> {
            double sum = 0;
            for (Double aDouble : value) {
                sum += aDouble;
            }
            double avg = sum / value.size();

            System.out.print(key + " -> ");
            value.forEach(e -> System.out.printf("%.2f ", e));
            System.out.printf("(avg: %.2f)%n", avg);
        });

//        for (Map.Entry<String, List<Double>> entry : studentsGrades.entrySet()) {
//            System.out.print(entry.getKey() + " -> ");
//            entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
//            System.out.printf("(avg: %.2f)%n", averageGrades.get(entry.getKey()));
//        }
    }
}
