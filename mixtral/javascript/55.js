function setUserId(userId){
    WL.EncryptedCache.write("USER_ID", String(userId), onCompleteHandler, onErrorHandler);
}

// Define the onCompleteHandler and onErrorHandler functions
function onCompleteHandler() {
    console.log("User ID stored successfully");
}

function onErrorHandler(error) {
    console.log("Error storing User ID: " + error);
}

// Call the setUserId function
setUserId("12345");