function checkAccess(isUserAdmin, doc, userId) {
  if (isUserAdmin || doc.userId === userId) {
    return true;
  } else {
    return false;
  }
}

// Example usage:
let isUserAdmin = true;
let doc = { userId: 1 };
let userId = 1;

console.log(checkAccess(isUserAdmin, doc, userId)); // Output: true

isUserAdmin = false;
doc = { userId: 2 };
userId = 1;

console.log(checkAccess(isUserAdmin, doc, userId)); // Output: false