
app.use((req, res, next) => {
  res.setHeader("Content-Security-Policy", "connect-src 'self' ws://localhost:8080");
  next();
});

