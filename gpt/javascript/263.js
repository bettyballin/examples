
const crypto = require('crypto');

const buf = Buffer.from('4DB79D009E6E0F59BC67879BDE67F4CDD9E2582794F80CFFF30321C2BDF85CCD', 'hex');
const hmac = crypto.createHmac('sha256', buf);
hmac.update('Hello world
