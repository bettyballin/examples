let criteria = {};
let propParts = ["name", "John"];
criteria[propParts[0]] = new RegExp(propParts[1], "i");
console.log(criteria);