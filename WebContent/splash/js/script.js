var app = angular.module('birdsEye',[]);

function wait (argument) {
    // alert("Hey! Wait a second for the pretty video!");
}

app.controller('eyeCtrl', ['$scope', function($scope){
    $scope.test = $scope.formSearch;
    $scope.tweets = localCache().get("tweets", "object");

    $scope.clearScope = function() {
        $scope.tweets = "";
    }

          var frm = $('#search');
          frm.submit(function (ev) {
              $scope.clearScope();
              $.ajax({
                  type: "POST",
                  dataType: "json",
                  url: "GetTweets",
                  data: frm.serialize(),
                  success: function (data) {
                      console.log(data);
                      localCache().save("tweets", data);
                      window.open("index.jsp","_self");
                      
              },
              error: function(data) {
                  alert('fail');
                  console.log(data);

              }
          });

          
          });
}])

var localCache = function () {
       //TODO: Add some more cross-browser stuff here.
       var cache = window.sessionStorage;

       /**
        * Stores the value into the cache.  Will convert objects to strings.
        * key - a string value
        * value - string or object.  If object, it is converted to string.
        */
       var save = function (key, value) {
           if (typeof key !== "string")
           {
               throw "Error: Key must be a string";
           }
           if (typeof value === 'object')
           {
               if (value instanceof Date)
               {
                   value = value.toString();
               }
               else
               {
                   value = JSON.stringify(value);
               }
           }
           cache.setItem(key, value);
       };

       /**
        * Retrieves a value from the cache.
        * key - string value
        * type - optional parameter.  If it equals "object" a conversion to
        *        object will occur. "date" will convert it to a JS Date object.
        */
       var get = function (key, type) {
           if (typeof key !== "string")
           {
               throw "Error: Key must be a string";
           }
           if ((typeof type !== "undefined") && (type === "object"))
           {
               return JSON.parse(cache.getItem(key));
           }
           if ((typeof type !== "undefined") && (type === "date"))
           {
               return new Date(cache.getItem(key));
           }
           return cache.getItem(key);
       };

       return {
           save:save,
           get:get
       };
   };




