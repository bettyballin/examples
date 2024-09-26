app.use(function (err, req, res, next) {
  console.error(err);

  // Send a generic message to client
  return res.status(500).send('Internal Server Error');
});