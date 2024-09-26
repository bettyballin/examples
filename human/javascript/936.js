// Create buttons
const buttons = [
  { id: "001", text: "id: 001" },
  { id: "002", text: "id: 002" },
  { id: "003", text: "id: 003" },
  { id: "004", text: "id: 004" },
  { id: "005", text: "id: 005" },
];

// Create container for buttons
const container = document.createElement("div");

// Add buttons to container
buttons.forEach((button) => {
  const btn = document.createElement("button");
  btn.dataset.id = button.id;
  btn.textContent = button.text;
  container.appendChild(btn);
});

// Add container to body
document.body.appendChild(container);