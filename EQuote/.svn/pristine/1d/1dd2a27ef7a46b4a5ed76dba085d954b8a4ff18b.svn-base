package com.wave.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据库列的注解
 */
@Target(ElementType.FIELD)//域声明（包括 enum 实例）
@Retention(RetentionPolicy.RUNTIME)//VM将在运行期也保留注释，因此可以通过反射机制读取注解的信息
@Documented//此注解包含在 javadoc 中
@Inherited//允许子类继承父类中的注解
public @interface ColumnAnnotation {
	//列名
	public String column() default "";
	//数据类型
	public String type() default "string";
	
	//属性是否是数据库表中对应的字段
	public boolean isColumn() default true;
}