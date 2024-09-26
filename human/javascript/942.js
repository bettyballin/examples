const devContentSecurityPolicy = {
  "default-src": ["*", "self", "blob:", "data:", "gap:"],
  "style-src": ["*", "self", "'unsafe-inline'", "blob:", "data:", "gap:"],
  "script-src": ["*", "'self'", "'unsafe-eval'", "'unsafe-inline'", "blob:", "data:", "gap:"],
  "object-src": ["*", "'self'", "blob:", "data:", "gap:"],
  "img-src": ["*", "self", "'unsafe-inline'", "blob:", "data:", "gap:"],
  "connect-src": ["self", "*", "'unsafe-inline'", "blob:", "data:", "gap:"],
  "frame-src": ["*", "self", "blob:", "data:", "gap:"]
};

const contentSecurityPolicyString = Object.keys(devContentSecurityPolicy).map(key => {
  return `${key} ${devContentSecurityPolicy[key].join(' ')}`;
}).join('; ');

console.log(contentSecurityPolicyString);