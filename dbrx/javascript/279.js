const queryString = window.location.search;
const urlParams = new URLSearchParams(queryString);
const arg1 = urlParams.get('arg1');
const arg2 = urlParams.get('arg2');

// Now you can use these arguments in your function call.
myFunction(arg1, arg2);

function myFunction(param1, param2) {
  console.log(param1, param2);
}