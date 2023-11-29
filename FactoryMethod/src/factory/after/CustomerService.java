package factory.after;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

import factory.before.Customer;

public abstract class CustomerService {
	public Collection<Customer> collection;
	public Comparator comparator;
	public Long currentTime = 0L;
	public Long totalWaitTime = 0L;

	public abstract String gatherCustomerData(Customer customer);

	public abstract void increaseTime(Customer customer);

	public ArrayList<Customer> from(Customer[] customers) {
		return Arrays.stream(customers).collect(Collectors.toCollection(ArrayList::new));
	};
}
