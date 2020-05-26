
public class Main {
    public static void main(String[] args) {

        ConcreteKitchen concreteKitchen = new ConcreteKitchen();
        String[] names = { "BOBY", "JONNY", "BILLY","ALLY", "ENTHONY" };
        concreteKitchen.fillThreadArray(names);
        concreteKitchen.startThreads();
        KitchenCreater kitchenCreater = new ConctreteKitchenCreater();
        Kitchen kitchen = kitchenCreater.create();

    }
}



