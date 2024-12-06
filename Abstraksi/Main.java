public class Main {
    public void cekMakhlukHidup (MakhlukHidup mHidup){
        mHidup.berdiri();
        mHidup.oksigen();
    }
    
    public static void main(String[] args) {
        Main tMakhlukHidup = new Main();        
        
        tMakhlukHidup.cekMakhlukHidup(new Manusia("Dua Kaki"));       
        
        System.out.println("-----------------------------------------");                              
        tMakhlukHidup.cekMakhlukHidup(new Hewan ("Empat Kaki","Dua Kaki"));
        
        System.out.println("-----------------------------------------");        
        tMakhlukHidup.cekMakhlukHidup(new Tumbuhan ("Akar"));
        
    }
}
