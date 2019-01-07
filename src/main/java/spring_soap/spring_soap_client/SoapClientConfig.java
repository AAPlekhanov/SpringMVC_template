package spring_soap.spring_soap_client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.JaxWsPortProxyFactoryBean;
import spring_soap.spring_soap_service.SoapSercice;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * настройки для клиента spring soap
 */

@Configuration
public class SoapClientConfig {

     @Bean
     public JaxWsPortProxyFactoryBean getPortProxyFactoryBean() throws MalformedURLException {

        JaxWsPortProxyFactoryBean jaxWsPortProxyFactoryBean = new JaxWsPortProxyFactoryBean();
        jaxWsPortProxyFactoryBean.setWsdlDocumentUrl(new URL("http://localhost:8889/SoapService?wsdl"));
        jaxWsPortProxyFactoryBean.setServiceName("SoapService");
        jaxWsPortProxyFactoryBean.setServiceInterface(SoapSercice.class);
        // данные из wsdl
        jaxWsPortProxyFactoryBean.setNamespaceUri("http://spring_soap_service.spring_soap/"); // targetNamespace="http://spring_soap/"
        jaxWsPortProxyFactoryBean.setPortName("SoapServiceEndpointPort"); // port name="SoapServiceEndpointPort"

        return jaxWsPortProxyFactoryBean;
    }
}
