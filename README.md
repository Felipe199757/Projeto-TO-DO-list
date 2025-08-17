# ✅ To-Do List em Java (SOLID + Maven)

Aplicação de **gerenciamento de tarefas** (To-Do List) em **Java**, com **persistência em arquivo** via serialização e arquitetura em camadas seguindo **SOLID** (SRP e DIP, principalmente).
---

## 📂 Estrutura de Pastas

src/
└── com/
└── example/
├── Main.java
│
├── model/
│ └── Tarefa.java
│
├── repository/
│ ├── TarefaRepository.java
│ └── FileTarefaRepository.java
│
├── service/
│ └── TarefaService.java
│
└── util/
└── AppendableObjectOutputStream.java

---

## 🚀 Funcionalidades

- Adicionar tarefa (título, descrição, status padrão **PENDENTE**)
- Listar tarefas
- Editar campos (`titulo`, `descricao`, `status` com ajuste automático de `dataConclusao`)
- Remover tarefa
- Filtrar por **status** (`PENDENTE` `EM_ANDAMENTO`/ `CONCLUIDA`)
- Persistência com **serialização** (`ObjectOutputStream`/`ObjectInputStream`)

---

## 🛠️ Requisitos

- **Java 17+**
- **Maven 3.8+**

---

