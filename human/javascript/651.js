const wrappedWhile = (conditions, callback) => {
  let i = 0;

  while (conditions(i)) {
    callback(i);
    
    if (i >= 10) {
      console.log('breaking while statement for avoiding infinite loop');
      break;
    }
    
    i++;
  }
};

wrappedWhile((i) => (i < 5), (iteration) => {
  console.log('log from callback: i =', iteration);
});