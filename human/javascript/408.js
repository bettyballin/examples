const twinBcrypt = require('twin-bcrypt');
const bcrypt = require('bcrypt');

const string = 'helloworld';

const bcryptAttempt = bcrypt.compareSync(string, "$2y$10$Am0Nf/B6.S/Wkpr6IVdIZeuHWNa/fqoLyTNmlyrSg22AjRf2vS.T.".replace(/^\$2y/, "$2a"));
console.log(bcryptAttempt);

const twinBcryptAttempt = twinBcrypt.compareSync(string, "$2y$10$Am0Nf/B6.S/Wkpr6IVdIZeuHWNa/fqoLyTNmlyrSg22AjRf2vS.T.");
console.log(twinBcryptAttempt);