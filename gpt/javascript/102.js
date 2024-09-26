
   socket.on('fromServerToClient', function (data) {
     const messageElement = $('<div>').text(data.message);
     $('#messages').append(messageElement);
   });
   
