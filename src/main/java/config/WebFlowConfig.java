package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.config.AbstractFlowConfiguration;
import org.springframework.webflow.config.FlowExecutorBuilder;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;
import org.springframework.webflow.executor.FlowExecutor;
import org.springframework.webflow.mvc.builder.MvcViewFactoryCreator;
import org.springframework.webflow.mvc.servlet.FlowHandlerAdapter;
import org.springframework.webflow.mvc.servlet.FlowHandlerMapping;

import java.util.Collections;


@Configuration
@ComponentScan({"controllers", "other"})
public class WebFlowConfig  extends AbstractFlowConfiguration {

    @Autowired
    MyWebConfig myWebConfig;


    @Bean
     public FlowDefinitionRegistry flowDefinitionRegistry() {
        return getFlowDefinitionRegistryBuilder(flowBuilderServices())
                .addFlowLocation("/WEB-INF/flows/hello-flow.xml","helloFlow")
                .addFlowLocation("/WEB-INF/flows/first-flow.xml","firstFlow")
                .build();
    }


    @Bean
    public FlowExecutor flowExecutor() {
        return getFlowExecutorBuilder(flowDefinitionRegistry()).build();
    }

    @Bean
    public FlowBuilderServices flowBuilderServices() {
        return getFlowBuilderServicesBuilder().setViewFactoryCreator(mvcViewFactoryCreator()).setDevelopmentMode(true).build();
    }

    @Bean
    public MvcViewFactoryCreator mvcViewFactoryCreator() {
        MvcViewFactoryCreator mvcViewFactoryCreator = new MvcViewFactoryCreator();
        mvcViewFactoryCreator.setViewResolvers(Collections.singletonList(myWebConfig.getViewResolver()));
        mvcViewFactoryCreator.setUseSpringBeanBinding(true);
        return  mvcViewFactoryCreator;
    }

    @Bean
    public FlowHandlerMapping flowHandlerMapping() {
        FlowHandlerMapping flowHandlerMapping = new FlowHandlerMapping();
        flowHandlerMapping.setOrder(-1);
        flowHandlerMapping.setFlowRegistry(flowDefinitionRegistry());
        return flowHandlerMapping;
    }

    @Bean
    public FlowHandlerAdapter flowHandlerAdapter() {
        FlowHandlerAdapter flowHandlerAdapter = new FlowHandlerAdapter();
        flowHandlerAdapter.setFlowExecutor(flowExecutor());
        flowHandlerAdapter.setSaveOutputToFlashScopeOnRedirect(true);
        return flowHandlerAdapter;
    }

}
