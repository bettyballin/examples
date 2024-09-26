Here is the executable code:


function withoutAsyncAwait() {
    return new Promise((resolve, reject) => resolve(Math.random()));
}

async function withAsyncAwait() {
    return Math.random();
}

withoutAsyncAwait().then(result => console.log("withoutAsyncAwait:", result));
withAsyncAwait().then(result => console.log("withAsyncAwait:", result));