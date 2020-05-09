/**
 *  Angular rest services for add, update, put, delete
 */
var cartApp = angular.module("cartApp",[]);
cartApp.controller("CartControl",function($scope,$http){
	
	// Refresh cart function
	$scope.refreshCart = function(){
		$http.get('/myapp/rest/cart/' +$scope.cartId).success(function(data){
			$scope.cart=data;
		});
	};
	
	// clear cart function
	$scope.clearCart = function(){
		$http.delete('/myapp/rest/cart/'+$scope.cartId).success($scope.refreshCart());
	}
	
	$scope.initCartId = function(cartId){
		$scope.cartId = cartId;
		$scope.refreshCart(cartId);
	};
	
	$scope.addToCart = function(productId){
		$http.put('/myapp/rest/cart/add/'+productId).success(function(){
		alert("Product added successfully to the cart!")
		});
	};
	
	$scope.removeFromCart = function(productId){
		$http.put('/myapp/rest/cart/remove/'+productId).success(function(data){
			$scope.refreshCart();
		});
	};
	
	$scope.calculateGrandTotal = function(){
		var finalTotalPrice = 0;
		
		for(var i = 0; i<$scope.cart.cartItems.length; i++){
			finalTotalPrice+= $scope.cart.cartItems[i].totalPrice
		}
		return finalTotalPrice;
	};
	
});