function shuffleArray(dataArray) {
  const byteArray = new Uint8Array(Math.ceil(dataArray.length / 256));
  window.crypto.getRandomValues(byteArray);

  for (let i = dataArray.length - 1; i > 0; --i) {
    let j = Math.floor((byteArray[i % byteArray.byteLength] * (i + 1)) / 255);
    [dataArray[i], dataArray[j]] = [dataArray[j], dataArray[i]];
  }

  return dataArray;
}

// Test the function
let arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
console.log(shuffleArray(arr));