function allowList(request, resource) {
  return request.auth !== null && (
    resource.data.access[request.auth.uid] !== undefined ||
    resource.data.access[request.auth.uid + ":R"] !== undefined ||
    resource.data.access["All:R"] !== undefined
  );
}