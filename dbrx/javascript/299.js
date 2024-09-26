const express = require('express');
const app = express();
const DOMPurify = require('dompurify');

app.use(express.json());

let inValue = null;

const request = {
  post: (someData) => {
    return someData;
  }
};

const someData = '<script>alert("XSS")</script>';

const data = request.post(someData);
inValue = DOMPurify.sanitize(data);

console.log(inValue);