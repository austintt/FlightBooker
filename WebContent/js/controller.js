  angular.module('airwaysApp', [])
    .controller('SearchFormController', function($scope, raspberryAPIservice) {
      // our three search fields are binded to the userTo, userFrom, and userDepart variables so their values
      // are always kept up to date with the input values
      $scope.userTo = null;
      $scope.userFrom = null;
      $scope.userDepart = null;
      
      $scope.flightList = [];
   
      raspberryAPIservice.getAllFlights().success(function (response) {
        $scope.flightList = response;
      });
      
      raspberryAPIservice.getFlightDetails().success(function (response) {
        $scope.flightList = response;
      });
      
      raspberryAPIservice.getOrderDetails().success(function (response) {
        $scope.flightList = response;
      });
      
      raspberryAPIservice.setCheckIn().success(function (response) {
        $scope.flightList = response;
      });
      
      raspberryAPIservice.setPaymentInfo().success(function (response) {
        $scope.flightList = response;
      });
      
    raspberryAPIservice.setOrderDetails().success(function (response) {
      $scope.flightList = response;
    });
    
    raspberryAPIservice.updateOrderDetails().success(function (response) {
      $scope.flightList = response;
    });
  });
