function allowList(request, resource) {
  return request.auth !== null && request.auth.uid in resource.data.access;
}