# Jogo da Velha em Kotlin para Android

Este é um projeto da disciplina de desenvolvimento mobibe (atividade 5), é sobre o clássico Jogo da Velha, desenvolvido em Kotlin, utilizando uma `Empty Activity` e `ConstraintLayout` no Android Studio. O jogo permite que dois jogadores se alternem para marcar "X" e "O" em uma grade 3x3 até que um deles vença ou o jogo termine em empate.

## Estrutura do Projeto

### Layout (`activity_main.xml`)

O layout foi construído usando `ConstraintLayout`, contendo:

- Uma grade 3x3 de `Button` para os jogadores interagirem e colocarem "X" ou "O".
- Cada botão representa uma posição no tabuleiro e altera seu texto ao ser clicado.

### Código Kotlin (`MainActivity.kt`)

A lógica do jogo foi implementada em `MainActivity.kt`, com as seguintes funcionalidades principais:

- **Tabuleiro (board)**: Representado por uma matriz de strings, armazenando o estado de cada posição no tabuleiro.
- **Alternância entre Jogadores**: A variável `currentPlayer` armazena o jogador atual ("X" ou "O") e alterna entre os jogadores após cada jogada.
- **Condição de Vitória**: A função `checkWin()` verifica as linhas, colunas e diagonais do tabuleiro para determinar se há um vencedor.
- **Reset do Jogo**: Quando um jogador vence ou o tabuleiro está completo, o jogo é reiniciado para uma nova partida.

#### Funções principais

- `makeMove()`: Marca a posição clicada com "X" ou "O" e verifica se houve vitória ou empate.
- `checkWin()`: Verifica as condições de vitória (linhas, colunas e diagonais) e retorna `true` se um jogador vencer.
- `resetBoard()`: Redefine o tabuleiro e prepara o jogo para uma nova partida.

## Como Usar

1. Abra o projeto no Android Studio e execute o aplicativo em um dispositivo ou emulador Android.
2. Toque em qualquer posição da grade 3x3 para marcar com "X" ou "O".
3. Após cada jogada, o próximo jogador é alternado automaticamente.
4. O jogo detectará automaticamente quando houver um vencedor ou empate e reiniciará o tabuleiro.

## Requisitos

- **Android Studio**: Versão 4.0 ou superior.
- **SDK Android**: Compilado com Android SDK 34 ou superior.
