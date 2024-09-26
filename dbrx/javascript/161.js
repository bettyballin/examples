const express = require('express');
const Joi = require('joi');

const app = express();

// Define the expected options format.
const optionSchema = Joi.object().keys({
  dotfiles: Joi.string(),
  etag: Joi.boolean(),
  extensions: Joi.array().items(Joi.string()),
  index: Joi.any(),
  maxAge: Joi.string(),
  redirect: Joi.boolean(),
  setHeaders: Joi.func()
});

// Validate user input.
const validateOptions = (options) => {
  const { error } = optionSchema.validate(options);
  
  if (error) throw new Error(error.message);

  return options;
};

const options = {
  dotfiles: 'ignore',
  etag: true,
  extensions: ['htm', 'html'],
  index: 'index.html',
  maxAge: '1d',
  redirect: false,
  setHeaders: (res, path, stat) => {
    res.set('x-timestamp', Date.now());
  }
};

app.use(express.static('public', validateOptions(options)));

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});