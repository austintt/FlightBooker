angular.module("airwaysApp", [])
  .controller("FormController", function($scope) {
        $scope.passenger = {};
        $scope.passenger.From= "";
        $scope.passenger.To  = "";
        $scope.passenger.Depart  = "";
});