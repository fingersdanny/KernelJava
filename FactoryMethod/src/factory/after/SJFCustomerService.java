package factory.after;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import factory.before.Customer;

public class SJFCustomerService extends CustomerService {
	public Long currentTime = super.currentTime;
	public Long totalWaitTime = super.totalWaitTime;
	public SJFCustomerService() {
		this.collection = new PriorityQueue();
		this.comparator = Comparator
			.comparing(Customer::getFixTime)
			.thenComparing(Customer::getArrivedAt);
	}

	@Override
	public void increaseTime(Customer customer) {
		this.currentTime = this.currentTime >= customer.getArrivedAt() ? this.currentTime : customer.getArrivedAt();
		this.currentTime += customer.getFixTime();
	}

	@Override
	public String gatherCustomerData(Customer customer) {
		Long waitTime = this.currentTime >= customer.getArrivedAt() ? this.currentTime - customer.getArrivedAt() : 0;
		String calcTime = "분, 서비스 시작시간: "
			+ (this.currentTime >= customer.getArrivedAt() ? this.currentTime : customer.getArrivedAt())
			+ "분, 기다린 시간: " + waitTime +"분";
		customer.setWaitTime(waitTime);
		return customer.toString() + calcTime;
	}

	@Override
	public ArrayList<Customer> from(Customer[] customers) {
		return super.from(customers);
	}
}
