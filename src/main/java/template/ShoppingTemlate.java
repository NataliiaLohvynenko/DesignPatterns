package template;

public  abstract class ShoppingTemlate {

    public abstract void launchSide();
    public abstract void searchForProduct();
    public abstract void selecProduct();
    public abstract void buy();

    public void shop(){
        launchSide();
        searchForProduct();
        selecProduct();
        buy();
    }
}
