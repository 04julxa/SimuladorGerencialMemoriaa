# Simulador de Gerenciamento de Memória

Este projeto é um simulador de gerenciamento de memória desenvolvido em Java.  
O objetivo é demonstrar o funcionamento de diferentes algoritmos de alocação de memória — First Fit, Best Fit e Worst Fit — em uma memória simulada de 128 KB, organizada em blocos de 2 KB cada.

---

## Conceitos dos Algoritmos

- **First Fit**: percorre a memória do início ao fim e aloca no primeiro espaço livre que couber o processo.  
  - Simples e rápido, mas pode gerar fragmentação ao longo do tempo.  

- **Best Fit**: busca o menor espaço livre que seja suficiente para o processo.  
  - Reduz o desperdício, mas pode aumentar a fragmentação externa.  

- **Worst Fit**: busca o maior espaço livre e aloca o processo lá.  
  - Tende a deixar blocos grandes fragmentados, mas pode reduzir fragmentação imediata.  

---

## Fragmentação de Memória

- **Fragmentação Interna**: ocorre quando o processo não utiliza todo o espaço do bloco alocado, deixando partes internas dos blocos sem uso.  
- **Fragmentação Externa**: ocorre quando existem espaços livres na memória, mas eles estão distribuídos em blocos pequenos que não são suficientes para alocar novos processos.

Esses problemas influenciam diretamente a eficiência dos algoritmos de alocação de memória.

---

## Estrutura do Projeto

- **`Main.java`**  
  Contém a lógica principal do simulador.  
  - Cria processos com tamanhos aleatórios.  
  - Alterna automaticamente entre os algoritmos em um esquema de rodízio.  
  - Simula alocação, liberação e realocação de processos.

- **`Memoria.java`**  
  Representa a memória física (128 KB / 64 blocos de 2 KB).  
  - Métodos principais:  
    - `alocar(...)` → solicita a alocação para um algoritmo.  
    - `liberar(id)` → libera espaço ocupado por um processo.  
    - `exibir()` → mostra o estado atual da memória.

- **`Processo.java`**  
  Representa um processo.  
  - Atributos: `id` (identificador) e `quantidadeDeBlocos` (quantos blocos ocupa).  

- **Interface `Algoritmos.java`**  
  Define o contrato para todos os algoritmos de alocação.  
  - Método: `boolean alocar(Memoria memoria, Processo processo)`  

- **`FirstFit.java`, `BestFit.java`, `WorstFit.java`**  
  Implementam os diferentes algoritmos de alocação conforme a interface.

---

## Funcionamento do Simulador

1. A memória é inicializada com 64 blocos livres (2 KB cada).  
2. Processos são gerados com tamanho aleatório.  
3. O algoritmo de alocação é escolhido automaticamente em rodízio:
   - Primeiro processo → First Fit  
   - Segundo processo → Best Fit  
   - Terceiro processo → Worst Fit  
   - Quarto processo → volta para First Fit  
   - E assim por diante.  
4. Após algumas alocações, o simulador libera um processo aleatório.  
5. Em seguida, um novo processo é criado e realocado no espaço liberado.  

---

## Como Executar

1. Clone este repositório:
   ```bash
   git clone https://github.com/04julxa/SimuladorGerencialMemoriaa.git
   cd SimuladorGerencialMemoriaa-main/src
   ```

2. Compile os arquivos `.java`:
   ```bash
   javac *.java
   ```

3. Execute o programa:
   ```bash
   java Main
   ```

4. Observe a saída no console:  
   - Quais processos foram criados.  
   - Qual algoritmo foi usado para cada alocação.  
   - Estado da memória após cada operação.  

---

## Exemplo de Saída

```
SIMULADOR ADAPTATIVO DE GERENCIAMENTO DE MEMORIA
Processos com tamanhos aleatorios entre 2KB e 32KB
PROCESSOS CRIADOS ALEATORIAMENTE:
- P1: 8KB (4 blocos)
- P2: 22KB (11 blocos)
- P3: 23KB (12 blocos)
- P4: 5KB (3 blocos)
- P5: 16KB (8 blocos)
- P6: 10KB (5 blocos)
- P7: 20KB (10 blocos)
- P8: 19KB (10 blocos)
- P9: 6KB (3 blocos)
- P10: 21KB (11 blocos)


--- Alocando P1 (8KB = 4 blocos) ---
Ocupacao atual: 0,00% - Usando FirstFit (baixa ocupacao)
Ocupação atual: 0.0%
Algoritmo escolhido: firstfit
SUCESSO: P1 alocado com sucesso!
=== Estado da Memoria ===
[P1][P1][P1][P1][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
[  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
[  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
[  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
=========================
Blocos usados: 4 | Blocos livres: 60 | Ocupacao: 6,25%


--- Alocando P2 (22KB = 11 blocos) ---
Ocupacao atual: 6,25% - Usando FirstFit (baixa ocupacao)
Ocupação atual: 6.25%
Algoritmo escolhido: firstfit
SUCESSO: P2 alocado com sucesso!
=== Estado da Memoria ===
[P1][P1][P1][P1][P2][P2][P2][P2][P2][P2][P2][P2][P2][P2][P2][  ]
[  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
[  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
[  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
=========================
Blocos usados: 15 | Blocos livres: 49 | Ocupacao: 23,44%


--- Alocando P3 (23KB = 12 blocos) ---
Ocupacao atual: 23,44% - Usando FirstFit (baixa ocupacao)
Ocupação atual: 23.4375%
Algoritmo escolhido: firstfit
SUCESSO: P3 alocado com sucesso!
=== Estado da Memoria ===
[P1][P1][P1][P1][P2][P2][P2][P2][P2][P2][P2][P2][P2][P2][P2][P3]
[P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][  ][  ][  ][  ][  ]
[  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
[  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
=========================
Blocos usados: 27 | Blocos livres: 37 | Ocupacao: 42,19%


--- Alocando P4 (5KB = 3 blocos) ---
Ocupacao atual: 42,19% - Usando BestFit (media ocupacao)
Ocupação atual: 42.1875%
Algoritmo escolhido: bestfit
SUCESSO: P4 alocado com sucesso!
=== Estado da Memoria ===
[P1][P1][P1][P1][P2][P2][P2][P2][P2][P2][P2][P2][P2][P2][P2][P3]
[P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][P4][P4][P4][  ][  ]
[  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
[  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
=========================
Blocos usados: 30 | Blocos livres: 34 | Ocupacao: 46,88%


--- Alocando P5 (16KB = 8 blocos) ---
Ocupacao atual: 46,88% - Usando BestFit (media ocupacao)
Ocupação atual: 46.875%
Algoritmo escolhido: bestfit
SUCESSO: P5 alocado com sucesso!
=== Estado da Memoria ===
[P1][P1][P1][P1][P2][P2][P2][P2][P2][P2][P2][P2][P2][P2][P2][P3]
[P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][P4][P4][P4][P5][P5]
[P5][P5][P5][P5][P5][P5][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
[  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
=========================
Blocos usados: 38 | Blocos livres: 26 | Ocupacao: 59,38%


--- Alocando P6 (10KB = 5 blocos) ---
Ocupacao atual: 59,38% - Usando BestFit (media ocupacao)
Ocupação atual: 59.375%
Algoritmo escolhido: bestfit
SUCESSO: P6 alocado com sucesso!
=== Estado da Memoria ===
[P1][P1][P1][P1][P2][P2][P2][P2][P2][P2][P2][P2][P2][P2][P2][P3]
[P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][P4][P4][P4][P5][P5]
[P5][P5][P5][P5][P5][P5][P6][P6][P6][P6][P6][  ][  ][  ][  ][  ]
[  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
=========================
Blocos usados: 43 | Blocos livres: 21 | Ocupacao: 67,19%


--- Alocando P7 (20KB = 10 blocos) ---
Ocupacao atual: 67,19% - Usando BestFit (media ocupacao)
Ocupação atual: 67.1875%
Algoritmo escolhido: bestfit
SUCESSO: P7 alocado com sucesso!
=== Estado da Memoria ===
[P1][P1][P1][P1][P2][P2][P2][P2][P2][P2][P2][P2][P2][P2][P2][P3]
[P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][P4][P4][P4][P5][P5]
[P5][P5][P5][P5][P5][P5][P6][P6][P6][P6][P6][P7][P7][P7][P7][P7]
[P7][P7][P7][P7][P7][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ][  ]
=========================
Blocos usados: 53 | Blocos livres: 11 | Ocupacao: 82,81%


--- Alocando P8 (19KB = 10 blocos) ---
Ocupacao atual: 82,81% - Usando WorstFit (alta ocupacao)
Ocupação atual: 82.8125%
Algoritmo escolhido: worstfit
SUCESSO: P8 alocado com sucesso!
=== Estado da Memoria ===
[P1][P1][P1][P1][P2][P2][P2][P2][P2][P2][P2][P2][P2][P2][P2][P3]
[P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][P4][P4][P4][P5][P5]
[P5][P5][P5][P5][P5][P5][P6][P6][P6][P6][P6][P7][P7][P7][P7][P7]
[P7][P7][P7][P7][P7][P8][P8][P8][P8][P8][P8][P8][P8][P8][P8][  ]
=========================
Blocos usados: 63 | Blocos livres: 1 | Ocupacao: 98,44%


--- Alocando P9 (6KB = 3 blocos) ---
Ocupacao atual: 98,44% - Usando WorstFit (alta ocupacao)
Ocupação atual: 98.4375%
Algoritmo escolhido: worstfit
FALHA: Nao foi possivel alocar P9
Liberando processo aleatorio...
Processo P2 liberado!
Tentando alocar novamente...
SUCESSO: P9 alocado apos liberacao!
=== Estado da Memoria ===
[P1][P1][P1][P1][P9][P9][P9][  ][  ][  ][  ][  ][  ][  ][  ][P3]
[P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][P4][P4][P4][P5][P5]
[P5][P5][P5][P5][P5][P5][P6][P6][P6][P6][P6][P7][P7][P7][P7][P7]
[P7][P7][P7][P7][P7][P8][P8][P8][P8][P8][P8][P8][P8][P8][P8][  ]
=========================
Blocos usados: 55 | Blocos livres: 9 | Ocupacao: 85,94%


--- Alocando P10 (21KB = 11 blocos) ---
Ocupacao atual: 85,94% - Usando WorstFit (alta ocupacao)
Ocupação atual: 85.9375%
Algoritmo escolhido: worstfit
FALHA: Nao foi possivel alocar P10
Liberando processo aleatorio...
Processo P6 liberado!
Tentando alocar novamente...
FALHA DEFINITIVA: Nao foi possivel alocar P10
=== Estado da Memoria ===
[P1][P1][P1][P1][P9][P9][P9][  ][  ][  ][  ][  ][  ][  ][  ][P3]
[P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][P3][P4][P4][P4][P5][P5]
[P5][P5][P5][P5][P5][P5][  ][  ][  ][  ][  ][P7][P7][P7][P7][P7]
[P7][P7][P7][P7][P7][P8][P8][P8][P8][P8][P8][P8][P8][P8][P8][  ]
=========================
Blocos usados: 50 | Blocos livres: 14 | Ocupacao: 78,13%


SIMULACAO CONCLUIDA!
```
