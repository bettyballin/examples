function hasUnauthorizedKey(request) {
    let allowedKeys = ['userRole', 'userName', 'messageType', 'userMessage', 'userHonourLevel', 'userAvatar', 'userChatPosted', 'userLevel', 'userChatMessage'];
    return Object.keys(request.resource.data).some(key => !allowedKeys.includes(key));
}