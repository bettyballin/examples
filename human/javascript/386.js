const decorators = {
  defaultdir: "/WEB-INF/decorators",
  excludes: [
    { pattern: "*blah.ctl*" }
  ],
  decorators: [
    {
      name: "foo",
      page: "myDecorator.jsp",
      pattern: "*"
    }
  ]
};