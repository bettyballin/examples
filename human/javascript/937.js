(() => {
  const ID_MAP = new WeakMap();

  const onClickAction = ({ target }) => {
    // Exit if it's not a button
    if(target.nodeName !== 'BUTTON') return;
  
    // Exit if there is no ID stored
    if(!ID_MAP.has(target)) return;
    
    // Retrieve and log ID
    const id = ID_MAP.get(target);
    console.log(id);
  }
  
  const btns = document.querySelectorAll('button');
  for(const btn of btns) {
    // Skip if it doesn't have an ID
    if(!btn.dataset.id) continue;

    // Store and hide `data-id` attribute
    ID_MAP.set(btn, btn.dataset.id);
    btn.removeAttribute('data-id');
  }
  
  // Add event listener, instead of `document` you can also use a common parent container
  document.addEventListener('click', onClickAction, false);
})();