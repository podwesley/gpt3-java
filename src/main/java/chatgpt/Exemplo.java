package chatgpt;

import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import com.theokanning.openai.service.OpenAiService;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Exemplo {

    private OpenAiService openAiService;

    // Construtor para injeção de dependência
    public Exemplo(OpenAiService openAiService) {
        this.openAiService = openAiService;
    }

    // Construtor padrão para casos onde o serviço real ainda pode ser usado (opcional)
    // Para esta subtarefa, estamos focando em testes com mocks, então um construtor padrão
    // usando a API_KEY não é estritamente necessário para o teste em si.
    // Se fosse necessário para outras partes da aplicação, seria algo como:
    // public Exemplo() {
    //     this.openAiService = new OpenAiService("SUA_CHAVE_API_AQUI_SE_NECESSARIO_EM_OUTRO_LUGAR");
    // }


    @Test
    public void testarGpt3() {
        // 1. Criar mocks
        OpenAiService mockOpenAiService = mock(OpenAiService.class);
        CompletionResult mockCompletionResult = mock(CompletionResult.class);
        CompletionChoice mockCompletionChoice = mock(CompletionChoice.class);

        // 2. Configurar comportamento do mock
        when(mockOpenAiService.createCompletion(any(CompletionRequest.class)))
                .thenReturn(mockCompletionResult);
        when(mockCompletionResult.getChoices()).thenReturn(Collections.singletonList(mockCompletionChoice));

        // 3. Instanciar Exemplo com o serviço mock
        Exemplo exemplo = new Exemplo(mockOpenAiService);

        // 4. Chamar o método a ser testado
        List<?> resultados = exemplo.criandoUmPromptComGPT3("Crie um resumo com uma pequena frase sobre o livro: A Arte da guerra");

        // 5. Validar resultados com base nos dados mock
        Assert.assertNotNull(resultados);
        Assert.assertFalse(resultados.isEmpty());
        Assert.assertEquals(1, resultados.size());
        Assert.assertSame(mockCompletionChoice, resultados.get(0)); // Verifica se é exatamente a escolha mock
    }

    // Método agora usa o OpenAiService injetado
    private List<?> criandoUmPromptComGPT3(String textoPrompt) {
        // OpenAiService servico = new OpenAiService(API_KEY); // Modo antigo
        OpenAiService servico = this.openAiService; // Novo modo usando serviço injetado

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("text-davinci-003") // Este modelo pode não ser estritamente necessário para o mocking
                .prompt(textoPrompt)
                .maxTokens(100) // Este limite pode não ser estritamente necessário para o mocking
                .build();

        return servico.createCompletion(requisicao).getChoices();
    }
}
