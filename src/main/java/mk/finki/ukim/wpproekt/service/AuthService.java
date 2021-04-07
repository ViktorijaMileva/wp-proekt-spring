package mk.finki.ukim.wpproekt.service;

import mk.finki.ukim.wpproekt.model.Employee;

public interface AuthService {
    Employee login(String username, String password);
}
