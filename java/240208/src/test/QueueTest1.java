package test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest1 {
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(10); // enqueue
		queue.offer(20);
		queue.offer(30);
		
		System.out.println(queue.peek()); // 맨 앞에 있는 데이터를 가져옴.
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll()); // dequeue 큐 반환 메소드
		}
		
		System.out.println(queue.size());
	}
}
