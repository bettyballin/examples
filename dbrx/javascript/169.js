const container = document.getElementById('comment-container');

container.addEventListener('keydown', (event) => {
  if (event.key === 'Enter') {
    event.preventDefault();
  }
});

container.addEventListener('paste', (event) => {
  const text = event.clipboardData.getData('text/plain');
  window.document.execCommand('insertText', false, text);
  event.preventDefault();
});

function submitComment() {
  // Get the content of the container
  let content = container.innerText;

  // Clean and sanitize the HTML on server-side

  // Submit the comment to your backend API
  console.log(content);
}

// Example button to trigger submitComment function
const submitButton = document.createElement('button');
submitButton.innerText = 'Submit Comment';
submitButton.onclick = submitComment;
document.body.appendChild(submitButton);