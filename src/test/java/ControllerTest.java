import com.mysql.cj.x.protobuf.Mysqlx;
import config.AppInit;
import config.MyWebConfig;
import controllers.FormController;
import controllers.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;


//  тест post c параметрами
//  тест контроллера возврщаещего view , ( не регестриуется viewResolver

@RunWith(SpringRunner.class)
@ContextConfiguration(classes =  {ControllerTest.class, MyWebConfig.class})
@WebAppConfiguration
@Configuration
public class ControllerTest {

//    @Bean
//    public ViewResolver internalResourceViewResolver() {
//        InternalResourceViewResolver bean = new InternalResourceViewResolver();
//        bean.setViewClass(JstlView.class);
//        bean.setPrefix("/WEB-INF/pages/");
//        bean.setSuffix(".jsp");
//        return bean;
//    }

    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    @Before
    public void setup() {


      // mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
       mockMvc = MockMvcBuilders.standaloneSetup(new HelloController(), new FormController()).build();
    }




//    @Test
//    public void testHelloController() throws Exception {
//     ResultActions resultActions =  mockMvc.perform(MockMvcRequestBuilders.get("/hello")).andExpect(MockMvcResultMatchers.status().isOk());
//    }


    @Test
    public void testHello2Controller() throws Exception {
         mockMvc.perform(MockMvcRequestBuilders.get("/hello2?first=firstValue&integer=3").accept(MediaType.TEXT_HTML))
                 .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testFormController() throws Exception {
        ResultActions resultActions =     mockMvc.perform(MockMvcRequestBuilders.post("/form").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=ISO-8859-1"));
      //  .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Max"));

    }

//    @Configuration
//    public static class Config {

//        @Bean
//        public ViewResolver getViewResolver() {
//            InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//            resolver.setPrefix("/WEB-INF/pages/");
//            resolver.setSuffix(".jsp");
//            resolver.setViewClass(JstlView.class);
//
//            return resolver;
//        }


//        @Bean
//        BeanNameUrlHandlerMapping beanNameUrlHandlerMapping() {
//            return new BeanNameUrlHandlerMapping();
//        }

//        @Bean
//        public HelloController welcome() {
//            return new HelloController();
//        }

 //   }
}
