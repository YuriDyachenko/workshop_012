package kurs;

public class Gun {
    private final int BULLETS_IN_MAGAZINE = 15;
    private int bullets = 0;
    private int magazines = 10;

    public boolean shot() {
        if (bullets == 0) {
            if (!reload()) {
                return false;
            }
        }
        bullets--;
        System.out.printf("  выстрел, патронов осталось %d\n", bullets);
        return true;
    }

    public boolean shot(int bullets) {
        for (int i = 0; i < bullets; i++) {
            if (!shot()) {
                return false;
            }
        }
        return true;
    }

    public boolean reload() {
        if (magazines == 0) {
            System.out.println("  больше нет магазинов");
            return false;
        }
        magazines--;
        bullets = BULLETS_IN_MAGAZINE;
        System.out.printf("  вставлен новый магазин, осталось %d\n", magazines);
        return true;
    }

    @Override
    public String toString() {
        return String.format("пистолет \"миротворец\":  патронов %d, магазинов %d", bullets, magazines);
    }

    public String amount() {
        String template =
                "{\n" +
                "    \"magazines\":%d,\n" +
                "    \"bullets\":%d\n" +
                "}\n";
        return String.format(template, magazines, bullets);
    }
}

