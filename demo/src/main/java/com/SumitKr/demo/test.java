class P {

    void m1() {
        System.out.println("m1");
    }

    void m2() {
        System.out.println("m2");
    }
}

class C1 extends P {

}

class Test {
    public static void main(String[] args) {

        C1 c1 = new C1();   // Child reference → Child object
        c1.m1();
        c1.m2();

        P p1 = new P();     // Parent reference → Parent object

        P p2 = new C1();    // Parent reference → Child object (Upcasting)
        p2.m1();
        p2.m2();
    }
}

class C2 {

}