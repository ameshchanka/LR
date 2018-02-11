package by.itacademy.controllers;

public abstract class AbstractAction implements ICommand {

    public abstract String jsp();
    public abstract String cmd();

    @Override
    public String getJsp() {
        return this.jsp();
    }

    @Override
    public String getCmd() {
        return this.cmd();
    }

//    @Override
//    public String toString(){
//        return this.getClass().
//                getSimpleName().
//                replace("Cmd", "");
//    }
}
