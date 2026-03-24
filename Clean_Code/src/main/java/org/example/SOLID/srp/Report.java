package org.example.SOLID.srp;

//public class Report {
//    public String generateReport(){
//        return "raport des ventes";
//    }
//    public void  saveToFile(String data){
//        System.out.println("Sauvegarde du raport dans le fichier ...");
//    }
//}


class Report{
    public String generateReport(){
        return "raport des ventes";
    }
}

class ReportSaver{
    public void  saveToFile(String data){
        System.out.println("Sauvegarde du raport dans le fichier ...");
    }
}