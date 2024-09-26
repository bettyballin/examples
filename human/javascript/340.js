const users = {
  user1234abc: {
    name: "abc"
  },
  user2434dbcc: {
    name: "abc"
  }
};

const rules = {
  rules: {
    users: {
      ".read": true,
      "$uid": {
        ".write": "$uid === auth.uid"
      }
    }
  }
};

const auth = {
  uid: "user1234abc"
};

function validateWrite(userId, data) {
  const rule = rules.rules.users["$uid"];
  const condition = rule[".write"].replace("$uid", userId);
  return eval(condition.replace("auth.uid", auth.uid));
}

console.log(validateWrite("user1234abc", users["user1234abc"])); // true
console.log(validateWrite("user2434dbcc", users["user2434dbcc"])); // false