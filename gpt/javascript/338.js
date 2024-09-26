
app.use((req, res, next) => {
  const authHeader = req.headers['authorization'];
  
  if (authHeader) {
    const parts = authHeader.split(' ');
    const scheme = parts[0];
    const credentials = parts[1];

    if (/^Bearer
