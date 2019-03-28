package com.engineering.projekat.maven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*
        Person person = new Person();
        person.speak();
        */
    	
    	ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
    	
    	Person person = (Person) context.getBean("person");
    	person.speak();
    	
    	Student student = (Student) context.getBean("student");
    	student.sing();
    	
    	Index index = (Index) context.getBean("index");
    	index.number();
    	
    	System.out.println(person);
    	
    	((FileSystemXmlApplicationContext)context).close();
    	
    	
    	
    }
}
