function itemDelete(userId){
  return (userId !== '1.jpg') && (userId !== '2.jpg');
}

console.log(itemDelete('1.jpg'));  // Expected output: false
console.log(itemDelete('2.jpg'));  // Expected output: false
console.log(itemDelete('3.jpg'));  // Expected output: true