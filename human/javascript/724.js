const whiteList = ['/path1/', '/path2/'];

const urlParams = new URLSearchParams(window.location.search);
const path = urlParams.get('path');

if (whiteList.includes(path)) {
  // It's OK
} else {
  // Ohnoes :(
}