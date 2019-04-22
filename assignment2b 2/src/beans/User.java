package beans;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.NotNull;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Size;

@ManagedBean
@ViewScoped
public class User {
	
	@NotNull(message = "Please enter a First Name. This is a required field.")
	@Size(min=2, max=15)
	String firstName = "";
	
	@NotNull(message = "please enter a Last Name. This is a required field.")
	@Size(min=2, max=15)
	String lastName= "";
	
	public User() 
	{
		firstName = "Mann";
		
		
		lastName = "Jaiswal";
	}
	public User(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
//String firstName = "Mann";
//String lastName = "Jaiswal";
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
}
