package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *之前用户使用的是3个注解注解他们的main类。分别是@Configuration,@EnableAutoConfiguration,@ComponentScan。
 * 由于这些注解一般都是一起使用，spring boot提供了一个统一的注解@SpringBootApplication。
 * 1.@Configuration：@Configuration的注解类标识这个类可以使用Spring IoC容器作为bean定义的来源。@Bean注解告诉Spring，一个带有@Bean的注解方法将返回一个对象，该对象应该被注册为在Spring应用程序上下文中的bean。
 * 2.@EnableAutoConfiguration：能够自动配置spring的上下文，试图猜测和配置你想要的bean类，通常会自动根据你的类路径和你的bean定义自动配置。
 * 3.@ComponentScan：会自动扫描指定包下的全部标有@Component的类，并注册成bean，当然包括@Component下的子注解@Service,@Repository,@Controller。
 */
@SpringBootApplication
public class App {
    /**
     * SpringApplication.run执行步骤
     * 1.这个方法里面首先创建一个SpringApplication对象实例，然后调用这个创建好的SpringApplication的实例方法。在SpringApplication实例初始化的时候，它会提前做几件事情：
     * 2.根据classpath里面是否存在某个特征类来决定web应用类型，这个类型会用来创建相应的ApplicationContext
     * 3.使用SpringFactoriesLoader在应用的classpath中查找并加载所有可用的ApplicationContextInitializer.
     * 4.使用SpringFactoriesLoader在应用的classpath中查找并加载所有可用的ApplicationListener.
     * 5.推断并设置main方法的定义类。
     * 6.SpringApplication实例初始化完成并且完成设置后，就开始执行run方法的逻辑了，首先遍历所有通过SpringFactoriesLoader加载的SpringApplicationRunListener，调用它们的started方法。
     * 7.创建并配置当前Spring Boot应用将要使用的Environment
     * 8. 遍历调用所有SpringApplicationRunListener的environmentPrepared()的方法
     * 9.如果SpringApplication的showBanner属性被设置为true，则打印banner
     * 10.根据用户是否明确设置了applicationContextClass类型以及初始化阶段的推断结果，决定该为当前SpringBoot应用创建什么类型的ApplicationContext，然后根据条件决定是否添加ShutdownHook，决定是否使用自定义的BeanNameGenerator，决定是否使用自定义的ResourceLoader，最重要的，是将之前准备好的Environment设置给创建好的ApplicationContext使用。
     * 11. ApplicationContext创建好之后，SpringApplication会再次借助Spring-FactoriesLoader，查找并加载classpath中所有可用的ApplicatinContext-Initializer，然后遍历调用这些ApplicationContextInitializer的initialize(applicationContext)方法对已经创建好的ApplicationContext进行进一步的处理。
     * 12.遍历调用所有SpringApplicationRunListener的contextPrepared()方法。
     * 13.最核心的一步，将之前通过@EnableAutoConfiguration获取的所有配置以及其他形式的IoC容器配置加载到已经准备完毕的ApplicationContext。
     * 14.遍历调用所有SpringApplicationRunListener的contextLoaded()方法。
     * 15.调用ApplicationContext的refresh()方法，完成IoC容器可用的最后上道工序。
     * 16.查找当前ApplicationContext中是否注册有CommandLineRunner，如果有，则遍历执行它们。
     * 17.正常情况下，遍历执行SpringApplicationRunListener的方法表示启动完成（如果整个过程出现异常，会把异常信息也传给listener）
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
