const fs = require('fs');
const certificatePath = '[path to your certificate file]'; // replace with your certificate path
const ca = [fs.readFileSync(certificatePath, {encoding: 'utf-8'})];