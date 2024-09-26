
   const Ajv = require("ajv");
   const ajv = new Ajv();
   const validate = ajv.compile(yourJsonSchema);

   if (!validate(jsonData)) {
       console.error("Validation failed:", validate.errors);
       // Handle the validation errors
   }
   
