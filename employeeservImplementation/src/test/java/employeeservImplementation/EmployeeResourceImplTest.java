package employeeservImplementation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.impl.EmployeeResourceImpl;
import com.paypal.bfs.test.employeeserv.repository.EmployeeRepository;

public class EmployeeResourceImplTest {
	EmployeeResourceImpl empl; 
	
	@Mock
	EmployeeRepository empRepo;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		empl =  new EmployeeResourceImpl(); 

	}

 
	@Test
	public void testEmployeeGetById() {
 
		when(empRepo.findById(2)).thenReturn(null);
		assertNull(empl.employeeGetById("2"));
	}

	@Test
	public void testCreateOrUpdateEmployee() {
		Employee employee = new Employee();
		employee.setFirstName("demo");
		employee.setLastName("demo2");
		employee.setDateOfBirth("02/10/2020");
		
		assertNotNull(empl.createOrUpdateEmployee(employee));
	}

}
