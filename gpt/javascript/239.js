
ref.update({ /* your update data */ })
  .then(() => {
    console.log('Update succeeded');
  })
  .catch((error) => {
    console.log('Update failed: ' +
