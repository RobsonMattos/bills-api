-- Carga Categorias

insert into categoria (nome) values('Educação');       		-- 1
insert into categoria (nome) values('Alimentação'); 		-- 2
insert into categoria (nome) values('Moradia'); 		    -- 3
insert into categoria (nome) values('Entretenimento');		-- 4
insert into categoria (nome) values('Veículo');			    -- 5
insert into categoria (nome) values('Vestuário');		    -- 6
insert into categoria (nome) values('Cuidados pessoais');	-- 7
insert into categoria (nome) values('Anuidade');	        -- 8
insert into categoria (nome) values('Juros');	            -- 9
insert into categoria (nome) values('Saúde');	            -- 10

select * from categoria;
-- delete from categoria;

-----------------------------------------------------------------------
-- Craga Fatura
insert into fatura (mes, data_vencimento, valor, data_pagamento) values ('Janeiro', '01/17/2019', 6055.73, '01/17/2019');

select * from fatura
order by data_vencimento desc;
-- delete from fatura;

-----------------------------------------------------------------------
-- Carga lançamentos

select * from lancamento;

-- Fatura do mês 03
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('TENDTUDO 09/10', '06/23/2018', 103.22, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('FERREIRA COSTA 08/10', '07/07/2018', 150.05, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('FERREIRA COSTA 08/10', '07/22/2018', 117.61, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('ENOPP S*TOP MOVEIS 07/10', '08/18/2018', 204.7, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('COLCHÕES 06/10', '10/06/2018', 34, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('EBANX-UDA 06/09', '09/06/2018', 92.4, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('FARMO 04/04', '11/20/2018', 91.25, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('LIVRARIA 03/03', '12/08/2018', 97.34, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('SARAIVA 03/06', '12/08/2018', 38.35, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('LOJAS AMERICANAS', '12/21/2018', 244.82, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('VIA VAREJO', '12/22/2018', 259.9, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('DOCE LAR ENXOVAIS 03/04', '12/22/2018', 38.39, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('CRA CLOVES REBOQUE 03/03', '12/28/2018', 145.68, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('HAIR NATA', '01/26/2019', 90, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('PANIFICADORA AVENIDA', '02/03/2019', 14.93, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('hiper frango', '06/23/2018', 103.22, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('drogaria rio branco', '07/07/2018', 150.05, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('condental c odonto 01/03', '07/22/2018', 117.61, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('jsm combustiveis', '08/18/2018', 204.7, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('drogaria rio branco', '06/10/2018', 34, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('tudotec', '09/06/2018', 92.4, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('clube café', '11/20/2018', 91.25, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('mercado pago mercado li 01/10', '12/08/2018', 97.34, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Pizzaria cheiro e sabor', '12/08/2018', 38.35, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Franbrasa', '12/21/2018', 244.82, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Internacional Travessia', '12/22/2018', 259.9, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Monumental Fitness', '12/22/2018', 38.39, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('JSM Combustíveis', '12/28/2018', 145.68, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Clube Café', '01/26/2019', 90, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('So Sabor', '02/03/2019', 14.93, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Uber do Brasil Tecnolo', '06/23/2018', 103.22, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Siosiphone 01/03', '07/07/2018', 150.05, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Uber do Brasil Tecnolo', '07/22/2018', 117.61, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Delícia de pão', '08/18/2018', 204.7, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Atakadão Atakarejo', '10/06/2018', 34, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Atakadão Atakarejo', '09/06/2018', 92.4, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('INCOMAF Madereira 01/04', '11/20/2018', 91.25, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Morena Veículos', '12/08/2018', 97.34, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('GR Revendedora de combustíveis', '12/08/2018', 38.35, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('UNICOM', '12/21/2018', 244.82, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('English Town 01/04', '12/21/2018', 244.82, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Internacional Travessia', '12/22/2018', 259.9, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Ecoposto Albatroz', '12/22/2018', 38.39, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Só Sabor', '12/28/2018', 145.68, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Clube Café', '01/26/2019', 90, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Uber do Brasil Tecnolo', '06/23/2018', 103.22, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Delícias de Pão', '07/07/2018', 150.05, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Uber do Brasil Tecnolo', '07/22/2018', 117.61, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Uber do Brasil Tecnolo', '07/22/2018', 117.61, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Uber do Brasil Tecnolo', '07/22/2018', 117.61, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('C&A Modas', '10/06/2018', 34, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('99* POP', '09/06/2018', 92.4, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Cleber Manoel Olavo CA', '11/20/2018', 91.25, 3, 1);
insert into lancamento (estabelecimento, data, valor, categoria_id, fatura_id) values('Maria do Carmo do Ros', '12/08/2018', 97.34, 3, 1);

-- delete from lancamento;
-- Fatura do mês 03/2018
