package com.springboot.xhd.controller;

import com.springboot.xhd.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController
 * 相当于@ResponseBody + @Controller
 *
 * @Controller 是一种特殊化的@Component 类。
 *      @Component把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
 *      @Component泛指各种组件，就是说当我们的类不属于各种归类的时候（不属于@Controller、@Services等的时候），我们就可以使用@Component来标注这个类。
 * @Controller 习惯于和@RequestMapping绑定来使用，后者是用来指定路由映射的。
 * @ResponseBody 是用来把返回对象自动序列化成HttpResponse
 */

@RestController()
public class SpringCaseController {
    /**
     *@RequestMapping注释用于映射url到控制器类或一个特定的处理程序方法。可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。该注解共有6个属性
     * 1.value：指定请求的实际地址，指定的地址可以是URI Template 模式.
     * 2.method：指定请求的method类型， GET、POST、PUT、DELETE等.
     * 3.consumes：指定处理请求的提交内容类型（Content-Type），例如application/json, text/html.
     * 4.produces: 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回.
     * 5.params：指定request中必须包含某些参数值是，才让该方法处理.
     * 6.headers：指定request中必须包含某些指定的header值，才能让该方法处理请求.
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    /**
     * 因为springboot内置了Jackson包，会将返回的对象自动序列化成json
     * @return
     */
    @RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setAge(22);
        user.setId(1);
        user.setName("徐海东");
        return user;
    }
}
