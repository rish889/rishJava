package org.rish889.inte.gsci;

import java.util.*;
import java.util.stream.Collectors;

public class Solutiond1q2 {
    public static void main(String[] args) {
        Solutiond1q2 sol = new Solutiond1q2();
        System.out.println(sol.maxAverageGrade(List.of(
                new StudentGrade("Bobby", 87),
                new StudentGrade("Charles", 100),
                new StudentGrade("Eric", 64),
                new StudentGrade("Charles", 22)
        )));

        System.out.println(sol.maxAverageGrade(List.of(
                new StudentGrade("Bill", 90),
                new StudentGrade("Paul", 50),
                new StudentGrade("Will", 78),
                new StudentGrade("Jack", 82)
        )));
    }

    public double maxAverageGrade(List<StudentGrade> grades) {
        if (Objects.isNull(grades) || grades.isEmpty()) {
            return -1;
        }
        return grades.stream()
                .collect(Collectors.groupingBy(sg -> sg.name, Collectors.averagingInt(sg -> sg.grade)))
                .values()
                .stream()
                .max(Comparator.comparingDouble(g -> g))
                .get();
    }

    record StudentGrade(String name, int grade) {
    }
}

