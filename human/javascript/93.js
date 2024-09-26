const data = {
  "Score": 8574,
  "Richards": 9362,
  "DeltaBlue": 14903,
  "Crypto": 15677,
  "RayTrace": 13468,
  "EarleyBoyer": 24823,
  "RegExp": 2805,
  "Splay": 4600,
  "NavierStokes": 3096,
};

const sortedData = Object.keys(data).sort((a, b) => data[b] - data[a]);

sortedData.forEach(key => console.log(`${key}: ${data[key]}`));