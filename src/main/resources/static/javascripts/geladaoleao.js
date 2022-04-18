$(function() {
	//variavel decimal criada pra formatar onde eu quero apenas numeros decimais
	//chamei de .js-decimal e declarei ela nas classes do html que eu quero a formatacao
	var decimal = $('.js-decimal');
	decimal.maskMoney();
	//variavel plain criada pra formatar apenas numeros inteiros
	//chamei de .js-plain e delcarada nas classes html onde quero a formatacao
	//mais duvidas pesquisar 'jquery maskmoney' 
	var plain = $('.js-plain');
	plain.maskMoney({ precision: 0});
	
});