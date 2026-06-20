package com.demo.soap.configuration;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class DemoConfiguration extends WsConfigurerAdapter {

    // 1. Register the SOAP servlet at /ws/*
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
            ApplicationContext context) {

        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    // 2. Auto-generate WSDL from the XSD
    @Bean(name = "countries")  // WSDL will be at /ws/countries.wsdl
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema employeeSchema) {
        DefaultWsdl11Definition def = new DefaultWsdl11Definition();
        def.setPortTypeName("CountryPort");
        def.setLocationUri("/ws");
        def.setTargetNamespace("http://demo.project/countries");
        def.setSchema(employeeSchema);
        return def;
    }

    // 3. Point to the XSD file

    @Bean
    public XsdSchema employeeSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/countries.xsd"));
    }
}