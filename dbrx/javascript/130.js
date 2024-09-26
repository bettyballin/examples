const iframe = document.createElement('iframe');
iframe.src = 'https://example.com';
iframe.onload = () => {
  console.log('Iframe loaded!');
};
document.body.appendChild(iframe);