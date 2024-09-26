const express = require('express');
const app = express();

const PORT_NUMBER = 3000;

app.listen(PORT_NUMBER,'localhost',function(){
   console.log('server started on '+PORT_NUMBER);
})