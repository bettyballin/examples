let i = 0;
function wrappedWhile(condition, action) {
  while (condition()) {
    action();
    i++;
  }
}

wrappedWhile(() => i < 5, () => console.log('Logged!'));