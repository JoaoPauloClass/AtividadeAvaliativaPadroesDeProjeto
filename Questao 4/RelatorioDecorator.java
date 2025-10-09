public abstract class RelatorioDecorator implements IRelatorio {
    protected IRelatorio relatorioBase;

    public RelatorioDecorator(IRelatorio relatorioBase){
        this.relatorioBase = relatorioBase;
    }

    @Override
    public String gerar() {
       return relatorioBase.gerar();
    }

    @Override
    public double getCustoProcessamento() {
        return relatorioBase.getCustoProcessamento();
    }


    
}
