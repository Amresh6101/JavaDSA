package org.epam.dsa.map;
import java.util.*;
import java.util.stream.Collectors;

public class SortMap {
    public static void main(String[] args) {
        Map<Integer,String> map1=new HashMap<>();
        map1.put(2,"raju");
        map1.put(1,"anish");
        map1.put(3,"sashnak");
        map1.put(8,"naruto");
        map1.put(5,"sourabh");
        map1.put(4,"roy");
        //System.out.println("Before sorting");
        System.out.println("Unsorted map:"+map1);
        // sort on the basics of value before java-1.8

        // store entry value into the list
        List<Map.Entry<Integer,String>> list1= new ArrayList<>(map1.entrySet());
        Collections.sort(list1,(entry1,entry2)->{
            return entry1.getValue().compareTo(entry2.getValue());
        });
        // list of entry get sorted store this value into a linkedHashMap
        Map<Integer,String> sortedMap=new LinkedHashMap<>();
        for(Map.Entry<Integer,String> e1: list1){
            sortedMap.put(e1.getKey(), e1.getValue());
        }
        System.out.println("Sorted Map:"+ sortedMap);

        // sort using stream

        Map<Integer,String> streamSortMap= map1
                .entrySet()
                .stream()
                .sorted((entry1,entry2)-> entry1.getValue().compareTo(entry2.getValue()))
                .collect(Collectors.toMap(e1->e1.getKey(),e2->e2.getValue(),(oldVal,newVal)->newVal,()->new LinkedHashMap<>()));

        System.out.println("Sort Map using stream api:"+streamSortMap);


        Map<Integer,String> streamSortMap2= map1
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(e1->e1.getKey(),e2->e2.getValue(),(oldVal,newVal)->newVal,()->new LinkedHashMap<>()));

        System.out.println("Sort map using comapringByValue function:"+ streamSortMap2);

        Map<Integer,String> streamSortMap3= map1
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(e1->e1.getKey(),e2->e2.getValue(),(oldVal,newVal)->newVal,()->new LinkedHashMap<>()));

        System.out.println("Sort map using comapringByKey function:"+ streamSortMap3);

    }
}
