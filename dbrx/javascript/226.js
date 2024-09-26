// No executable code is provided as the code snippet is in a specific 
// Firestore security rules syntax and not in JavaScript. However, I 
// will provide an equivalent representation of the security rule in 
// JavaScript for illustration purposes.

const allowList = (request) => {
  return request.query.filters.size() == 1 
    && request.query.filters[0].field.path == "fieldId";
};

// Example usage:
const request = {
  query: {
    filters: [
      {
        field: {
          path: "fieldId"
        }
      }
    ]
  }
};

console.log(allowList(request));  // Output: true