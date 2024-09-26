function checkUrl(url) {
  const target = "http://www.example.com";
  const targetPort = 80;

  try {
    const parsedUrl = new URL(url);
    if (parsedUrl.protocol !== "http:") return "Failure: different protocol";
    if (parsedUrl.hostname !== "www.example.com") return "Failure: different hostname";
    if (parsedUrl.port && parsedUrl.port !== targetPort.toString()) return "Failure: different port";
    return "Success";
  } catch (e) {
    return `Error: ${e.message}`;
  }
}

const urls = [
  "http://www.example.com/home/other.html",
  "http://www.example.com/dir/inner/another.php",
  "http://www.example.com:80",
  "http://www.example.com:2251",
  "http://data.example.com/dir/other.html",
  "https://www.example.com/home/index.html:80",
  "ftp://www.example.com:21",
  "https://google.com/search?q=james+bond"
];

for (const url of urls) {
  console.log(`${url} -> ${checkUrl(url)}`);
}