const o = 256;

const fetch = x => {
  if (x >= o) return x;
  else return ((x * x) % o);
};

// For generating random values within the desired range.
function build(n, maxVal) {
  let result = [];
  for (let i = 0; i < n; ++i) {
    const randNum = fetch(Math.floor(Math.random() * maxVal));
    if (!result.includes(randNum)) result.push(randNum);
  }
  return result;
}

// Generate random values within the desired range.
const build8 = () => build(256, 255).sort((a, b) => a - b);

console.log(build8());