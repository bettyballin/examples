const wrappedWhile = (condition, callback) => {
  let iterate = true;

  (function iter() {
    if (!iterate) return;
    callback();
    iterate = condition();
    if (iterate) iter();
  })();
}

// Test the function
let i = 0;
wrappedWhile(() => i < 5, () => {
  console.log(i);
  i++;
});