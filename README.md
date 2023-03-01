# Projeto API do MovieDB com o padrão de arquitetura MVVM


## Estrutura do projeto.

- Models

  Dentro do pacote "Models" encontra-se os dados que serão utilizado no projeto (as chaves de acesso ao arquivo.JSON).

- RetrofitAPI

  Dentro do pacote "RetrofitAPI" encontra-se a instanciação do retrofit através de uma Interface que irá receber a BASE_URL, PATH e a ConvertrFactory(GSON).
  
- Repository
  
  Dentro do pacote "Repository" encontra-se o "MainRepository" (para uma melhor organização, o nome do repositório precisa fazer referencia com a tela que ira receber os 
  dados) que será responsável pela instanciação do Retrofit.
  
- MainViewModel
  
  Dentro do pacote "MainViewModel" encontra-se dois arquivos: MainViewModel e o MainViewModelFactory, o MainViewModel será responsavel por receber os dados enviados
  pelo repository, e dentro do "MainViewModel" vamos receber o retorno da API conforme configurado no pacote "Models"/ "RetrofitAPI", ainda dentro do "MainViewModel"
  criamos uma variavel do tipo LiveData que será responsavel pelo envio de dados para a View (onde será exibido na UI).
  
  Por padrão, não podemos criar um ViewModel com construtor dentro da MainAcitivity (porque o ViewModel não funcionaria corretamente), e para resolver esse "problema"
  
- View

  dentro do pacote "View" encontra-se a UI(User Interface).
  
![estrutura](https://user-images.githubusercontent.com/109437880/222192060-60de00ec-ea5e-4b4a-89a5-7eec922b2c9c.PNG)
