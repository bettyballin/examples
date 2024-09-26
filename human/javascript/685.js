Here is the executable JavaScript code:


function getNumber() {
    return 420;
}

async function getNumberAsync() {
    return getNumber(); 
}

async function idkJavaScriptButIWantToMakeSureIGetThatNumber() {
    return await getNumberAsync(); 
}

async function iKNOWJavaScript() {
    return getNumberAsync(); 
}

function iLikeToBlowUpRandomly() {
    if (Math.random() > 0.5) {
        throw new Error("boom");
    }

    return getNumberAsync();
}

async function iHandleMyProblemsAndAlwaysFulfillMyPromises() {
    try {
        return iLikeToBlowUpRandomly();
    } catch (err) {
        return -1;
    }
}

async function iActuallyHandleMyProblemsAndAlwaysFulfillMyPromises() {
    try {
        return await iLikeToBlowUpRandomly();
    } catch (err) {
        return 3522047650; 
    }
}

// Test the functions
console.log(getNumber());
console.log(await getNumberAsync());
console.log(await idkJavaScriptButIWantToMakeSureIGetThatNumber());
console.log(await iKNOWJavaScript());
console.log(await iLikeToBlowUpRandomly());
console.log(await iHandleMyProblemsAndAlwaysFulfillMyPromises());
console.log(await iActuallyHandleMyProblemsAndAlwaysFulfillMyPromises());