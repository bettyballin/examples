Here is the executable JavaScript code:


async function takes12SecondsTotal() {
    const result1 = await takes7Seconds();
    const result2 = await takes5Seconds(); 
    return [result1, result2];
}

async function takes7SecondsTotal() {
    const [result1, result2] = await Promise.all([
        takes7Seconds(),
        takes5Seconds()
    ]);
    return [result1, result2];
}

function nottttttActuallyyyyyTheSammeeeeIKnowIKnowScrewErrorHandling() {
    return Promise.all([
        takes7Seconds(),
        takes5Seconds()
    ]);
}

function thisIsFunctionallyTheSame() {
    try {
        return Promise.all([
            takes7Seconds(),
            takes5Seconds()
        ]);
    } catch (err) {
        return Promise.reject(err);
    }
}

async function justBeSmartAndUseAsync() {
    return Promise.all([
        takes7Seconds(),
        takes5Seconds()
    ]);
}

// Helper functions
function takes7Seconds() {
    return new Promise(resolve => {
        setTimeout(() => {
            resolve("7 seconds");
        }, 7000);
    });
}

function takes5Seconds() {
    return new Promise(resolve => {
        setTimeout(() => {
            resolve("5 seconds");
        }, 5000);
    });
}

// Test the functions
takes12SecondsTotal().then(result => console.log(result));
takes7SecondsTotal().then(result => console.log(result));
notttttttActuallyyyyyTheSammeeeeIKnowIKnowScrewErrorHandling().then(result => console.log(result));
thisIsFunctionallyTheSame().then(result => console.log(result));
justBeSmartAndUseAsync().then(result => console.log(result));