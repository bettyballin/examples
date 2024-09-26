from twisted.application import service, app

class MyService(service.MultiService):
    is_shutting_down = False

    def startService(self):
        self.send_traceback = False
        return service.MultiService.startService(self)

application = service.Application("My Service")
my_service = MyService()
my_service.setServiceParent(application)