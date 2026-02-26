package org.example.ApiCoding;

import java.util.PriorityQueue;

public class priorityqueue {

    public static void main(String[] args) {

        PriorityQueue<Task> queue=new PriorityQueue<>();
        queue.offer(new Task("low priority task",34));
        queue.offer(new Task("high priority task",19));
        queue.offer(new Task("medium priority task",9));
        System.out.println("proccessing by tasks");

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }

    }
   static class Task implements Comparable<Task>{
            String name;
            int priority;

        public Task(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        @Override
        public int compareTo(Task other) {
            return Integer.compare(this.priority,other.priority);
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", priority=" + priority +
                    '}';
        }
    }


}
