package test;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest3 {
   public static void main(String[] args) {
      TreeSet<Integer> tset = new TreeSet<>();
      tset.add(56);
      tset.add(78);
      tset.add(98);
      tset.add(65);
      tset.add(69);
      tset.add(77);
      tset.add(98);
      tset.add(87);
      
      System.out.println(tset);  //[56, 65, 69, 77, 78, 87, 98] -> 정렬되어 출력
      
      SortedSet<Integer> hset = tset.headSet(90);  //[56, 65, 69, 77, 78, 87] -> 90 앞에 있는 걸 가져옴
      System.out.println(hset);
      SortedSet<Integer> tailSet = tset.tailSet(90); // 90보다 크거나 같은 것
      System.out.println(tailSet);
      SortedSet<Integer> subSet = tset.subSet(80, 90); // 1보다 크고 2보다 작은 거
      System.out.println(subSet);
      
   }
}