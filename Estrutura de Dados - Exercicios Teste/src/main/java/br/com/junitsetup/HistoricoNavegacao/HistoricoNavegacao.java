package br.com.junitsetup.HistoricoNavegacao;

import java.util.Stack;

public class HistoricoNavegacao {

    private Stack<String> historico = new Stack<>();
    private Stack<String> historicoAux = new Stack<>();
    private Stack<String> historicoGeral = new Stack<>();

    public void adicionarPagina(String url) {
        historico.push(url);
        historicoGeral.push(url);
        historicoAux.clear();
    }

    public String voltar() {
        if (historico.size() <= 1) {
            return "Não há páginas anteriores no histórico.";
        }
        String paginaAtual = historico.pop();
        historicoAux.push(paginaAtual);
        return historico.peek();
    }

    public String avancar() {
        if (historicoAux.isEmpty()) {
            return "Não há páginas seguintes no histórico.";
        }
        String proximaPagina = historicoAux.pop();
        historico.push(proximaPagina);
        return proximaPagina;
    }

    public String exibirHistorico() {
        if (historico.size() == 0){
            return "Histórico vazio";
        }
        StringBuilder sb = new StringBuilder("Histórico de Navegação\n");
        for (int i = historico.size() - 1; i >= 0; i--) {
            sb.append((historico.size() - i)).append(" - ").append(historico.elementAt(i)).append("\n");
        }
        return sb.toString().trim();
    }

    public String exibirHistoricoGeral() {
        if (historicoGeral.size() == 0){
            return "Histórico vazio";
        }
        StringBuilder sb = new StringBuilder("Histórico de Navegação\n");
        for (int i = historicoGeral.size() - 1; i >= 0; i--) {
            sb.append((historicoGeral.size() - i)).append(" - ").append(historicoGeral.elementAt(i)).append("\n");
        }
        return sb.toString().trim();
    }

    public void limparHistorico() {
        historico.clear();
        historicoAux.clear();
    }

}
