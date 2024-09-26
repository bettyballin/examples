const buttons = document.querySelectorAll('button');

buttons.forEach(button => {
  button.addEventListener('click', () => {
    console.log(`Button with id ${button.getAttribute('data-id')} clicked!`);
  });
});