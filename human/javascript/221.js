class SafeJsonResult extends JsonResult {
  constructor(data, options) {
    super(data, options);
  }

  executeResult(context) {
    context.response.write("&lt;/*");
    super.executeResult(context);
  }
}