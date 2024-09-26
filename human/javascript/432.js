Object.freeze(Math);

// This won't work or it won't replace
// the function with the whole string...
try {
  Math.random = "hello world";
  console.log(Math.random);
} catch (e) {
  console.log(e);
}