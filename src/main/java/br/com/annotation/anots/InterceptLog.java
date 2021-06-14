package br.com.annotation.anots;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface InterceptLog {
	static final String BEFORE = "BEFORE";
	static final String AFTER = "AFTER";
	
	
	String[] exclude() default {};

	Class<? extends Loggable> type();

	String strategy() default BEFORE;
}
