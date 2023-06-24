package chatgpt;


import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.junit.Test;

import java.util.List;

public class Exemplo {

    private static final String API_KEY = "SUA API KEY";

    @Test
    public void testarGpt3() {
        criandoUmPromptComGPT3("Crie um resumo com uma pequena frase sobre o livro: A Arte da guerra")
                .forEach(System.out::println);
    }

    private List criandoUmPromptComGPT3(String textoPrompt) {

        OpenAiService servico = new OpenAiService(API_KEY);

        CompletionRequest requisicao = CompletionRequest.builder()
                .model("text-davinci-003")
                .prompt(textoPrompt)
                .maxTokens(100)
                .build();

        return servico.createCompletion(requisicao).getChoices();
    }

}
