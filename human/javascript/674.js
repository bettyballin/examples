function test() {
  var script = document.createElement('script');
  script.text = "var newVar = true;";
  document.head.appendChild(script).parentNode.removeChild(script);
}

test();

console.log(newVar); // outputs: true