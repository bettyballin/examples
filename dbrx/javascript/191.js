function checkFieldsSent(request) {
    let allowedKeys = ['userRole', 'userName', 'messageType', 'userMessage', 'userHonourLevel', 'userAvatar', 'userChatPosted', 'userLevel', 'userChatMessage'];
    for (let key in request.resource.data) {
        if (!allowedKeys.includes(key)) return false;
    }
    return true;
}