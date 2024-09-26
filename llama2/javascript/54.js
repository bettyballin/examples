// Import md5 library
const md5 = require('md5');

// Define HTML content
const htmlContent = `
  <script>
    // Assume this is the question and hashed answer
    const question = 'What is the color of the sky?';
    const hashedAnswer = 'hashed_answer_from_server';
  </script>
`;

// Parse HTML content using DOMParser
const parser = new DOMParser();
const doc = parser.parseFromString(htmlContent, 'text/html');

// Get the question and hashed answer from the HTML content
const question = doc.querySelector('script').textContent.trim();
const hashedAnswer = 'hashed_answer_from_server'; // Get from server or somewhere else

// Recreate the salted hash in JavaScript
const salt = 'some_random_string';
const userAnswer = 'blue';
const hashedUserAnswer = md5(userAnswer + salt);

if (hashedUserAnswer === hashedAnswer) {
  console.log('Correct answer!');
} else {
  console.log('Incorrect answer :(');
}