var hash = {}, key = "something-evil", value = Math.PI;
hash["$" + key] = value;
console.log( hash["$" + key] == value );