// Page 1
localStorage.setItem('appName_key', 'value');

// Page 2
console.log(localStorage.getItem('anotherAppName_differentKey')); // null
console.log(localStorage.getItem('appName_key')); // "value"