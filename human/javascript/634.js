const childProcess = require('child_process');

childProcess.execSync(`openssl pkcs8 -topk8 -nocrypt -in tradfile.pem -out p8file.pem`);