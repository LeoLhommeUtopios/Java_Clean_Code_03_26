package org.example.designPaettern;


interface Button {String render();}
interface Checkbox {String render();}

class LightButton implements Button{
    @Override
    public String render() {
        return "[Light Button]";
    }
}
class DarktButton implements Button{
    @Override
    public String render() {
        return "[Dark Button]";
    }
}

class LightCheckBox implements Checkbox{
    @Override
    public String render() {
        return "[Light chekBox]";
    }
}
class DarkChekcBox implements Checkbox{
    @Override
    public String render() {
        return "[Dark CheckBox]";
    }
}

interface UIFactory{
    Button CreateButton();
    Checkbox createCheckBox();
}

class LightFactory implements UIFactory{
    @Override
    public Button CreateButton() {
        return new LightButton();
    }
    @Override
    public Checkbox createCheckBox() {
        return new LightCheckBox();
    }
}

class DarkFactory implements UIFactory{
    @Override
    public Button CreateButton() {
        return new DarktButton();
    }
    @Override
    public Checkbox createCheckBox() {
        return new DarkChekcBox();
    }
}

class Screen {
    private final Button btn;
    private final Checkbox chk;

    public Screen(UIFactory f) {
        this.btn = f.CreateButton();
        this.chk = f.createCheckBox();
    }
    public String draw (){
        return btn.render()+' '+ chk.render();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        UIFactory factory = new LightFactory();
        Screen screen = new Screen(factory);
        System.out.println(screen.draw());

         factory = new DarkFactory();
         screen = new Screen(factory);
        System.out.println(screen.draw());
    }
}
