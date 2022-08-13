package com.islandmodel.entitie;

public enum EntitieType {
    //[BEAR, BOA, EAGLE, FOX, WOLF, BOAR, BUFFALO, CATERPILLAR, DEER, DUCK, GOAT, HORSE, MOUSE, RABBIT, SHEEP, PLANTS
    BEAR("🐻"),//🐻
    BOA("🐍"),
    EAGLE("🦅"),
    FOX("🦊"),
    WOLF("🐺"),
    BOAR("🐗"),//кабан
    BUFFALO("🐃"),//буйвол
    CATERPILLAR("🐛"),
    DEER("🦌"),//олень
    DUCK("🦆"),
    GOAT("🐐"),//коза
    HORSE("🐎"),
    MOUSE("🐁"),
    RABBIT("🐇"),
    SHEEP("🐑"),
    PLANTS("🌿");

    EntitieType(String icon) {
        this.icon = icon;
    }

    private String icon;

    public String getIcon() {
        return icon;
    }
}

//class a {
//
//    public static void main(String[] args) {
//        System.out.println(ThreadLocalRandom.current().nextInt(-5,-4));
//    }
//}