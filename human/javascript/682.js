function makeAsyncRequest() {
  return new Promise(resolve => {
    // Simulating an async request
    setTimeout(() => {
      resolve();
    }, 1000);
  });
}

function doStuffWithoutAsyncAwait1(needToMakeAsyncRequest) {
  const promise = needToMakeAsyncRequest ? makeAsyncRequest() : Promise.resolve();

  return promise.then(() => {
    console.log("tons of code omitted here, imagine like 30 lines...");
  });
}

function doStuffWithoutAsyncAwait2(needToMakeAsyncRequest) {
  if (needToMakeAsyncRequest) {
    return makeAsyncRequest().then(() => {
      console.log("tons of code omitted here, imagine like 30 lines...");
    });
  }
  
  console.log("tons of code omitted here, imagine like 30 lines...");
}

async function cmereAsyncAwaitYouSexyBoiYou(needToMakeAsyncRequest) {
  if (needToMakeAsyncRequest) {
    await makeAsyncRequest();
  }

  console.log("tons of code omitted here, imagine like 30 lines...");
}

// Test the functions
doStuffWithoutAsyncAwait1(true);
doStuffWithoutAsyncAwait2(true);
cmereAsyncAwaitYouSexyBoiYou(true);