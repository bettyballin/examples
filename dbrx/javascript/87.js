// Create offscreen canvas and draw diagram on it (without using any cross-origin images)
const cleanCanvas = document.createElement('canvas');
cleanCanvas.width = 500;
cleanCanvas.height = 300;

const ctxClean = cleanCanvas.getContext('2d');

ctxClean.fillStyle = 'green';
ctxClean.fillRect(10, 10, 50, 80);

// Convert the offscreen canvas to a Data URL
const dataUrl = cleanCanvas.toDataURL();

// Create an anchor tag with download attribute set and point it towards that data URI/Blob.
const link = document.createElement('a');
link.href = dataUrl;
link.download = 'diagram.png';
document.body.appendChild(link);
link.click();