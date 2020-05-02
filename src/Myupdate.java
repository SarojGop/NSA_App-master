public class Myupdate extends Myobserver {
    private Myobserver objobserver;

    public Myupdate(Myobserver objobserver) {
        this.objobserver = objobserver;
        objobserver.notifyAllObservers();
    }

}
