$(document).ready(function() {

    var url = "ws://localhost:9000/myapp";
    var connection = new WebSocket(url);

    connection.onopen = function () {
        console.log('WebSocket Open');
    };

    connection.onerror = function (error) {
         console.log('WebSocket Error ' + error);
     };

    connection.onmessage = function (event) {
       console.log('WebSocket Msg ' + event.data);
   }

});