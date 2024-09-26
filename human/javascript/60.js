class User extends SharedUser {
  defaults = _.extend({ domainId: null }, SharedUser.defaults);

  password(cleartext, confirm, callback) {
    const errorInfo = new errors.InvalidData();
    if (cleartext !== confirm) {
      errorInfo.message = 'please type the same password twice';
      errorInfo.errors.confirmPassword = 'must match the password';
      return callback(errorInfo);
    }
    const message = min4(cleartext);
    if (message) {
      errorInfo.message = message;
      errorInfo.errors.password = message;
      return callback(errorInfo);
    }
    const self = this;
    bcrypt.genSalt(10, (error, salt) => {
      if (error) {
        errorInfo = new errors.InternalError(error.message);
        return callback(errorInfo);
      }
      bcrypt.encrypt(cleartext, salt, (error, hash) => {
        if (error) {
          errorInfo = new errors.InternalError(error.message);
          return callback(errorInfo);
        }
        self.attributes.bcryptedPassword = hash;
        return callback();
      });
    });
  }

  verifyPassword(cleartext, callback) {
    bcrypt.compare(cleartext, this.attributes.bcryptedPassword, (error, result) => {
      if (error) {
        return callback(new errors.InternalError(error.message));
      }
      callback(null, result);
    });
  }
}