const a = {};
console.dir(a['constructor'].constructor === Function);
a['constructor'].constructor('console.log(1)')();