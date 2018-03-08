package br.com.dxc.core.lock;

import br.com.dxc.constant.ConstantesContaCorrente;

public enum MetodoLock {

        PAGAMENTO_CREDENCIADA(2, ConstantesContaCorrente.REGISTRO_PAGAMENTO_CREDENCIADA), 
        EXPORTACAO_FATURA_DEBITO_AUTOMATICO(3, ConstantesContaCorrente.REGISTRO_EXPORTACAO_FATURA_DEBITO_AUTOMATICO), 
        EXPORTACAO_FATURAS_CDC(4, ConstantesContaCorrente.REGISTRO_EXPORTACAO_FATURAS_CDC),
        ARQUIVO_EMBOSSING_CARTAO(5, ConstantesContaCorrente.REGISTRO_ARQUIVO_EMBOSSING_CARTAO),
        ARQUIVO_RETORNO_MOVIMENTO_DEB_CRE(6, ConstantesContaCorrente.REGISTRO_ARQUIVO_RETORNO_MOVIMENTO_DEB_CRE),
        ARQUIVO_EXTRATO_BANCARIO(7, ConstantesContaCorrente.REGISTRO_ARQUIVO_EXTRATO_BANCARIO), 
        ARQUIVO_BB_CHEQUE_RETORNO(8, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_CHEQUE_RETORNO),
        ARQUIVO_CBF_800(9, ConstantesContaCorrente.REGISTRO_ARQUIVO_CBF_800),
        ARQUIVO_BB_COO500(10, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO500),
        ARQUIVO_BB_COO501(11, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO501),
        ARQUIVO_BB_COO502(12, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO502),
        ARQUIVO_BB_COO504(13, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO504),
        ARQUIVO_BB_COO505(14, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO505),
        ARQUIVO_BB_COO506(15, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO506),
        ARQUIVO_BB_COO507(16, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO507), 
        ARQUIVO_BB_COO508(17, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO508),
        ARQUIVO_BB_COO509(18, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO509),
        ARQUIVO_BB_COO510(19, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO510),
        ARQUIVO_BB_COO550(20, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO550),
        ARQUIVO_BB_COO552(21, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO552),
        ARQUIVO_BB_DEB558(22, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_DEB558),
        ARQUIVO_BB_COO400(23, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO400),
        ARQUIVO_BB_COO402(24, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO402),
        ARQUIVO_BB_COO404(25, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO404),
        ARQUIVO_BB_COO405(26, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO405),
        ARQUIVO_BB_COO406(27, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO406),
        ARQUIVO_BB_COO407(28, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO407),
        ARQUIVO_BB_COO408(29, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO408),
        ARQUIVO_BB_COO409(30, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO409),
        ARQUIVO_BB_COO410(31, ConstantesContaCorrente.REGISTRO_ARQUIVO_BB_COO410),
        SALDO_FORMULARIO_CHEQUE(32),
        PROCESSO_ALCADA(33),
        NUMERO_CONTA_CORRENTE(34),
        RETORNO_PEFIN_SERASA(35, ConstantesContaCorrente.REGISTRO_RETORNO_PEFIN_SERASA),
        PEFIN_INCLUSAO_BAIXA_SERASA(36, ConstantesContaCorrente.REGISTRO_PEFIN_INCLUSAO_BAIXA_SERASA),
        ARQUIVO_EXTRATO_BANCARIO_BASER(37, ConstantesContaCorrente.REGISTRO_ARQUIVO_EXTRATO_BANCARIO_BASER),
        TED(38),
        SALDO_PARCELA(39),
        AGENDAMENTO(40),
        ARQUIVO_REMESSA_CHEQUES(41),
        ARQUIVO_SALDO_BONUS(42),
        ARQUIVO_DVX(43),
        ARQUIVO_CCF_COMPE_PROPRIA(44),
        ARQUIVO_CCB3(45);

        private Integer codigo;
        private String complemento;

        private MetodoLock(Integer codigo) {
            this(codigo, (String) null);
        }

        private MetodoLock(Integer codigo, Integer complemento) {
            this(codigo, complemento != null ? complemento.toString() : null);
        }

        private MetodoLock(Integer codigo, String complemento) {
            this.codigo = codigo;
            this.complemento = complemento;
        }

        public Integer getCodigo() {
            return codigo;
        }

        public String getComplemento() {
            return complemento;
        }
    }