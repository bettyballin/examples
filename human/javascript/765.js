// Define a sample request and resource objects for demonstration purposes
let request = {
  resource: {
    data: {
      userRole: 'admin',
      userName: 'John Doe',
      messageType: 'text',
      userMessage: 'Hello, world!',
      userHonourLevel: 5,
      userAvatar: 'avatar.jpg',
      userChatPosted: true,
      userLevel: 10,
      userChatMessage: 'Hello, again!'
    }
  }
};

let resource = {
  data: {
    userRole: 'admin',
    userName: 'John Doe',
    messageType: 'text',
    userMessage: 'Hello, world!',
    userHonourLevel: 5,
    userAvatar: 'avatar.jpg',
    userChatPosted: true,
    userLevel: 10,
    userChatMessage: 'Hello, again!'
  }
};

// Define the checkFieldsSent function
function checkFieldsSent() {
  let forbiddenfields = ['userRole', 'userName', 'messageType', 'userMessage', 'userHonourLevel', 'userAvatar', 'userChatPosted', 'userLevel', 'userChatMessage'];
  
  // Implement diff and affectedKeys functions for demonstration purposes
  function diff(data1, data2) {
    let diff = {};
    Object.keys(data1).forEach(key => {
      if (data1[key] !== data2[key]) {
        diff[key] = data1[key];
      }
    });
    return diff;
  }
  
  function affectedKeys(data) {
    return Object.keys(data);
  }
  
  function hasAny(data, keys) {
    return keys.some(key => Object.keys(data).includes(key));
  }
  
  return !hasAny(diff(request.resource.data, resource.data), forbiddenfields);
}

// Execute the checkFieldsSent function
console.log(checkFieldsSent());