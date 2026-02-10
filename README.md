# Reflection 1

In this module, I have applied several Clean Code principles such as Meaningful Names for my controllers and services. I also practiced Secure Coding by using UUIDs instead of predictable numeric IDs to prevent direct object reference attacks. However, I realized my Input Validation is still weak because I haven't checked for negative quantities, which I plan to fix using Spring Validation in the next iteration.

# Reflection 2

1. Writing unit tests gives me a sense of security, knowing that my code functions as intended. In my opinion, the number of tests should depend on the complexity of the methods.
To ensure sufficiency, I use Code Coverage tools. However, even with 100% coverage, it doesn't mean the code is bug-free. Coverage only shows that the code has been executed, but it doesn't guarantee that the test cases cover every possible edge case or logical error, such as unexpected user input or integration issues.
2. If I create a new functional test suite by copying the setup procedures and instance variables from the previous suite, the code quality will likely decrease due to Code Duplication (DRY principle violation).

Having identical setup code in multiple classes makes the project harder to maintain. For instance, if the server configuration changes, I would need to update every single test class manually.

To improve this, I should apply a Base Class approach. I can move the common setup (like @LocalServerPort and baseUrl initialization) into a parent class and have all functional test classes inherit from it. This way, the code remains clean, modular, and easier to maintain