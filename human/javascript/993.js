const config = {
  "production": {
    "buildOptimizer": true,
    "optimization": false,
    "vendorChunk": true,
    "extractLicenses": true,
    "sourceMap": true,
    "namedChunks": true,
    "fileReplacements": [
      {
        "replace": "src/environments/environment.ts",
        "with": "src/environments/environment.prod.ts"
      }
    ],
    "outputHashing": "all"
  }
};

console.log(config);