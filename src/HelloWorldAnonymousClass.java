public class HelloWorldAnonymousClass {

    interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
    }


    public static void main(String[] args) {
        HelloWorldAnonymousClass myAnon = new HelloWorldAnonymousClass();
        myAnon.sayHello();
    }

    public void sayHello() {

        //my anonymous class, which implements the HelloWorld interface
        class EnglishGreeting implements HelloWorld {
            String name = "world";
            public void greet() {
                greetSomeone("world");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }

        HelloWorld englishGreeting = new EnglishGreeting();

        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";
            public void greet() {
                greetSomeone("tout le monde");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "mundo";
            public void greet() {
                greetSomeone("mundo");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };
        englishGreeting.greet();
        frenchGreeting.greetSomeone("Chuck");
        spanishGreeting.greet();
    }
}