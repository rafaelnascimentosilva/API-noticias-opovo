# API-noticias-opovo
 API de notícias usando java no back-end e AngularJS no front-end
 O Sistema de Quadro de Notícias consiste em um SPA criado em AngularJS que ficará responsável por consumir a API java por meio de operações de CRUD(Create,Read,Update,Delete). Por sua vez a Api possui suas operações RESTFull(POST,GET,PUT,DELETE) fazendo a comunicação entre as mesmas e através do SPRING DATA JPA(JpaRepository) o armazenamento de dados no banco H2 que vem incorporado no spring-boot.
 
 
# Execução

 1 - Importar para o eclipse:
     No Package Explore clique com o botão direito e vá em
       New -> Other -> Maven e escolha:
       Check out Maven Projects from SCM
     clique em Next e cole a URL do projeto no espaço em branco
     SCM URL: git <url>
     clique em finish e esperar alguns segundos.
 
 2 - Executar o Sistema
     segure Ctrl+Alt + t
     surgirá uma janela, digite:
     ApiNoticiasOpovoApplication
     agora basta clicar com o botão
     direito, RUN AS -> Java Application
     e os sitemas pode ser testado.
     O JPA criará o banco automaticamente
     para o uso.
  
  3 - Interação no Navegador
      No browser digite:
      http://localhost:8080/home
      agora é só cadastrar as notícias
      que as mesmas serão listadas a cada
      novo cadastro. Tudo pode é feito em
      apenas uma página(SPA).
      
   4- Acessando banco de dados H2 - opcional
      Caso queira acessar o banco e 
      ver as modificações digite no
      navegador:
      http://localhost:8080/h2-console
      e em JDBC URL:jdbc:h2:mem:noticiadb
      acrecente o datasoure acima;
   
   5 - Requisições no Postman
     POST - http://localhost:8080/noticias/ 
     GET  -  http://localhost:8080/noticias/ 
     GET  -  http://localhost:8080/noticias/{id} 
     DELETE  - http://localhost:8080/noticias/{id} 
     PUT -  http://localhost:8080/noticias/{id} 
      
  FERRAMENTAS - > Eclipse, H2, POSTMAN, Spring Boot   
     
    
     
