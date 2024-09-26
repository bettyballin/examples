const getRandomInt = (min, max) => {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min + 1)) + min;
};

function getSalt() {
  const arr = new Array(32).fill().map(() => getRandomInt(0, 255));
  return Buffer.from(arr);
}

// Test the code
console.log(getSalt());