# Java Servlet: Fundamentos

- O que significa trabalhar na web? Trabalhar com o protocolo HTTP e com HTML.

- No Content Directory é onde ficam armazenados arquivos de conteúdo estático.
- Servlets é uma especificação Java, cada especificação Java possui o seu XML.
  - Por exemplo: 
    - JPA -> persistence.xml
    - EJB -> ejb.xml
    - WebContent -> web.xml
- Clique no botão Add or Remove ao clicar em Tomcat, inclua o seu projeto e dê OK, o tomcat rodará sua aplicação.
- Para acessar o arquivo criado no diretório WebContent basta utilizar a seguinte URL:
  - http://localhost:8080/gerenciador/nomeDoArquivo
- JRE = Máquina Virtual Java (Java Runtime Environment)
- Servlet é um objeto que fica dentro do projeto no qual é possível chamá-lo através do protocolo HTTP.
- Servlet funciona como um servidor, é possível chamá-lo através do protocolo HTTP e obter uma resposta dinâmicamente

## Criando um Servlet

- Para criar um servlet basta extender a classe HttpServlet, exemplo:

  - ```
    public class HelloWorldServlet extends HttpServlet {
      	
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
      		PrintWriter out = resp.getWriter();
      		out.println("<html>");
      		out.println("<body>");
      		out.println("Hello World, this is your first servlet!");
      		out.println("</body>");
      		out.println("</html>");
      		System.out.println("Hello Servlet has been called!");
    }
      	
    }
    ```

  - No método service acima, ele recebe dois parâmetros, requisição e resposta, ambos são objetos.

  - @WebServlet é uma anotação que na qual define o nome do servlet a ser chamado na requisição, para definir o nome utilize o urlPatterns = "Exemplo".

  - No mundo http existe duas formas de devolver uma resposta: um fluxo binário

  - resp.getWriter() obtém o writer do servlet e permite adicionar conteúdo na página, ele retorna um PrintWriter.

  - urlPatterns="/oi" -> mapeia a requisição para o servlet HelloWorldServlet

## Trabalhando com POST e GET

- Existem dois métodos HTTP que o servlet trata entre outros, POST e GET, são bem comuns no mundo WEB, o POST define enviar dados para um servidor e GET obtém os dados de um servidor.

- Os métodos são os seguintes: 

  - ```
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    }
    ```

  - ```
    protected void doGet(HttpServletRequest request, 		HttpServletResponse response) throws ServletException, IOException {
    		
    }
    ```

## JSP

- ScriptLet é um pequeno pedaço de código java

  - Para começar um scriptlet basta utilizar <% %>

- JSP - Java Server Page, o servidor renderiza a página e depois retorna-a em HTML puro. O código que existe na página JSP é executado no lado do servidor.

- Existe uma variável no JSP que se chama "out", é uma referência para o writer.

  - Exemplo para imprimir uma variável:

    - ```jsp
      Empresa: <% out.println(nomeEmpresa); %> foi cadastrada com sucesso!
      
      ```

  - é possível utilizar também `<%= nomeEmpresa %> ` para imprimir a variável

### Despachando a requisição

- Para despachar uma requisição é necessário utilizar o requestDispatcher e ele é obtido da seguinte forma:

  - ```java
    RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
    
    ```

- Para incluir um atributo na requisição basta utilizar request.setAttribute(<PARAMETER-NAME>, <CONTENT>), como no exemplo seguinte:

  - ```java
    request.setAttribute("nomeEmpresa", empresa.getNome());
    ```

- Para despachar a requisição basta executar o requestDispatcher.forward(request, response);

- Dispatcher é quem faz a ponte entre o Servlet e o JSP.

- As requisições chegam no servlet, e é no servlet onde é feito todo o processamento, e utilizamos o RequestDispatcher para chamar o JSP.

- Para importar o conteúdo para uma página JSP é necessário utilizar o seguinte scriptlet:

  - ```jsp
    <%@ page import="java.util.List, com.gerenciador.dominio.Empresa"%>
    ```

## Expression Language

- Foi criado uma pequena linguagem para definir expressões, conhecida como EL.

- Para utilizar a EL basta envolver o conteúdo em `${}`

  - Um exemplo de código de EL abaixo:

    - ```jsp
      <html>
      	<body>
      		Empresa: ${ nomeEmpresa } foi cadastrada com sucesso!
      	</body>
      </html>
      ```

- O arquivo jstl.jar foi guardado na pasta WEB-INF/lib, é onde guardamos as libs do projeto.

- Outra biblioteca amplamente utilizada é a JSTL (Java Standard Tag Library).

- Para configurar e importar a JSTL basta utilizar o seguinte comando na página JSP:

  - ```
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    ```

  - uri é o nome do arquivo jar, nesse caso ira buscar no projeto dentro do diretório lib algum arquivo com esse nome "http://java.sun.com/jsp/jstl/core" e em seguida atribuirá um prefixo c para essa lib, c vem de  core.

- JSTL funciona em conjunto com a expression language.

- `${empresas}` , nesse exemplo, existe uma atributo no request com o nome de empresas e a partir daí ele obtém esse atributo por meio da expression language.

- Na expression language, não é necessário utilizar os métodos get, por exemplo:

  - ```java
    ${ empresa.nome } -> já obtém o atributo nome do objeto empresa
    ```

- JSTL -> 

  - core - controle de fluxo
  - fmt - formatação / i18n
  - sql - executar SQL
  - xml - gerar XML

- fmt - formtação

  - `<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>`

- `<c:if test="${ not empty empresa }">` -> verifica se o atributo do request empresa não está vazio.
