package br.com.annotation.copy;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.annotation.anots.InterceptLog;
import br.com.annotation.anots.Loggable;

@Aspect
@Component
public class ExampleAspect {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

	@Around("@annotation(interceptLog)")
	public void interceptLog(ProceedingJoinPoint joinPoint, InterceptLog interceptLog) throws Throwable {
		String strategy = interceptLog.strategy().toUpperCase();
		
		if (InterceptLog.AFTER.equals(strategy)) {
			joinPoint.proceed();
		}
		
		System.out.println("RODANDO METODO (" + strategy + "): " + joinPoint.getSignature());

		Loggable objeto = (Loggable) joinPoint.getArgs()[0];
		System.out.println("Objeto antes de aspect: " + OBJECT_MAPPER.writeValueAsString(objeto));

		Set<String> excludedFields = Stream.of(interceptLog.exclude()).collect(Collectors.toSet());

		Set<Field> ignoredFields = Stream.of(objeto.getClass().getDeclaredFields())
				.peek(field -> field.setAccessible(true))
				.filter(field -> !field.getName().equalsIgnoreCase("status") && excludedFields.contains(field.getName()))
				.collect(Collectors.toSet());
		
		for (Field field : ignoredFields) {
			field.set(objeto, null);
		}


		objeto.setStatus("PROCESSADO");
		System.out.println("Objeto apos aspect: " + OBJECT_MAPPER.writeValueAsString(objeto));
		
		if (InterceptLog.BEFORE.equals(strategy)) {
			joinPoint.proceed();
		}
	}

}
