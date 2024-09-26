const express = require('express');
const app = express();

app.get('/nothing/:code', function(req, res) {
    var code = req.params.code;
    res.set('Content-Security-Policy', "script-src 'self';");
    res.send(code);
});

app.listen(3000, () => {
    console.log('Server listening on port 3000');
});