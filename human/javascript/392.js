class FirebaseApp {
  constructor() {
    this.refApp = {
      child: () => {
        return {
          push: (data) => {
            console.log(data);
          }
        }
      }
    };
    this.uid = 'exampleUid';
    this.application = { foo: 'bar' };
  }

  pushApplication() {
    this.refApp.child(this.uid).push(this.application);
  }
}

const app = new FirebaseApp();
app.pushApplication();