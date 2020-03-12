package com.example;

import java.util.HashSet;

public class CreateMemoryLeak {
	public static void main(String[] args) {
			HashSet<Employee> employees = new HashSet<>();
			while (true) {
				Employee jack = new Employee("1", "Jack Bauer");
				employees.add(jack);
				System.out.println(employees.contains(jack));
			}
	}
}

class Employee extends Object {
	private String identity;
	private String fullname;

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	public Employee(String identity, String fullname) {
		this.identity = identity;
		this.fullname = fullname;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identity == null) ? 0 : identity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (identity == null) {
			if (other.identity != null)
				return false;
		} else if (!identity.equals(other.identity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [identity=" + identity + ", fullname=" + fullname + "]";
	}

}
