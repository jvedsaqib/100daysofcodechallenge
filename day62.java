import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

/*
 * Create the Student and Priorities classes here.
 */
class Student {
    String name;
    int id;
    double cgpa;

    Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public Integer getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getCgpa() {
        return cgpa;
    }
}

class StudentCompare implements Comparator<Student> {
    @Override
    public int compare(Student student2, Student student1) {
        int CgpaCompare = student1.getCgpa().compareTo(student2.getCgpa());
        int NameCompare = student2.getName().compareTo(student1.getName());
        int IDCompare = student2.getID().compareTo(student1.getID());
        if (CgpaCompare == 0) {
            if (NameCompare == 0) {
                return IDCompare;
            } else {
                return NameCompare;
            }
        } else {
            return CgpaCompare;
        }
    }
}

class Priorities {
    List<Student> getStudents(List<String> events) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < events.size(); i++) {
            String[] strings = new String[1];
            strings = events.get(i).split(" ");
            if (events.get(i).split(" ")[0].equals("SERVED")) {
                if (list.size() != 0) {
                    Collections.sort(list, new StudentCompare());
                    list.remove(0);
                }
            } else {
                list.add(new Student(Integer.parseInt(strings[3]), strings[1], Double.parseDouble(strings[2])));
            }
        }
        return list;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}
