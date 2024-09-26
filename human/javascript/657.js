axios.post('/api/save', {
  title: 'My Blog Post',
  userId: 'bergur'
})
.then((response) => {
  console.log(response);
})
.catch((error) => {
  console.error(error);
});