package factory.before;

import java.io.*;
import java.util.*;

import factory.after.FIFOCustomerService;
import factory.after.SJFCustomerService;

public class Main {
    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }

    static Customer[] customers = new Customer[] {
        new Customer("이영주", 0L, 1L),
        new Customer("이종찬", 2L, 12L),
        new Customer("장호윤", 5L, 5L),
        new Customer("문찬욱", 6L, 6L),
        new Customer("김찬규", 7L, 3L),
        new Customer("손민우", 9L, 1L),
        new Customer("송예진", 10L, 3L)
    };


    public static void main(String[] args){
        FastReader fr = new FastReader();

        while (true) {
            System.out.println("먼저온 고객을 먼저 서비스 하려면 F, 수리시간이 짧은 고객을 먼저 서비스 하려면 S를 입력하세요. \n 끝내려면 Q를 입력하세요.");
            String command = fr.next();
            if (command.equalsIgnoreCase("F")) {
                FIFOCustomerService fifoCustomerService = new FIFOCustomerService();
                LinkedList<Customer> customerLinkedList = new LinkedList<>(fifoCustomerService.collection);
                customerLinkedList.addAll(fifoCustomerService.from(customers));
                Collections.sort(customerLinkedList, fifoCustomerService.comparator);


                while (!customerLinkedList.isEmpty()) {
                    Customer customer = customerLinkedList.removeFirst();
                    System.out.println(fifoCustomerService.gatherCustomerData(customer));
                    fifoCustomerService.totalWaitTime += customer.getWaitTime();
                    fifoCustomerService.increaseTime(customer);
                }

                System.out.println("총 기다린 시간:" + fifoCustomerService.totalWaitTime + "분");
            } else if (command.equalsIgnoreCase("S")) {
                SJFCustomerService sjfCustomerService = new SJFCustomerService();
                PriorityQueue<Customer> customerPriorityQueue = new PriorityQueue<>(sjfCustomerService.comparator);
                customerPriorityQueue.addAll(sjfCustomerService.from(customers));

                while (!customerPriorityQueue.isEmpty()) {
                    Customer customer = customerPriorityQueue.poll();
                    System.out.println(sjfCustomerService.gatherCustomerData(customer));
                    sjfCustomerService.totalWaitTime += customer.getWaitTime();
                    sjfCustomerService.increaseTime(customer);
                }

                System.out.println("총 기다린 시간:" + sjfCustomerService.totalWaitTime + "분");
            } else {
                break;
            }

            System.out.println();
        }
    }
}
