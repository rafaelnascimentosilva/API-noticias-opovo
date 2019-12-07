var app = angular.module("listaDeNoticias",['ngMask','ngAnimate', 'ngSanitize', 'ui.bootstrap']);

app.controller("listaDeNoticiasCtrl",function($scope,NoticiaService,$http) {
	
	$scope.app = "Quadro de Notícias";	
	$scope.noticias=[];
	
	$scope.listar = function() {
		NoticiaService.lista().then(function (response) {
			 $scope.noticias = response.data;
			 console.log(response.data);
			 $scope.totalItems = $scope.noticias.length;					
		});
	}
	
	$scope.novo = function(noticia)	{
		$scope.noticia = {};
	};
	
	$scope.salvar = function(noticia) {			
		NoticiaService.salvar(noticia).then($scope.listar);		
	};
	
	$scope.deletar = function(noticia) {		
		if(confirm("Deseja Excluir a Notícia?")) {
			NoticiaService.deletar(noticia).then($scope.listar);
		}
	};
	
	$scope.editar = function(noticia) {	
		$scope.noticia = angular.copy(noticia); 
		$scope.noticia.nascimento = $filter("date")($scope.noticia.nascimento,"dd/MM/yyyy");
	};
	
	$scope.paginar = function(limit,attr) {		
		NoticiaService.paginado(limit,attr).then(function (response) {
			$scope.noticias = response.data.noticia;				
		});		
	};	
});

app.service("NoticiaService",function($http) {
	
	this.lista = function() {
		return $http.get("http://localhost:8080/noticias");		
	};
	
	this.salvar = function(noticias) {
		if (noticias.id) {
			return $http.put("http://localhost:8080/noticias/"+noticias.id,noticias);
		} else {
			return $http.post("http://localhost:8080/noticias",noticias);
		}		
	};
	
	this.deletar = function(noticias) {
		return $http.delete("http://localhost:8080/noticias/"+noticias.id);
	};
	
	this.paginado =  function(limit,attr) {
		return $http.get("http://localhost:8080/noticias/"+limit+"/"+attr);
	};		
});


app.filter("startFrom", function() {
	return function(data, start) {
		return data.slice(start);
	}
});

app.controller("PaginationCtrl", function ($scope, $log, NoticiaService) {	
	
	  $scope.currentPage = 1;	  
	  $scope.pageSize = 3;	  
	  
	  $scope.setPage = function (pageNo) {
	    $scope.currentPage = pageNo;	   
	  };

	  $scope.pageChanged = function() {	    	  
	    $scope.paginar($scope.pageSize, $scope.setPage);
	  };

	  $scope.bigCurrentPage = 1;
	  
	});
