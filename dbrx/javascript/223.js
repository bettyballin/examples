// myModule.js
const name = 'John Doe';
export {name};

// index.js
import {name} from './myModule.js';
console.log(name); // John Doe


html
<!-- index.html -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <script type="module" src="index.js"></script>
</body>
</html>