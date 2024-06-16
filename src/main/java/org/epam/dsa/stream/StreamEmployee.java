package org.epam.dsa.stream;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamEmployee {
    public static void main(String[] args) {
        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020));
        empList.add(new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015));
        empList.add(new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014));
        empList.add(new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013));

        empList.add(new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013));
        empList.add(new Employee(6, "mno", 27, 140, "M", "IT", "Gurugram", 2017));
        empList.add(new Employee(7, "uvw", 26, 130, "F", "IT", "Pune", 2016));
        empList.add(new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015));
        empList.add(new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010));


        // Group the Employees by city.
        Map<String,List<Employee>> cityStreamMap =empList.stream().map(emp->emp).collect(Collectors.groupingBy(emp->emp.getCity()));
        System.out.println("Group by city:"+ cityStreamMap);

        // Group the Employees by age.
        Map<Integer,List<Employee>> empAges =empList.stream().map(emp->emp).collect(Collectors.groupingBy(emp->emp.getAge()));
        System.out.println("Group by Age:"+ empAges);

        // Find the count of male and female employees present in the organization.
        Map<String,Long> countofGender=empList.stream().map(emp->emp).collect(Collectors.groupingBy(emp->emp.getGender(),Collectors.counting()));
        System.out.println("Count of male and female:"+countofGender);

        //Print the names of all departments in the organization.
        List<String> nameOfDepartment=empList.stream().map(emp->emp.getDeptName()).distinct().collect(Collectors.toList());
        System.out.println("Name of All Department:"+nameOfDepartment);

        // Print employee details whose age is greater than 28.
        List<Employee> empDetails=empList.stream().filter(emp->emp.getAge()>28).collect(Collectors.toList());
        System.out.println("Employee details age greater than 28:"+ empDetails);

        // Find maximum age of employee.
        System.out.println("Max age of employees:"+
                empList.stream().mapToInt(emp->emp.getAge()).max().getAsInt()
        );

        //Print Average age of Male and Female Employees.
        System.out.println("Average age of Male and Female Employees."+
              //empList.stream().filter(emp->emp.getGender().equals('F')).mapToInt(emp->emp.getAge()).collect(Collectors.averagingInt(emp->emp))
                empList.stream().collect(Collectors.groupingBy(emp->emp.getGender(),Collectors.averagingInt(emp-> emp.getAge())))
        );

        // Print the number of employees in each department.

        System.out.println("Number of employees in each department:"+
                empList.stream().map(emp->emp)
                        .collect(Collectors.groupingBy(emp->emp.getDeptName(),Collectors.counting()))
        );

        //Find oldest employee.
        System.out.println("Oldest employee:"+
                empList.stream().sorted((emp1,emp2)-> -Integer.compare(emp1.getAge(), emp2.getAge())).findFirst()
        );

        //Find youngest female employee.
        System.out.println(
                empList.stream().filter(emp1->emp1.getGender().equals("F")).collect(Collectors.maxBy((emp1,emp2)-> -Integer.compare(emp1.getAge(),emp2.getAge()))).get()
        );

        // Find employees whose age is greater than 30 and less than 30.
        // us partitionBy
        // note groupBy and partitionBy both return map
        // partitionBy predicate leta hai ek return type boolean hota hai

        Map<Boolean, List<Employee>> ageMap= empList.stream().map(emp->emp).collect(Collectors.partitioningBy(emp1->emp1.getAge()>30));
        for(Map.Entry<Boolean,List<Employee>> emp1: ageMap.entrySet()){
            boolean ageGroup=emp1.getKey();
            if(ageGroup){
                System.out.println("Employees greater than 30 years::" + emp1.getValue());
            }
            else {
                System.out.println("Employees less than 30 years::" + emp1.getValue());
            }
        }
// note important ======================================================================================================
        //Find the department name which has the highest number of employees.
         Map.Entry<String,Long> empNumInDept= empList.stream().collect(Collectors.groupingBy(emp1->emp1.getDeptName(),Collectors.counting()))
                 .entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println(empNumInDept.getKey());
//        List<Map.Entry<String,Long>> sortEmp= new ArrayList<>(empNumInDept.entrySet());
//        Collections.sort(sortEmp,(entry1,entry2)-> - Long.compare(entry1.getValue(),entry2.getValue()));
//        Map<String,Long> sortEmpCountDept= new LinkedHashMap<>();
//        for(Map.Entry<String,Long> e1: sortEmp){
//            sortEmpCountDept.put(e1.getKey(), e1.getValue());
//        }
 //       System.out.println("department name which has the highest number of employees:"+sortEmpCountDept);
//        Map<String,Long> sortEmpCountDept= empNumInDept
//                .entrySet()
//                .stream()
//                .sorted((entry1,entry2)-> - Long.compare(entry1.getValue(),entry2.getValue()))
//                .limit(1)
//                .collect(Collectors.toMap(e1->e1.getKey(),e2-> e2.getValue(),(oldV,newV)->newV,LinkedHashMap::new));
        //System.out.println("department name which has the highest number of employees:"+sortEmpCountDept);

        // method-2
        Map.Entry<String, Long> maxNoOfEmployeesInDept = empList.stream().collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).
                entrySet().stream().max(Map.Entry.comparingByValue()).get();
        System.out.println("Max no of employees present in Dept :: " + maxNoOfEmployeesInDept.getKey());

        // Find if there any employees from HR Department.

        System.out.println("Found employees from HR department:"+
                empList.stream().filter(emp1->emp1.getDeptName().equals("HR")).count()
        );
//        Optional<Employee> emp = empList.stream().filter(e -> e.getDeptName().equalsIgnoreCase("HR"))
//                .findAny();
//        emp.ifPresent(employee -> System.out.println("Found employees from HR department " + employee));

        // Find the department names that these employees work for, where the number of employees in the department is over 3.
        System.out.println(
                "Department names where the number of employees in the department is over 3 ::"+
                empList.stream().collect(Collectors.groupingBy(emp1->emp1.getDeptName(),Collectors.counting()))
                        .entrySet().stream().filter(entry1->entry1.getValue()>3).collect(Collectors.toList())
        );

        // Find distinct department names that employees work for.
        System.out.println(
                "distinct department names that employees work for::"+
                        empList.stream().map(emp->emp.getDeptName()).distinct().collect(Collectors.toList())
        );

        // Find all employees who lives in ‘Blore’ city, sort them by their name and print the names of employees.
        System.out.println("employees who lives in Blore::");
        empList.stream().filter(emp1->emp1.getCity().equals("Blore"))
        .sorted((emp1,emp2)-> emp1.getName().compareTo(emp2.getName()))
        .forEach(emp-> System.out.println(emp.getName()));

        // No of employees in the organisation.
        System.out.println( "No of employees in the organisation:"+
                empList.stream()
                        .count()
        );

        //  Sorting a Stream by age and name fields.
        System.out.println("Sorting based on name and age:: ");
        Comparator<Employee> comparator1 = Comparator.comparing(Employee::getName);
        Comparator<Employee> comparator2 = Comparator.comparingInt(Employee::getAge);
        empList.stream().sorted(comparator1.thenComparing(comparator2)).forEach(System.out::println);

        // Print average and total salary of the organization.
        System.out.println(
                "Total salary of the organization::"+
                        empList.stream().mapToLong(emp1-> emp1.getSalary()).sum()
        );
        System.out.println(
                "Average salary of the organization::"+
                        empList.stream().mapToLong(emp1-> emp1.getSalary()).average().getAsDouble()
        );

        DoubleSummaryStatistics doubleSummaryStatistics=empList.stream().collect(Collectors.summarizingDouble(emp1-> emp1.getSalary()));
        System.out.println("Total Salary:"+doubleSummaryStatistics.getSum());
        System.out.println("Average Salary:"+doubleSummaryStatistics.getAverage());

       // Print Average salary of each department.
        System.out.println("Average salary of each department."+
                 empList.stream()
                         .collect(Collectors.groupingBy(emp->emp.getDeptName(),Collectors.averagingDouble(emp-> emp.getSalary())))
        );

        // Find Highest salary in the organisation.
        System.out.println("Highest salary in the organisation::"+
                empList.stream()
                        .collect(Collectors.maxBy((emp1,emp2)-> Double.compare(emp1.getSalary(),emp2.getSalary())))
                        .get()
        );

        // Second Highest Salary in the organisation
        Optional<Employee> emp2 = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary)
                .reversed()).skip(1).findFirst();
        System.out.println("Second Highest Salary in the organisation : " + emp2.get().getSalary());





    }
}