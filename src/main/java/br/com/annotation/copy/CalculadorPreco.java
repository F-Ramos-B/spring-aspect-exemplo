package br.com.annotation.copy;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.annotation.anots.InterceptLog;

@Component
public class CalculadorPreco {

	@Bean
	public CalculadorPreco calculador() {
		return new CalculadorPreco();
	}

	@InterceptLog(type = Produto.class, exclude = { "quantidade", "desconto" }, strategy = InterceptLog.AFTER)
//	@InterceptLog(type = Produto.class, exclude = { "nome" }, strategy = InterceptLog.BEFORE)
	public void somarValor(Produto produto) {
		Double precoProduto = produto.getPreco() - (produto.getPreco() * (produto.getDesconto() / 100));
		System.out.println(precoProduto * produto.getQuantidade());
	}

}
