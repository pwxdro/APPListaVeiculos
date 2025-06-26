# 🚗 APPListaVeiculos

Aplicativo Android desenvolvido em Kotlin para exibir uma lista de veículos obtidos a partir de uma API. O app permite visualizar os detalhes de cada veículo, funciona offline com persistência local usando Room, e segue princípios da arquitetura SOLID e MVVM.

---
<div align="center">
  <img src="https://github.com/user-attachments/assets/a9497877-595a-4429-97fa-22b0e932f96a" width="250"/>
  <img src="https://github.com/user-attachments/assets/6c256d24-13a9-456e-8bd5-c98b27006a8e" width="250"/>
</div>


---

## ✨ Funcionalidades

- 📥 Consumo de API REST (Retrofit + coroutines)
- 🧾 Exibição de lista de veículos com RecyclerView
- 🔍 Tela de detalhes do veículo
- 💾 Persistência local offline com Room
- 📶 Detecção de conexão: mostra mensagem se estiver sem internet na 1ª execução
- 🔄 Indicador de carregamento (ProgressBar)

---

## 🧠 Tecnologias e bibliotecas

- Kotlin
- Retrofit
- Moshi (para converter JSON)
- Room (persistência local)
- ViewModel + LiveData
- RecyclerView

---

## 🏗️ Arquitetura do Projeto

O projeto segue o padrão **MVVM (Model-View-ViewModel)** com camadas bem definidas:

```
com.pedro.applistaveiculos/
│
├── data/
│ ├── DTOs/ # Modelos de dados (Veiculo, VeiculosResponse)
│ ├── api/ # Interface Retrofit
│ ├── local/ # Room DAO e Database
│ └── repository/ # Repository que integra API + Room
│
├── ui/
│ ├── list/ # MainActivity (lista de veículos)
│ └── details/ # DetalhesVeiculoActivity
│
├── viewmode/ # ViewModel e ViewModelFactory
└── res/ # Layouts, valores, drawables etc.
```

---

## 🔃 Funcionamento Offline

- Os dados baixados da API são armazenados localmente usando Room.
- A partir da segunda vez, mesmo sem conexão, os dados persistidos são exibidos.

---


## 📦 Instalação

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/APPListaVeiculos.git
```

### 2. Abra no Android Studio
Vá em File > Open e selecione a pasta do projeto.

### 3. Sincronize as dependências (Gradle)
O Android Studio cuidará disso automaticamente ao abrir o projeto.

### 4. Rode o app em um dispositivo físico ou emulador


👨‍💻 Autor
Pedro Sena

