const request = { auth: null }; // Mock request object

function isSignedIn(){
    return request.auth != null;
}

// Mock Firebase rules API
function allow(action, condition) {
    console.log(`Allow ${action}: ${condition}`);
}

match = function(path) {
    return {
        allow: (action, condition) => allow(action, condition)
    };
};

// Usage
request.auth = { uid: 'some_uid' }; // Simulate signed-in user
match('/Users/{userId}/{documents=**}').allow('read, write', isSignedIn());