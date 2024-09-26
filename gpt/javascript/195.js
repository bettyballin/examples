
// Assuming `this.application` is the object you want to save
// And `this.refApp` is a reference to the base of your database
this.application.userUid = this.uid;
this.application.companyUid = job.uid;
this.application.jobName = job.name;
this.application.jobDescription = job.description;
this.application.jobId = job.id;

// Set the application object at the correct path
this.refApp
