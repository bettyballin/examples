const scores = {
  "Score": 1166,
  "Richards": 2595,
  "DeltaBlue": 2147,
  "Crypto": 2227,
  "RayTrace": 1252,
  "EarleyBoyer": 3583,
  "RegExp": 396,
  "Splay": 310,
  "NavierStokes": 502
};

const sortedScores = Object.entries(scores).sort((a, b) => a[1] - b[1]);

for (const [name, score] of sortedScores) {
  console.log(`${name}: ${score}`);
}