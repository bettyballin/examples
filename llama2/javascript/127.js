const listener = (event) => {
  const origin = new URL(event.origin);
  if (!origin.href === window.location.origin) return;

  const data = JSON.parse(event.data);
  if (!('type' in data && 'action' in data && 'id' in data)) return;

  console.log(data);
};

window.addEventListener('message', listener);