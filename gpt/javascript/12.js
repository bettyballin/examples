
// In a Node.js Express app
app.use((req, res, next) => {
  res.setHeader('X-Frame-Options', 'DENY'); // or 'SAMEORIGIN' if you want to allow your own domain
  next();
});

