// There is no direct JavaScript equivalent for the provided Firestore security rule.
// However, to illustrate how you might implement similar logic in a Node.js 
// environment using the Firebase Firestore SDK, consider the example below:

const admin = require('firebase-admin');
admin.initializeApp();

const db = admin.firestore();

async function getPost(blogId, postId) {
  const postRef = db.collection('blog').doc(blogId).collection('posts').doc(postId);
  try {
    const post = await postRef.get();
    if (post.exists) {
      console.log(post.data());
    } else {
      console.log('Post not found');
    }
  } catch (error) {
    console.error(error);
  }
}

getPost('exampleBlogId', 'examplePostId');