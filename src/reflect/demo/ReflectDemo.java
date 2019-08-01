package reflect.demo;

import java.lang.reflect.Constructor;

import bean.test.Person;

public class ReflectDemo {

	public static void main(String[] args) throws Exception {
		System.out.println("java-反射机制-获取Class对象的三种方式");
		
		getClassObject_1();
		getClassObject_2();
		getClassObject_3();
		
		System.out.println("java-反射机制-获取Class中的构造函数");
		createNewObject();
		

	}
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	private static void createNewObject() throws Exception {
		String name = "bean.test.Person";
		Class clazz = Class.forName(name);
		
		//Object obj = clazz.newInstance(); 空参数构造函数
		Constructor constructor = clazz.getConstructor(String.class,int.class);//带参数构造函数
		
		Object obj = constructor.newInstance("小明",28);
		
	}

	@SuppressWarnings("rawtypes")
	private static void getClassObject_3() throws ClassNotFoundException {
		String className = "bean.test.Person";
				
		Class clazz = Class.forName(className);
		System.out.println(clazz);
	}
	@SuppressWarnings("rawtypes")
	private static void getClassObject_2() {
		Class clazz = Person.class;
		Class clazz1 = Person.class;
		System.out.println(clazz==clazz1);
	}
	@SuppressWarnings("rawtypes")
	private static void getClassObject_1() {
		Person p = new Person();
		Class clazz = p.getClass();
		
		Person p1 = new Person();
		Class clazz1 = p1.getClass();
		
		System.out.println(clazz==clazz1);
	}

}
