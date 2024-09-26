const createConfig = () => {
  const config = {};

  Object.defineProperty(config, "gridSize", { value: 64, writable: false });

  return (() => ({
    getGridSize: function() {
      return config.gridSize;
    }
  }));
};

const myConfig = createConfig();
console.log(myConfig().getGridSize()); // Outputs: 64

// Attempt to modify the grid size
try {
  myConfig().config.gridSize = 32;
} catch (e) {}

console.log(myConfig().getGridSize()); // Still outputs: 64