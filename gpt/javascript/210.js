
   var escape = require('escape-html');
   
   app.get('/nothing/:code', function(req, res) {
       var code = req.params.code;
       res.send(escape(code));
   });
   
