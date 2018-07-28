#language: pt

Funcionalidade: Alugar Filme.
	Como um usuário
	Eu quero cadastrar aluguéis de filme
	Para controlar preços e datas de entrega

Cenário: Deve alugar um filme com sucesso
	Dado um filme com estoque de 2 unidades
	E que o preço do aluguel seja de R$ 3
	Quando alugar
	Então o preço do aluguel será de R$ 3
	E a data de entrega será no dia seguinte
	E o estoque do filme será 1 unidade
	
Cenário: Não deve alugar filme sem estoque
	Dado um filme com estoque de 0 unidades
	Quando alugar
	Então não será possível por falta de estoque
	E o estoque do filme será 0 unidades
