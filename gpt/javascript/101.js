
   const sanitizeHtml = require('sanitize-html');

   io.sockets.emit('fromServerToClient', {
     "message": sanitizeHtml(message)
   });
   
