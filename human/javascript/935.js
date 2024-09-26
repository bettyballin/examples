(() => {
  const ID_MAP = new WeakMap();

  const onClickAction = ({ currentTarget }) => {
    // Exit if there is no ID stored
    if(!ID_MAP.has(currentTarget)) return;
    
    // Retrieve and log ID
    const id = ID_MAP.get(currentTarget);
    console.log(id);
  }
  
  const btns = document.querySelectorAll('button');
  for(const btn of btns) {
    // Skip if it doesn't have an ID
    if(!btn.dataset.id) continue;

    // Store and hide `data-id` attribute
    ID_MAP.set(btn, btn.dataset.id);
    btn.removeAttribute('data-id');

    // Add event listener
    btn.addEventListener('click', onClickAction, false);
  }
})();