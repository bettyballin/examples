const express = require('express');
const DOMPurify = require('dompurify');

const app = express();

app.get('/nothing/:code', function(req, res) {
    var code = req.params.code;
    var purifiedCode = DOMPurify.sanitize(code);
    res.send(purifiedCode);
});

app.listen(3000, () => {
    console.log('Server listening on port 3000');
});