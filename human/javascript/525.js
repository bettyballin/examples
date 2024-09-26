var auth = { uid: 'some_uid' };
var root = {
  child: function(path) {
    return {
      child: function(path) {
        return {
          exists: function() {
            return true; // or false
          }
        }
      }
    }
  }
};

var read = root.child('usersByUid').child(auth.uid).exists();
console.log(read);