function saveFile(filepath, filename) {
  try {
    const fs = require('fs');
    const theDir = `${filepath}`;

    if (fs.existsSync(theDir)) {
      console.log("Directory Exists");
    } else {
      console.log("Creating Directory...");
      fs.mkdirSync(theDir);
      if (fs.existsSync(theDir)) {
        console.log("Directory Created");
      } else {
        console.log("Directory Creation Failed!");
      }
    }
  } catch (e) {
    console.log("Error Reading Directory!");
    console.log(filepath);
  }
  // More code for working with files
}