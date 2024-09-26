const a = class {};
console.dir(a['constructor'] === Function);
try {
  a['constructor']('console.log(1)')();
} catch (error) {
  console.error(error);
}