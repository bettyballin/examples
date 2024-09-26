let str = "Hello, World!";
str = str.replace(/[^A-Za-z 0-9 \.,\?""!@#\$%\^&\*\(\)-_=\+;:&lt;&gt;\/\\\|\}\{\[\]`~]*/g, '');
console.log(str);