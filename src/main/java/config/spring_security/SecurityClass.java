package config.spring_security;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

@Component
public class SecurityClass {
    //доступ только с ролью 'admin' без этой роли будет ошибка 403
    @Secured("ROLE_admin")
    public void securityMetod() {
        System.out.println("Security method");
    }
}
