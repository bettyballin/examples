function timeout(milliseconds) {
    return new Promise(resolve => window.setTimeout(resolve, milliseconds));
}

timeout(2000).then(() => console.log("Timeout resolved after 2000ms"));