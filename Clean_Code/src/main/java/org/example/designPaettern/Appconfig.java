package org.example.designPaettern;

//Singleton

public final class Appconfig{

    private final String baseUrl;
    private final int timeoutMs;

    public Appconfig() {
        this.baseUrl = System.getProperty("app.baseUrl","Https://api.example.com");
        this.timeoutMs = Integer.getInteger("app.timeoutMs",5000);
    }

    private static class Holder {
        private static final Appconfig INSTANCE = new Appconfig();
    }

    public static Appconfig getInstance(){
        return Holder.INSTANCE;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public int getTimeoutMs() {
        return timeoutMs;
    }

    public static void main(String[] args) {
        Appconfig cfg = Appconfig.getInstance();
        System.out.println(cfg.baseUrl+" / "+ cfg.getTimeoutMs());
    }
}