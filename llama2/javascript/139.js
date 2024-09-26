const id = this.getView().getModel().getProperty("/ID");
const url = `/api/data?id=${id}`;
window.open(url);


html
<!DOCTYPE html>
<html>
<head>
  <title>Executable Code</title>
</head>
<body>
  <script>
    class View {
      getModel() {
        return {
          getProperty: (property) => {
            if (property === "/ID") {
              return "12345"; // Replace with actual ID
            }
          }
        };
      }
    }

    class Controller {
      getView() {
        return new View();
      }

      executeCode() {
        const id = this.getView().getModel().getProperty("/ID");
        const url = `/api/data?id=${id}`;
        window.open(url);
      }
    }

    const controller = new Controller();
    controller.executeCode();
  </script>
</body>
</html>