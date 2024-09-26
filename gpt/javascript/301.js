
const wrappedWhile = (conditionFunc, callback) => {
  let avoidInfinite = 0;

  while (conditionFunc()) {
    callback();

    if (avoidInfinite >= 10) {
      console.log('Breaking while statement to avoid infinite loop');
      break;
    }

    avoidInfinite++;
  }
};

let i = 0;

wrappedWhile(() => i < 5, () => {
  console.log('Log from callback: i =', i);
  i++;
});

