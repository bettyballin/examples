const MersenneTwister = require('mersenne-twister');

// Create a new instance of mersenne twister with seed 12345 (for demonstration purposes)
let mt = new MersenneTwister(12345);

// Generate some random numbers using the seeded generator
console.log(mt.random());
console.log(mt.random());

// Now let's assume we have two outputs from an unknown Math.random() instance:
const output1 = 0.3745401144071302;
const output2 = 0.9507143113604736;

// We can create a new MersenneTwister object and try to reconstruct the seed
let reconstructedMt = new MersenneTwister();
reconstructedMt.init_by_array([output1, output2]); // Fixed syntax error

// Now we should be able to generate future outputs that match those of Math.random()
console.log(reconstructedMt.random());