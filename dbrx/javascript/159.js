const express = require('express');
const router = express.Router();
const Joi = require('joi');
const Map = require('./models/Map'); // Assuming you have a Map model defined

// Define the schema for validating user inputs
const mapSchema = Joi.object().keys({
  id: Joi.string().regex(/^[0-9a-fA-F]{24}$/).required()
});

router.get('/getOne', async (req, res, next) => {
  try {
    // Validate and sanitize the request parameters using joi
    const { value, error } = mapSchema.validate(req.query);

    if (error) {
      throw new Error('Invalid input');
    }

    const mapData = await Map.findById(value.id);
    res.json(mapData);
  } catch (e) {
    return next(e);
  }
});

module.exports = router;