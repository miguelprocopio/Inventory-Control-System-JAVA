# Inventory-Control-System-JAVA

Requisitos Mínimos:
 
Para começar, o programa apresenta um menu interativo para o usuário, no qual ele pode escolher entre diferentes opções, como adicionar um produto, remover um produto, consultar um produto ou atualizar as informações de um produto existente. Isso é feito para garantir que o usuário possa facilmente interagir com o sistema e executar as operações desejadas de forma simples e direta.
Em seguida, os dados dos produtos são armazenados em um ArrayList, uma estrutura de dados dinâmica em Java que permite armazenar uma coleção de objetos sem precisar definir previamente o seu tamanho. Cada produto é representado por uma instância da classe Produto, que contém informações como nome, categoria, quantidade e preço. Esses produtos são adicionados ao ArrayList conforme necessário, seja quando o usuário adiciona um novo produto ou quando o sistema carrega os dados do estoque a partir de um arquivo.
Além disso, o programa trata cuidadosamente situações em que o usuário tenta remover um produto que não está presente no estoque. Antes de executar a remoção, o sistema verifica se o produto em questão está na lista de produtos. Se não estiver, uma mensagem é exibida informando ao usuário que o produto não está disponível para remoção. Isso evita possíveis erros e garante uma experiência mais fluida para o usuário.
 
Requisitos Adicionais:
 
-Bibliotecas Adicionais Utilizadas-
 
1. Utilizei a biblioteca java.util.ArrayList porque precisava de uma estrutura de dados dinâmica para armazenar os produtos do estoque. O ArrayList oferece flexibilidade para adicionar, remover e acessar elementos sem a necessidade de definir um tamanho fixo para a lista, o que era essencial para lidar com um número variável de produtos.
 
2 Utilizei a biblioteca java.util.Collections para ordenar a lista de produtos com base em diferentes critérios, como nome, quantidade ou preço. Os métodos fornecidos pela classe Collections foram cruciais para realizar essa ordenação de forma eficiente e conveniente, garantindo que os produtos pudessem ser visualizados e organizados conforme necessário pelos usuários.
 
3. Utilizei as bibliotecas de entrada/saída de arquivos( java.io.File, java.io.FileReader, java.io.FileWriter e java.io.PrintWriter)parac arregar e salvar os dados do estoque em um arquivo de texto.
 
4. Utilizei a biblioteca java.util.InputMismatchException para lidar com possíveis erros de entrada do usuário durante a leitura de dados numéricos, como inteiros ou doubles. Por exemplo, quando solicitar ao usuário que insira a quantidade ou o preço de um produto, é possível que ele digite um valor no formato errado, como uma string em vez de um número. Nesse caso, a InputMismatchException é lançada pelo Scanner, permitindo que o programa trate o erro de forma apropriada, exibindo uma mensagem de erro e solicitando ao usuário que insira o valor correto.
 
5. Coloquei uma variavel chamada categoria para armazenar a informação das categorias dos produtos.
6. Uma opção para permitir a consulta de produtos por categoria para agrupar e visualizar os itens de forma mais organizada.
7. Uma opção para ordenar os produtos por nome, quantidade ou preço para facilitar a visualização e organização do estoque.
8. Uma opção para salvar o estoque em um arquivo para preservar os dados entre sessões do programa ou para fazer backup das informações.
9. Uma opção para remover todo o estoque de uma vez para limpar completamente o inventário, se necessário.
10. Uma opção para mostrar todos os produtos de uma vez para fornecer uma visão geral do estoque e das informações de cada item disponível.
