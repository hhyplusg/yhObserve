package com.wave.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库表的注解
 */
@Target(ElementType.TYPE)//类，接口（包括注解类型）或enum声明
@Retention(RetentionPolicy.RUNTIME)//VM将在运行期也保留注释，因此可以通过反射机制读取注解的信息。
@Documented//此注解包含在 javadoc 中
@Inherited//允许子类继承父类中的注解
public @interface TableAnnotation {
	//数据库表名
	public String tableName();
	//主键
	public String primaryKey();
	
	//主键增加方式默认为序列
	public String generator() default "seq";
	//如果增加方式为序列则需要填写序列的名字 默认形式为tableName_SEQ
	public String sequenceName() default "";
	
}