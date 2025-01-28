public class BadCodeExample {
    public static void main(String[] args) {
        int x = 10;
        int y = 20;
        int z = 30;

        if (x > 5) {
            if (y < 50) {
                if (z == 30) {
                    System.out.println("Case 1: x > 5, y < 50, z == 30");
                    if (x == 10) {
                        if (y == 20) {
                            System.out.println("Nested Case 1: x == 10, y == 20");
                            if (z != 30) {
                                System.out.println("Nested Case 2: z != 30");
                            } else {
                                System.out.println("Nested Case 3: z == 30");
                            }
                        } else {
                            System.out.println("Nested Case 4: y != 20");
                        }
                    }
                } else {
                    System.out.println("Case 2: x > 5, y >= 50");
                }
            } else {
                if (z < 30) {
                    System.out.println("Case 3: x > 5, y >= 50, z < 30");
                } else {
                    System.out.println("Case 4: x > 5, y >= 50, z >= 30");
                }
            }
        } else {
            if (y > 10) {
                if (z == 30) {
                    System.out.println("Case 5: x <= 5, y > 10, z == 30");
                    if (x < 5) {
                        if (y != 20) {
                            System.out.println("Nested Case 5: x < 5, y != 20");
                        } else {
                            System.out.println("Nested Case 6: x < 5, y == 20");
                        }
                    }
                } else {
                    System.out.println("Case 6: x <= 5, y > 10, z != 30");
                }
            } else {
                if (z == 30) {
                    System.out.println("Case 7: x <= 5, y <= 10, z == 30");
                } else {
                    System.out.println("Case 8: x <= 5, y <= 10, z != 30");
                }
            }
        }
    }
}
