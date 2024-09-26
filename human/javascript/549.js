const obj = {
  newuser: {
    $pushId: {
      tagid: 0
    }
  }
};

obj.newuser.$pushId.tagid = 123; // example integer value

console.log(obj);