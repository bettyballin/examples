// Create an offscreen canvas and draw our base64-encoded JPEG onto that.
const imgData = 'your_base64_encoded_image_data_here';
const img = document.createElement('img');
img.src = 'data:image/jpeg;base64,' + imgData;
await img.decode();

const oc = document.createElement('canvas').getContext('2d');
oc.canvas.width = img.naturalWidth;
oc.canvas.height = img.naturalHeight;
oc.drawImage(img, 0, 0);

// Use createImageBitmap() with the desired source rectangle to
// create a bitmap of just part of the image.
const x = 10; // your choice for X coordinate in original canvas
const y = 10; // Y coordinate...
const width = 100; // Width and height as needed...
const height = 100;

const ibm = await createImageBitmap(oc.canvas, x, y, width, height);

// Draw this new bitmap directly on our visible canvas.
const myCanvas = document.getElementById('myCanvas');
const my2Dcontext = myCanvas.getContext('2d');
my2Dcontext.drawImage(ibm, 0, 0);