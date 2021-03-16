package mk.finki.ukim.wpproekt;

import mk.finki.ukim.wpproekt.model.Employee;
import mk.finki.ukim.wpproekt.model.Role;
import mk.finki.ukim.wpproekt.model.exception.InvalidUsernameOrPasswordException;
import mk.finki.ukim.wpproekt.model.exception.PasswordsDoNotMatchException;
import mk.finki.ukim.wpproekt.model.exception.UsernameAlreadyExistsException;
import mk.finki.ukim.wpproekt.repository.EmployeeRepository;
import mk.finki.ukim.wpproekt.service.EmployeeService;
import mk.finki.ukim.wpproekt.service.serviceImpl.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    private EmployeeService employeeService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        Employee employee = new Employee("name", "surname", "username", "password", Role.ROLE_USER);
        Mockito.when(this.employeeRepository.save(Mockito.any(Employee.class))).thenReturn(employee);
        Mockito.when(this.passwordEncoder.encode(Mockito.anyString())).thenReturn("password");

        this.employeeService = Mockito.spy(new EmployeeServiceImpl(this.employeeRepository));
    }

    @Test
    public void testSuccessRegister(){
        Employee employee = this.employeeService.register("username", "password", "password", "name", "surname", Role.ROLE_USER);
        Mockito.verify(this.employeeService).register("username", "password", "password", "name", "surname", Role.ROLE_USER);

        Assert.assertNotNull("User is null", employee);
        Assert.assertEquals("Name do not match", "name", employee.getName());
        Assert.assertEquals("Role do not match", Role.ROLE_USER, employee.getRole());
        Assert.assertEquals("Surname do not match", "surname", employee.getSurname());
        Assert.assertEquals("Username do not match", "username", employee.getUsername());
        Assert.assertEquals("Password do not match", "password", employee.getPassword());

    }

    @Test
    public void testNullPassword(){
        String username = "username";
        String password = null;

        Assert.assertThrows("InvalidUsernameOrPasswordException expected", InvalidUsernameOrPasswordException.class, () ->
                this.employeeService.register(username, password, "password", "name", "surname", Role.ROLE_USER));
        Mockito.verify(this.employeeService).register(username, password, "password", "name", "surname", Role.ROLE_USER);
    }

    @Test
    public void testNullusername(){
        String username = null;

        Assert.assertThrows("InvalidUsernameOrPasswordException, expected", InvalidUsernameOrPasswordException.class, () ->
                this.employeeService.register(username, "password", "password", "name", "surname", Role.ROLE_USER));
        Mockito.verify(this.employeeService).register(username,"password", "password", "name", "surname", Role.ROLE_USER);
    }

    @Test
    public void testEmptyUsername(){
        String username = "";

        Assert.assertThrows("InvalidUsernameOrPasswordException expected", InvalidUsernameOrPasswordException.class, () ->
                this.employeeService.register(username, "password", "password", "name", "surname", Role.ROLE_USER));
        Mockito.verify(this.employeeService).register(username, "password", "password", "name", "surname", Role.ROLE_USER);
    }

    @Test
    public void testEmptyPassword(){
        String username = "username";
        String password = "";

        Assert.assertThrows("InvalidUsernameOrPasswordException expected", InvalidUsernameOrPasswordException.class, () ->
                this.employeeService.register(username, password, "password", "name", "surname", Role.ROLE_USER));
        Mockito.verify(this.employeeService).register(username,password, "password", "name", "surname", Role.ROLE_USER);
    }

    @Test
    public void testPasswordMismatch(){
        String username = "username";
        String password = "password";
        String confirmPassword = "otherPassword";

        Assert.assertThrows("PasswordDoNotMatchException expected", PasswordsDoNotMatchException.class, () ->
                this.employeeService.register(username, password, confirmPassword, "name", "surname", Role.ROLE_USER));
        Mockito.verify(this.employeeService).register(username, password, confirmPassword, "name", "surname", Role.ROLE_USER);
    }

    @Test
    public void testDuplicateUsername() {
        Employee employee = new Employee("name", "surname", "username", "password", Role.ROLE_USER);
        Mockito.when(this.employeeRepository.findByUsername(Mockito.anyString())).thenReturn(Optional.of(employee));
        String username = "username";
        Assert.assertThrows("UsernameAlreadyExistsException expected",
                UsernameAlreadyExistsException.class,
                () -> this.employeeService.register(username, "password", "password", "name", "surename", Role.ROLE_USER));
        Mockito.verify(this.employeeService).register(username, "password", "password", "name", "surename", Role.ROLE_USER);
    }

}
