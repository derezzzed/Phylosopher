public class ConctreteKitchenCreater extends KitchenCreater {
    @Override
    public Kitchen create() {
        return new ConcreteKitchen();
    }
}
