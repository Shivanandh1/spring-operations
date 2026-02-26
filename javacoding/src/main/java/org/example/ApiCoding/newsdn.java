package org.example.ApiCoding;

// ============================================
// INTERMEDIATE CORE JAVA EXAMPLES
// ============================================

// 1. PriorityQueue Example
import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

class Task implements Comparable<Task> {
    String name;
    int priority;

    Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return name + " (Priority: " + priority + ")";
    }
}

class PriorityQueueExample {
    public static void demo() {
        PriorityQueue<Task> taskQueue = new PriorityQueue<>();
        taskQueue.offer(new Task("Low Priority Task", 3));
        taskQueue.offer(new Task("High Priority Task", 1));
        taskQueue.offer(new Task("Medium Priority Task", 2));

        System.out.println("Processing tasks by priority:");
        while (!taskQueue.isEmpty()) {
            System.out.println(taskQueue.poll());
        }
    }
}

// 2. Enum Example
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public boolean isWeekend() {
        return this == SATURDAY || this == SUNDAY;
    }
}

class EnumExample {
    public static void demo() {
        for (Day day : Day.values()) {
            System.out.println(day + " is weekend: " + day.isWeekend());
        }
    }
}

// 3. Builder Pattern Example
class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final int age;

    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.age = builder.age;
    }

    static class UserBuilder {
        private String firstName;
        private String lastName;
        private String email;
        private int age;

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}

class BuilderPatternExample {
    public static void demo() {
        User user = new User.UserBuilder()
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john@example.com")
                .setAge(30)
                .build();
        System.out.println(user);
    }
}

// 4. Inner Classes Example
class OuterClass {
    private String outerField = "Outer Field";

    // Non-static inner class
    class InnerClass {
        void display() {
            System.out.println("Accessing from inner: " + outerField);
        }
    }

    // Static nested class
    static class StaticNestedClass {
        void display() {
            System.out.println("Static nested class");
        }
    }

    void demonstrateAnonymousClass() {
        // Anonymous inner class
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous inner class");
            }
        };
        runnable.run();
    }
}

// 5. Marker Interface Example
interface Transmittable {
    // Marker interface - no methods
}

class SecureData implements Transmittable {
    private String data;

    SecureData(String data) {
        this.data = data;
    }
}

class DataTransmitter {
    public static void transmit(Object obj) {
        if (obj instanceof Transmittable) {
            System.out.println("Transmitting secure data");
        } else {
            System.out.println("Cannot transmit - not marked as Transmittable");
        }
    }
}

// 6. HashMap with Custom Key Example
class CustomKey {
    private String id;
    private String name;

    CustomKey(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomKey key = (CustomKey) o;
        return Objects.equals(id, key.id) && Objects.equals(name, key.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

class HashMapExample {
    public static void demo() {
        Map<CustomKey, String> map = new HashMap<>();
        CustomKey key1 = new CustomKey("1", "John");
        map.put(key1, "Developer");

        CustomKey key2 = new CustomKey("1", "John");
        System.out.println("Value: " + map.get(key2)); // Works due to proper equals/hashCode
    }
}

// 7. Collections.sort() Example
class Person implements Comparable<Person> {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

class SortingExample {
    public static void demo() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Sort using natural ordering
        Collections.sort(people);
        System.out.println("Sorted by age: " + people);

        // Sort using custom comparator
        Collections.sort(people, Comparator.comparing(p -> p.name));
        System.out.println("Sorted by name: " + people);
    }
}



class Employee implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private transient String password; // Won't be serialized
    private static String company = "TechCorp"; // Static fields not serialized

    Employee(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age +
                ", password='" + password + "', company='" + company + "'}";
    }
}

class SerializationExample {
    public static void demo() throws IOException, ClassNotFoundException {
        Employee emp = new Employee("John Doe", 30, "secret123");

        // Serialize
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream("employee.ser"))) {
            oos.writeObject(emp);
        }

        // Deserialize
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("employee.ser"))) {
            Employee deserializedEmp = (Employee) ois.readObject();
            System.out.println("Deserialized: " + deserializedEmp);
            // Note: password will be null, company keeps its current value
        }
    }
}

// ============================================
// JAVA 8 EXAMPLES
// ============================================

// 9. Lambda Expressions Example
class LambdaExample {
    public static void demo() {
        // Traditional approach
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Traditional runnable");
            }
        };

        // Lambda expression
        Runnable r2 = () -> System.out.println("Lambda runnable");

        r1.run();
        r2.run();

        // Lambda with parameters
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(name -> System.out.println("Hello, " + name));
    }
}

// 10. Functional Interface Example
@FunctionalInterface
interface Calculator {
    int calculate(int a, int b);

    // Default method is allowed
    default void display() {
        System.out.println("Calculator interface");
    }
}

class FunctionalInterfaceExample {
    public static void demo() {
        Calculator add = (a, b) -> a + b;
        Calculator multiply = (a, b) -> a * b;

        System.out.println("5 + 3 = " + add.calculate(5, 3));
        System.out.println("5 * 3 = " + multiply.calculate(5, 3));
    }
}

// 11. Stream API Examples
class StreamExample {
    public static void demo() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter and collect
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // Map transformation
        List<Integer> squared = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squared: " + squared);

        // Reduce operation
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        // FlatMap example
        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );

        List<Integer> flattened = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("Flattened: " + flattened);
    }
}

// 12. Optional Example
class OptionalExample {
    public static void demo() {
        // Creating Optional
        Optional<String> optional1 = Optional.of("Hello");
        Optional<String> optional2 = Optional.ofNullable(null);
        Optional<String> optional3 = Optional.empty();

        // Using Optional
        System.out.println("Value present: " + optional1.isPresent());
        optional1.ifPresent(value -> System.out.println("Value: " + value));

        // orElse and orElseGet
        String result1 = optional2.orElse("Default Value");
        String result2 = optional2.orElseGet(() -> "Computed Default");

        System.out.println("Result1: " + result1);
        System.out.println("Result2: " + result2);

        // map and flatMap
        Optional<Integer> length = optional1.map(String::length);
        System.out.println("Length: " + length.orElse(0));
    }
}

// 13. Method References Example
class MethodReferenceExample {
    public static void demo() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Lambda
        names.forEach(name -> System.out.println(name));

        // Method reference
        names.forEach(System.out::println);

        // Constructor reference
        List<Integer> lengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Lengths: " + lengths);
    }
}

// 14. Collectors Example
class CollectorsExample {
    public static void demo() {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("David", 30)
        );

        // Group by age
        Map<Integer, List<Person>> byAge = people.stream()
                .collect(Collectors.groupingBy(p -> p.age));
        System.out.println("Grouped by age: " + byAge);

        // Partition by condition
        Map<Boolean, List<Person>> partitioned = people.stream()
                .collect(Collectors.partitioningBy(p -> p.age >= 30));
        System.out.println("Age >= 30: " + partitioned.get(true));

        // Joining strings
        String joined = people.stream()
                .map(p -> p.name)
                .collect(Collectors.joining(", "));
        System.out.println("Names: " + joined);
    }
}

// ============================================
// CONCURRENCY AND MULTITHREADING EXAMPLES
// ============================================

// 15. Synchronized Example
class Counter {
    private int count = 0;

    // Synchronized method
    public synchronized void increment() {
        count++;
    }

    // Synchronized block
    public void incrementWithBlock() {
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }
}

class SynchronizedExample {
    public static void demo() throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final count: " + counter.getCount());
    }
}

// 16. Volatile Example
class VolatileExample {
    private volatile boolean flag = false;

    public void writer() {
        flag = true;
        System.out.println("Flag set to true");
    }

    public void reader() {
        while (!flag) {
            // Wait for flag to be true
        }
        System.out.println("Flag is now true");
    }
}

// 17. ExecutorService Example
class ExecutorServiceExample {
    public static void demo() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit Runnable tasks
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executor.execute(() -> {
                System.out.println("Task " + taskId + " executed by " +
                        Thread.currentThread().getName());
            });
        }

        // Submit Callable task
        Future<Integer> future = executor.submit(() -> {
            Thread.sleep(1000);
            return 42;
        });

        try {
            System.out.println("Result: " + future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}

// 18. ConcurrentHashMap Example
class ConcurrentHashMapExample {
    public static void demo() {
        Map<String, Integer> concurrentMap = new ConcurrentHashMap<>();

        // Thread-safe operations
        concurrentMap.put("key1", 1);
        concurrentMap.putIfAbsent("key2", 2);
        concurrentMap.computeIfAbsent("key3", k -> 3);

        // Atomic operations
        concurrentMap.compute("key1", (k, v) -> v == null ? 1 : v + 1);

        System.out.println("ConcurrentHashMap: " + concurrentMap);
    }
}

// 19. ThreadLocal Example
class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static void demo() {
        Runnable task = () -> {
            int value = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + " initial: " + value);

            threadLocal.set(value + 1);
            System.out.println(Thread.currentThread().getName() + " after: " +
                    threadLocal.get());
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}

// ============================================
// EXCEPTION HANDLING EXAMPLES
// ============================================

// 20. Custom Exception Example
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Insufficient funds. Balance: " + balance + ", Requested: " + amount);
        }
        balance -= amount;
    }
}

class ExceptionHandlingExample {
    public static void demo() {
        BankAccount account = new BankAccount(1000);

        try {
            account.withdraw(1500);
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction completed");
        }
    }
}

// 21. Try-with-resources Example
class TryWithResourcesExample {
    public static void demo() {
        // Automatic resource management
        try (BufferedReader br = new BufferedReader(
                new FileReader("example.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        // BufferedReader is automatically closed
    }
}

// ============================================
// MAIN CLASS TO RUN ALL EXAMPLES
// ============================================
public class newsdn {
    public static void main(String[] args) {
        try {
            System.out.println("=== Priority Queue Example ===");
            PriorityQueueExample.demo();

            System.out.println("\n=== Enum Example ===");
            EnumExample.demo();

            System.out.println("\n=== Builder Pattern Example ===");
            BuilderPatternExample.demo();

            System.out.println("\n=== Lambda Example ===");
            LambdaExample.demo();

            System.out.println("\n=== Stream Example ===");
            StreamExample.demo();

            System.out.println("\n=== Optional Example ===");
            OptionalExample.demo();

            System.out.println("\n=== Exception Handling Example ===");
            ExceptionHandlingExample.demo();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}