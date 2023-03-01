# Projeto API do MovieDB com o padrão de arquitetura MVVM


## Estrutura do projeto.

![estrutura](https://user-images.githubusercontent.com/109437880/222192060-60de00ec-ea5e-4b4a-89a5-7eec922b2c9c.PNG)

- Models

  Dentro do pacote "Models" encontra-se os dados que serão utilizado no projeto (as chaves de acesso ao arquivo.JSON).

- RetrofitAPI

  Dentro do pacote "RetrofitAPI" encontra-se a instanciação do retrofit através de uma Interface que irá receber a BASE_URL, PATH e a ConvertrFactory(GSON).
  
- Repository
  
  Dentro do pacote "Repository" encontra-se o "MainRepository" (para uma melhor organização, o nome do repositório precisa fazer referencia com a tela que ira receber os 
  dados) que será responsável pela instanciação do Retrofit.
  
- MainViewModel
  
  Dentro do pacote "MainViewModel" encontra-se dois arquivos: MainViewModel e o MainViewModelFactory, o "MainViewModel" será responsável por receber os dados enviados
  pelo repository, e dentro do "MainViewModel" vamos receber o retorno da API conforme configurado no pacote "Models"/ "RetrofitAPI"/"Repository", ainda dentro do 
  "MainViewModel" criamos uma variável do tipo LiveData<List> que será responsável pelo envio de dados para a View (onde será exibido na UI).
  
  Por padrão, não podemos criar um ViewModel com construtor dentro da MainAcitivity (porque o ViewModel não funcionaria corretamente), e para resolver esse "problema"
  criamos uma "Factory" que para uma melhor organização leva o mesmo nome da "ViewModel" que criamos.
  
  Exemplo de um ViewModelFactory com o ViewModelProvider.
  
  ![MainViewModelFactory](https://user-images.githubusercontent.com/109437880/222205123-d2c25a91-d2f6-405c-b183-a48905879991.PNG)

  
- View

  Dentro do pacote "View" encontra-se a UI(User Interface), que irá receber os dados enviados através do LiveData criado dentro do MainViewModel. Como a MainActivity
  é a principal tela, precisamos criar o nosso ViewModel e para isso, iremos usar o ViewModelProvider que irá criar nossa "Factory" passando o nosso "MainRepository"
  e a "MainViewModel"
  
  Exemplo:
  
  ![ViewModelProvider](https://user-images.githubusercontent.com/109437880/222208564-0a070674-12d5-4437-9efd-850882b63eb6.PNG)
  
- Adapter
  
  Criação padrão de um adapter para a utilização da RecyclerView.
  
  Dentro do Adapter, existe uma função que irá receber os dados da LiveData (que é uma lista de filmes).
  
  Dentro do contexto do ciclo de vida, utilizamos a LiveData dentro do onSTART.
  
  Exemplo:
  
  ![adapter](https://user-images.githubusercontent.com/109437880/222211869-acab3f6f-7881-407c-94a9-8fa4922ce5a0.PNG)

## Telas

- Tela Inicial

  ![tela inicial](https://user-images.githubusercontent.com/109437880/222212469-a3522eda-3e88-4715-bb08-805a374da0f1.PNG)
  
- Tela de detalhes

  ![tela de detalhes](https://user-images.githubusercontent.com/109437880/222212578-48c1bcb6-abd0-4829-8429-fd54a5c44a7e.PNG)


