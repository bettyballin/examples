from accessify import private, protected


class Unit:

    @protected
    def move(self):
        pass

    @private
    def run(self):
        pass


if __name__ == "__main__":
    unit = Unit()
    unit.move()
    # unit.run()  # This will raise an error