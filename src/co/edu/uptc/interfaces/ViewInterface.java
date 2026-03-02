package co.edu.uptc.interfaces;

public interface ViewInterface {

    void setPresenter(PresenterInterface presenter);
    void start();
    void showMessage(String message);
    String readString(String message);
    void showError(String message);
    double readDouble(String message);
    int showEnum(String message);


}
