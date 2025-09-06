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
   git clone <url-do-repo>
   cd SimuladorGerencialMemoriaa-main
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
SIMULADOR DE GERENCIAMENTO DE MEMORIA (RODIZIO + REALOCACAO)

Processo P1 (5 blocos) → Algoritmo: FirstFit
Alocado: true
[ P1 P1 P1 P1 P1 . . . ]

Processo P2 (8 blocos) → Algoritmo: BestFit
Alocado: true
[ P1 P1 P1 P1 P1 P2 P2 P2 P2 P2 P2 P2 P2 . . . ]

Liberando P2...
[ P1 P1 P1 P1 P1 . . . . . . . . . . . . ]

Processo P6 (4 blocos) → Algoritmo: WorstFit
Alocado: true
[ P1 P1 P1 P1 P1 P6 P6 P6 P6 . . . . . . ]
```
