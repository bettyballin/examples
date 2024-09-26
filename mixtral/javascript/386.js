window.onload = () => {
  const urlParams = new URLSearchParams(location.search);

  // Get parameters
  let arg1 = urlParams.get('arg1');
  let arg2 = urlParams.get('arg2');

  processArguments(arg1, arg2);
}

function processArguments(arg1, arg2) {
  console.log(arg1, arg2);
}