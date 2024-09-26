function* computeHash(url) {
  // Replace this with your actual hash computation logic
  return `Hash of ${url}`;
}

function* main() {
  try {
    const hash = yield computeHash('http://arxiv.org/pdf/1001.1234v3.pdf');
    console.log(hash);
  } catch (err) {
    console.error(`Error computing the hash: ${err}`);
  }
}

const iterator = main();
iterator.next();
iterator.next(iterator.next().value);