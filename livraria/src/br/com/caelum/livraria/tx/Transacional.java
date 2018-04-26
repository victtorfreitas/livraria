package br.com.caelum.livraria.tx;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

/**
 * Anotação para interferir no meio do processo de inicio de transação e fim de transação
 * @author 02729712194
 *
 */
@InterceptorBinding
@Target({ElementType.METHOD, ElementType.TYPE})//Local onde será aplicado a anotação
@Retention(RetentionPolicy.RUNTIME)//Quando o compilador irá executar a anotação
public @interface Transacional {

}
