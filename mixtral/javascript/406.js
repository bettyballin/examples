const stripJsonComments = require('strip-json-comments');

// Your malicious json
let invalidJSON = '{ "": "" }';

try {
  // Try to parse the input
  let parsedInput = JSON.parse(invalidJSON);

} catch (error) {
  console.log(`Invalid Input: ${error}`);

  try {
    // Remove comments and log sanitized json
    invalidJSON = stripJsonComments(invalidJSON).trim();

    if (!isValidJSONString(invalidJSON))
      throw new Error('Still not a valid JSON');

    let parsedInput = JSON.parse(invalidJSON);

  } catch (error) {
     console.log(`Failed to sanitize: ${error}`);

   // Log the original invalid input
   logInvalidRequest({
       timestamp: new Date(),
       requestBody: invalidJSON
      });

    return;

  }

}

// Function to check if a string is valid JSON
function isValidJSONString(str) {
 try {
     let json = JSON.parse(str);

   // If no exception was thrown the input is valid
      return true;

    } catch (e) {}

  return false;
}

// Function to log invalid requests
function logInvalidRequest({ timestamp, requestBody }) {

 console.log(`[${timestamp}] Invalid Request: ${JSON.stringify(requestBody)}`);

 // Log the sanitized input

}