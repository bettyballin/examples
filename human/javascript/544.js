const hexToArray = arr => arr.split("").map(n => parseInt(n,16));

const doubleDabble = arr => {
  var l = arr.length;
  for( var b = l * 4; b--;){

    //add && leftshift
    const overflow = arr.reduceRight((carry,n,i) => {

      //apply the >4 +3, then leftshift
      var shifted = ((i < (arr.length - l ) && n>4)?n+3:n ) << 1;

      //just take the right four bits and add the eventual carry value
      arr[i] = (shifted & 0b1111) | carry;

      //carry on
      return shifted > 0b1111;
    }, 0);
    // we've exceeded the current array, lets extend it:
    if(overflow) arr.unshift(overflow);
  }
  return arr.slice(0,-l);
};

const arr = hexToArray("8079d7");
const result = doubleDabble(arr);      
console.log(result.join(""));