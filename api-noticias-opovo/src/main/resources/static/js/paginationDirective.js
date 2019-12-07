angular.module("listaDeNoticias").directive("pagination", function() {
	return {
		templateUrl: "/paginacao.html",
		replace: true	
	};	
});