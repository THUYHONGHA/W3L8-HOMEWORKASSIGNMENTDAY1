package problem1;

public class Person {
	private String lastName;
	private String firstName;
	private int age;

	// --------------------------------------------------------------
	public Person(String last, String first, int a) { // constructor
		lastName = last;
		firstName = first;
		age = a;
	}

	// --------------------------------------------------------------
	public String getLast() // get last name
	{
		return lastName;
	}

	@Override
	public String toString() {
		return "Person [lastName=" + lastName + " FirstName=" + firstName + " Age=" + age + "]";
	}

	@Override
	public boolean equals(Object ob) {
		if (ob == null)
			return false;
		if (ob.getClass() != this.getClass())
			return false;
		Person p = (Person) ob;
		boolean isEqual = p.firstName.equals(this.firstName) && p.lastName.equals(this.lastName) && p.age == this.age;
		return isEqual;
	}

}
