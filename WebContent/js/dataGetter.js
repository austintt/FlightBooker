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

getInfo = function()
{	
	var newData = {"command" : "getAllFlights"};
	console.log("We are in getINFO!");
	var formData = {command:"getAllFlights"}; //Array 
 
  $.ajax({
      url : "http://localhost:8080/FlightBooker/FlightAPI",
      type: "POST",
      data : formData,
      success: function(data, textStatus, jqXHR)
      {
          console.log("success!!!!!");
          localCache().save("flights", data);
          localCache().get("flights", "object");
          console.log(localCache().get("flights", "object"));
      },
      error: function (jqXHR, textStatus, errorThrown)
      {
          console.log("booooo");
      }
		
	});



	// $.ajax({
 //          type: "post",
 //          url: "http://localhost:8080/DBPianistic2/DBServlet",
 //          data: "cmd=delete&id=" + id,
 //          success: function (data) {
 //              console.log(data);
 //              window.open("pianos.html","_self");
 //          }
 //      });
};


function dbController($scope)
{
  setTimeout(function (){
    //This is here to make it wait...
  }, 500);
  // $scope.currentPiano = localCache().get("currentP", "object");
  $scope.flights = localCache().get("flights", "object");
  console.log($scope.pianos);
  $scope.test = "hey!";
  $scope.numFlights = $scope.flights.length;

};