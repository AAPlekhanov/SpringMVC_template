package spring_rmi.spring_rmi_client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import spring_rmi.spring_rmi_host.RmiService;

@Configuration
public class RmiClientConfig {


    @Bean
    public RmiProxyFactoryBean getRmiProxyFactoryBean() {

        RmiProxyFactoryBean rmiProxyFactoryBean = new RmiProxyFactoryBean();
        // указываем удалённый URL и имя сервиса
        rmiProxyFactoryBean.setServiceUrl("rmi://localhost/rmiServiceName");
        rmiProxyFactoryBean.setServiceInterface(RmiService.class);

        return rmiProxyFactoryBean;
    }
}
