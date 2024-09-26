const data = { val: 1 };
const newData = { val: 2 };

const validate = newData.isNumber() && newData.val() === data.val() + 1;

console.log(validate); // true