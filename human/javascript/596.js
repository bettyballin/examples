var myString = "foo ${hello} bar";
function myFunc(replaceHelloWith) {
  return myString.replace(/\$\{hello\}/g, replaceHelloWith);
}
console.log(myFunc("whassup"));