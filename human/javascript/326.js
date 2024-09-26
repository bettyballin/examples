const contentSecurityPolicy = {
  "default-src": ["'self'"],
  "connect-src": ["ws:"],
  "style-src": ["'self'"]
};

const content = Object.keys(contentSecurityPolicy).map(key => {
  return `${key} ${contentSecurityPolicy[key].join(' ')}`;
}).join('; ');

console.log(content);