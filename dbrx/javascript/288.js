import { getStorage, ref, uploadBytes } from "firebase/storage";

const storage = getStorage();
const imageRef = ref(storage, 'images/someImg.jpg');
const file = new File([""], "someImg.jpg", {type: "image/jpeg"});

uploadBytes(imageRef, file).then((snapshot) => {
  console.log('Uploaded a blob or file!');
}).catch((error) => {
  console.error(error);
});