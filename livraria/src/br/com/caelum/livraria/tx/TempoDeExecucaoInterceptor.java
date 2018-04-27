package br.com.caelum.livraria.tx;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@SuppressWarnings("serial")
@Log
@Interceptor
public class TempoDeExecucaoInterceptor implements Serializable{
	
	@AroundInvoke
	public Object executa(InvocationContext context) throws Exception {
		
		long inicio = System.currentTimeMillis();
		// persiste o objeto
		Object resultado = context.proceed();

		// commita a transacao
		long fim = System.currentTimeMillis();

		// fecha a entity manager
		System.out.println("Tempo: "+(fim-inicio)+"ms executado pelo: "+context.getMethod().getName());
		return resultado;
	}
}
