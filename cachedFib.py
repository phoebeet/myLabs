def main():
    if input("cached? (y/n) ") == "y":
        my_fib = FibCached()
    else:
        my_fib = Fib()
    print(my_fib.fib(10))

class Fib:
    beginning_nums = (0, 1, 1)
    def fib(self, in_num):
        if in_num < 3:
            return self.beginning_nums[in_num]
        return self.fib(in_num - 1) + self.fib(in_num - 2)

class FibCached(Fib):
    def __init__(self):
        self.cache = {}
    def fib(self, in_num):
        if in_num not in self.cache:
            self.cache[in_num] = super().fib(in_num)
        return self.cache[in_num]

main()
