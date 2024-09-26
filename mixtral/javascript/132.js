app.get('/user/posts/:id', isLoggedIn, function(req, res) {
  var x = decrypt(req.params.id);

  // Convert the string to ObjectId
  const objectID = mongoose.Types.ObjectId(x);

  Posts.findOne({userID: objectID}, function(err, post) {
    if (err) {
      console.log(err);
      res.status(500).json({message: "Internal Server Error"});
    } else if (post) {
      res.json(post);
    } else if (!post) {
      res.json({message: "No Posts document exists for this user"});
    }
  });
});