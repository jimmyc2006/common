package common.spring.ioc.set;

import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author shuwei
 * @version 创建时间：2017年6月27日 上午10:54:15
 * 测试spring定义bean的时候set和array使用逗号分隔的字符串配置
 */
public class SetInConstruct {
    private Set<String> names;
    private String[] strArr;
    
    public SetInConstruct(Set<String> names, String[] strArr) {
        this.names = names;
        this.strArr = strArr;
    }

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
        SetInConstruct sic = (SetInConstruct) beanFactory.getBean("setInConstruct");
        for(String ele : sic.names) {
            System.out.println(ele);
        }
        System.out.println(sic.names);
        System.out.println("----------");
        for(String ele : sic.strArr) {
            System.out.println(ele);
            System.out.println("----------------");
        }
    }
}
