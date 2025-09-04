# Steam Universitária

Um aplicativo simples em **Jetpack Compose** para cadastro de jogos, exibindo seus títulos em uma lista e permitindo navegação para uma tela de detalhes.

---

## Funcionalidades

- Cadastro de jogos em memória (sem banco de dados).  
- Campos para **título**, **gênero** e **ano de lançamento**.  
- Lista de jogos exibindo apenas os títulos.  
- Navegação entre telas:  
  - **Tela Principal** → cadastro e lista.  
  - **Tela Detalhes** → mostra título, gênero e ano.  
- Limpeza automática dos campos após adicionar um jogo.

---

## Tecnologias

- **Kotlin**  
- **Jetpack Compose**  
- **Navigation Compose** (`NavController` + `NavHost`)  
- **mutableStateListOf** para gerenciamento do estado da lista em memória

---

## Uso

1. Abra o app.  
2. Na **Tela Principal**, preencha os campos:  
   - Título do jogo  
   - Gênero do jogo  
   - Ano de lançamento  
3. Clique em **Adicionar** para incluir o jogo na lista.  
4. A lista exibirá todos os títulos adicionados.  
5. Clique em **Ir para tela 'Detalhes'** para ver mais informações de todos os jogos cadastrados.  
6. Clique em **Voltar** para retornar à Tela Principal.

---

## Exemplo de Tela

**Tela Principal:**
```
Título do jogo: [_________]
Gênero do jogo: [_________]
Ano de lançamento: [____]
[Adicionar]  Clique para adicionar o jogo

Lista de Jogos:
- The Legend of Zelda
- FIFA 23
- Minecraft
```

**Tela Detalhes:**
```
Detalhes

Título: The Legend of Zelda
Gênero: Adventure
Ano: 1986

Título: FIFA 23
Gênero: Sports
Ano: 2022

[Voltar]
```

---

## Observações

- O estado é **apenas em memória**, então ao fechar o app, os dados não são salvos.  
