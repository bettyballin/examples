// index.tsx
import React from "react";
import ReactDOM from "react-dom";

function disableReactDevTools() {
  if (typeof window !== "undefined") {
    const originalConsoleLog = console.log;
    console.log = (...args) => {
      if (args[0].includes("Download the React DevTools")) return;
      originalConsoleLog(...args);
    };
  }
}

if (process.env.NODE_ENV === "production") disableReactDevTools();

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById("root")
);