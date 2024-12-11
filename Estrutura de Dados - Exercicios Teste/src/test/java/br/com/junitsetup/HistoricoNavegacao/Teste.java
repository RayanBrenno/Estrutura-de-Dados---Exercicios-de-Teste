package br.com.junitsetup.HistoricoNavegacao;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.*;

public class Teste {
    private HistoricoNavegacao historico = new HistoricoNavegacao();

    @Nested
    class AdicionarPagina {
        @Test
        void AdicionandoPaginas() {
            historico.adicionarPagina("www.google.com");
            historico.adicionarPagina("www.youtube.com");
            historico.adicionarPagina("www.leetcode.com");
            historico.adicionarPagina("www.github.com");
            historico.adicionarPagina("www.whatsapp.com");

            String historicoEsperado = "Histórico de Navegação\n"+
                    "1 - www.whatsapp.com\n" +
                    "2 - www.github.com\n" +
                    "3 - www.leetcode.com\n" +
                    "4 - www.youtube.com\n" +
                    "5 - www.google.com";
            assertEquals(historicoEsperado, historico.exibirHistorico());
        }
    }

    @Nested
    class VoltarOuAvancarPagina {
        @Test
        void VoltarPagina() {
            historico.adicionarPagina("www.google.com");
            historico.adicionarPagina("www.youtube.com");
            historico.adicionarPagina("www.leetcode.com");
            historico.adicionarPagina("www.github.com");
            historico.adicionarPagina("www.whatsapp.com");

            String historicoEsperado = "www.github.com";

            assertEquals(historicoEsperado, historico.voltar());

        }

        @Test
        void VoltarPaginaExcedendoOLimiteInserido() {
            historico.adicionarPagina("www.google.com");
            historico.adicionarPagina("www.youtube.com");
            // Volta uma vez
            historico.voltar();

            String historicoEsperado = "Não há páginas anteriores no histórico.";

            assertEquals(historicoEsperado, historico.voltar());

        }

        @Test
        void AvancarPagina() {
            historico.adicionarPagina("www.google.com");
            historico.adicionarPagina("www.youtube.com");
            historico.adicionarPagina("www.leetcode.com");
            historico.adicionarPagina("www.github.com");
            historico.adicionarPagina("www.whatsapp.com");
            // Volta duas vezes
            historico.voltar();
            historico.voltar();

            String historicoEsperado = "www.github.com";
            assertEquals(historicoEsperado, historico.avancar());
        }

        @Test
        void AvancarPaginaExecendoOLimiteInserido() {
            historico.adicionarPagina("www.google.com");
            historico.adicionarPagina("www.youtube.com");

            String historicoEsperado = "Não há páginas seguintes no histórico.";
            assertEquals(historicoEsperado, historico.avancar());
        }

    }

    @Nested
    class ExibirELimparHistorico {
        @Test
        void ExibirHistorico() {
            historico.adicionarPagina("www.google.com");
            historico.adicionarPagina("www.youtube.com");
            historico.adicionarPagina("www.leetcode.com");
            historico.adicionarPagina("www.github.com");
            historico.adicionarPagina("www.whatsapp.com");

            String historicoEsperado = "Histórico de Navegação\n"+
                    "1 - www.whatsapp.com\n" +
                    "2 - www.github.com\n" +
                    "3 - www.leetcode.com\n" +
                    "4 - www.youtube.com\n" +
                    "5 - www.google.com";

            assertEquals(historicoEsperado, historico.exibirHistorico());
        }

        @Test
        void ExibirHistoricoVoltando() {
            historico.adicionarPagina("www.google.com");
            historico.adicionarPagina("www.youtube.com");
            historico.adicionarPagina("www.leetcode.com");
            historico.adicionarPagina("www.github.com");
            historico.adicionarPagina("www.whatsapp.com");
            historico.voltar();
            historico.voltar();

            String historicoEsperado = "Histórico de Navegação\n"+
                    "1 - www.leetcode.com\n" +
                    "2 - www.youtube.com\n" +
                    "3 - www.google.com";

            assertEquals(historicoEsperado, historico.exibirHistorico());
        }

        @Test
        void ExibirHistoricoVoltandoEAvancando() {
            historico.adicionarPagina("www.google.com");
            historico.adicionarPagina("www.youtube.com");
            historico.adicionarPagina("www.leetcode.com");
            historico.adicionarPagina("www.github.com");
            historico.adicionarPagina("www.whatsapp.com");
            historico.voltar();
            historico.voltar();
            historico.avancar();

            String historicoEsperado = "Histórico de Navegação\n"+
                    "1 - www.github.com\n" + 
                    "2 - www.leetcode.com\n" +
                    "3 - www.youtube.com\n" +
                    "4 - www.google.com";

            assertEquals(historicoEsperado, historico.exibirHistorico());
        }
        @Test

        void ExibirHistoricoVoltandoAvancandoEAdicionando() {
            historico.adicionarPagina("www.google.com");
            historico.adicionarPagina("www.youtube.com");
            historico.voltar();
            historico.adicionarPagina("www.leetcode.com");
            historico.adicionarPagina("www.github.com");
            historico.adicionarPagina("www.whatsapp.com");
            historico.voltar();
            historico.adicionarPagina("www.facebook.com");
            historico.adicionarPagina("www.visual.com");
            historico.adicionarPagina("www.oracle.com");
            historico.adicionarPagina("www.linkedln.com");
            historico.voltar();
            historico.voltar();
            historico.avancar();

            String historicoEsperado = "Histórico de Navegação\n"+
                    "1 - www.oracle.com\n" + 
                    "2 - www.visual.com\n" + 
                    "3 - www.facebook.com\n" + 
                    "4 - www.github.com\n" +
                    "5 - www.leetcode.com\n" +
                    "6 - www.google.com";

            assertEquals(historicoEsperado, historico.exibirHistorico());
        }

        @Test
        void ExibirHistoricoGeral() {
            historico.adicionarPagina("www.google.com");
            historico.adicionarPagina("www.youtube.com");
            historico.adicionarPagina("www.leetcode.com");
            historico.adicionarPagina("www.github.com");
            historico.adicionarPagina("www.whatsapp.com");
            historico.voltar();
            historico.voltar();
            historico.adicionarPagina("www.gmail.com");


            String historicoEsperado = "Histórico de Navegação\n"+
                    "1 - www.gmail.com\n" + 
                    "2 - www.whatsapp.com\n" +
                    "3 - www.github.com\n" +
                    "4 - www.leetcode.com\n" +
                    "5 - www.youtube.com\n" +
                    "6 - www.google.com";

            assertEquals(historicoEsperado, historico.exibirHistoricoGeral());
        }

        @Test
        void LimparHistorico() {
            historico.adicionarPagina("www.google.com");
            historico.adicionarPagina("www.youtube.com");
            historico.adicionarPagina("www.leetcode.com");
            historico.adicionarPagina("www.github.com");
            historico.adicionarPagina("www.whatsapp.com");
            historico.limparHistorico();

            assertEquals("Histórico vazio", historico.exibirHistorico());
        }
    }
}
