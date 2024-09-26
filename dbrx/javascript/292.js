function itemDelete(userId){
  return !(userId == '1.jpg' || userId == '2.jpg');
}

console.log(itemDelete('1.jpg'));  // false
console.log(itemDelete('2.jpg'));  // false
console.log(itemDelete('3.jpg'));  // true