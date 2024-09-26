function joinIt(strs) {
  var strA = strs[0].length <= strs[1].length?strs[0]:strs[1];
  var strB = strs[1].length <= strs[0].length?strs[0]:strs[1];

  return strB.split("").map(function(b, i) {
    var a = strA.charAt(i) || '';
    return b + a;
  }).join("")
}
console.log(
  joinIt(['HELLO WORLD!', '66666666666666666666'])
)

console.log(
  joinIt(['SOME REALLY REALLY LONG STRING','66666666666666666666'])
)