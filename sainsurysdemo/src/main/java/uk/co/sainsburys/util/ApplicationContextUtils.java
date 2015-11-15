package uk.co.sainsburys.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtils
{

    public static ApplicationContext getApplicationContext()
    {
        return new ClassPathXmlApplicationContext(Constants.SPRING_CONTEXT_FILE_NAME);
    }

}
