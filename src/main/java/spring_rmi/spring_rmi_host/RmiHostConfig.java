package spring_rmi.spring_rmi_host;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

@Configuration
public class RmiHostConfig {

    @Bean
    public RmiService getService() {
        return new RmiServiceImpl();
    }


    @Bean
    public RmiServiceExporter getRmiServiceExporter(RmiService rmiService) {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();

        rmiServiceExporter.setService(rmiService);
        rmiServiceExporter.setServiceName("rmiServiceName");
        rmiServiceExporter.setServiceInterface(RmiService.class);

        // опционально
        // rmiServiceExporter.setRegistryHost("HOST");
        // rmiServiceExporter.setRegistryPort(8090);

        return rmiServiceExporter;
    }

}
