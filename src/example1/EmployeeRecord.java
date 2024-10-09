package example1;

import java.util.Objects;

public class EmployeeRecord {
    public EmployeeRecord(int id, String firstName) {
		super();
		this.id = id;
		this.firstName = firstName;
	}
	@Override
	public String toString() {
		return "EmployeeRecord [id=" + id + ", firstName=" + firstName + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(firstName, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeRecord other = (EmployeeRecord) obj;
		return Objects.equals(firstName, other.firstName) && id == other.id;
	}
	private int id;
    private String firstName;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
