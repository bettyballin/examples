refApp.child(this.uid).child(job.id).update({
  [job.id]: this.application
});