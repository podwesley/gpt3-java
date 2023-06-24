# chatgpt-java

Passo 1: Obtenção da chave de API do ChatGPT

Primeiramente, você precisa obter uma chave de API do ChatGPT. Acesse o site da OpenAI (https://www.openai.com) e siga as instruções para obter uma chave de API válida.
Passo 2: Configuração do ambiente

Certifique-se de ter o Java JDK (Java Development Kit) instalado em seu sistema.
Crie um novo projeto Java ou abra um projeto Java existente no seu IDE preferido.

## Maven

Execute o comando para instalar alguma dependência que possa faltar 
```mvn clean install -D SkipTests```

### Execute o teste que está na classe de exemplo.

OBS Importante: caso tome a exceção: ``com.theokanning.openai.OpenAiHttpException: You exceeded your current quota, please check your plan and billing details.``


significa q vc precisa adquirir um plano para usar a API do GPT-3 que hoje acredito estar
em torno de $ 20 dolares

## Documentação: não esqueça de usar a documentação. 

A lib usada é a referenciada na documentação: https://github.com/TheoKanning/openai-java

Documentação Referência: https://platform.openai.com/docs/introduction
