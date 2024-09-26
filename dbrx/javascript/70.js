var job = {
  uid: "company123",
  name: "Software Engineer",
  description: "Develop software applications",
  id: "job456"
};

var uid = "user789";

var application = {
  userUid: uid,
  companyUid: job.uid,
  jobName: job.name,
  jobDescription: job.description,
  jobId: job.id
};

console.log(application);