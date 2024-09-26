Here is the code:



const fs = require('fs');
const sharp = require('sharp');

//...... 

let img = attBO.getImage(imgId);
            
let x = Buffer.from(img.getData());
sharp(x)
  .metadata()
  .then(metadata => {
    metadata.width;
  })
  .catch(err => {
    throw new Error("Invalid image");
  });