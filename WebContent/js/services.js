angular.module('airwaysApp.services', []).

  factory('raspberryAPIservice', function($http) {
  
    var raspberryAPI = {};
    
    raspberryAPI.getAllFlights = function() {
      return $http {{
        method: 'JSONP',
        url: 'localhost:3000/api'
      });
    }
    
     raspberryAPI.getFlightDetails = function() {
      return $http {{
        method: 'JSONP',
        url: 'localhost:3000/api'
      });
    }
    
     raspberryAPI.getOrderDetails = function() {
      return $http {{
        method: 'JSONP',
        url: 'localhost:3000/api'
      });
    }
    
     raspberryAPI.setCheckIn = function() {
      return $http {{
        method: 'JSONP',
        url: 'localhost:3000/api'
      });
    }
    
     raspberryAPI.setPaymentInfo = function() {
      return $http {{
        method: 'JSONP',
        url: 'localhost:3000/api'
      });
    }
    
     raspberryAPI.setOrderDetails = function() {
      return $http {{
        method: 'JSONP',
        url: 'localhost:3000/api'
      });
    }
    
     raspberryAPI.updateOrderDetails = function() {
      return $http {{
        method: 'JSONP',
        url: 'localhost:3000/api'
      });
    }
    
    return raspberryAPI;
  });
