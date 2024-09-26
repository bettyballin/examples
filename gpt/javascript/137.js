
function setUserId(userId){
    // Convert the userId to a string before writing to the encrypted cache
    var userIdStr = userId.toString();
    WL.EncryptedCache.write("USER_ID", userIdStr, onCompleteHandler, onErrorHandler);
}

