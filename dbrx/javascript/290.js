import { getStorage, ref, getDownloadURL } from "firebase/storage";

const storage = getStorage();
const imageRef = ref(storage, 'images/someImg.jpg');

getDownloadURL(imageRef).then((url) => {
  // This can be downloaded directly:
  const xhr = new XMLHttpRequest();
  xhr.responseType = 'blob';
  xhr.onload = (event) => { 
    const blob = xhr.response;
  };
  xhr.open('GET', url);
  xhr.send();

  // Or inserted into an <img> element
  const img = document.getElementById('myimg');
  img.setAttribute('src', url);

}).catch((error) => {
  console.error(error);
});