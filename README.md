#Avaliação Beca Mobile Android
Criar um aplicativo que realize a listagem de filmes que são tendências da semana. Quando o usuário selecionar um filme o aplicativo deve direciona-lo para uma segunda tela e exibir o título, capa, rating e sinopse.

A listagem de filmes deve ser consultada na API https://developers.themoviedb.org/3/getting-started/introduction ao se cadastrar você receberá uma chave de acesso que deve ser usada nas requisições.

Requisição para listar as tendências https://developers.themoviedb.org/3/trending/get-trending
Requisição para listar os detalhes https://developers.themoviedb.org/3/movies/get-movie-details
Faça um fork deste projeto e quando finalizar a implementação faça um pull request na descrição informe qual a abordagem que você utilizou para chegar na solução descreva também quais foram os maiores desafios para concluir a avaliação.

As bibliotecas abaixo podem ajuda-lo a lidar com alguns desafios deste projeto.

Biblioteca para carregamento de imagens https://github.com/square/picasso
Biblioteca para requisições http https://github.com/square/retrofit

![filmes_alane (1)](https://user-images.githubusercontent.com/86122295/167842434-4663c020-5c02-4a3e-8237-b52034927132.gif)

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Comecei criando o layout das telas. Criei a lista de filmes usando RecyclerView.
Para simular os dados de uma API criei um Mock com a lista de filmes.
Foi usado viewBinding para vincular os dados.
O proximo passso foi implementar a API usando RETROFIT que foi um dos meus maiores desafios e consegui fazer 
a partir de referências.
Para a implementação da API eu criei uma Interface com um companion object onde fica as constantes que são a 
chave da api e o endpoint para os filmes populares. Uma data class para o response e um object onde implemetei 
o retrofit e onde fica a base URL.
Usei a biblioteca GLIDE para as imagens dos filmes.
Implementei o ViewModel para separar a chamada da api.

-----------------------------------------------------------------

file:///C:/Users/mbarbsil/Documents/Val/Melhoras%20para%20aplicar%20ao%20App%20Filmes%20usando%20MVVM.pdf
