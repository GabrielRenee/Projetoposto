
public class Tanque {

    private float capET, capGC, capGA, capDS;
    public  float caixa;
            
    public Tanque() {
        this.capET = 0;
        this.capGC = 0;
        this.capGA = 0;
        this.capDS = 0;
        this.caixa = 100000;
    }

    public boolean abastecerEtanol(int tmpQnt) {
        if (!((tmpQnt + capET) > 20000) && caixa > tmpQnt*1.19) {
            this.capET += tmpQnt;
            this.caixa -= tmpQnt*1.19;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean abastecerGasolina(int tmpQnt){
        if (!((tmpQnt + capGC) > 20000) && caixa > tmpQnt* 2.19) {
            this.capGC += tmpQnt;
            this.caixa -= tmpQnt*2.19;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean abastecerAditivada(int tmpQnt){
        if (!((tmpQnt + capGA) > 20000) && caixa > tmpQnt* 2.29) {
            this.capGA += tmpQnt;
            this.caixa -= tmpQnt*2.29;
            return true;
        } else {
            return false;
        }
    }
    
    public boolean abastecerDiesel(int tmpQnt){
        if (!((tmpQnt + capDS) > 20000) && caixa > tmpQnt* 3.29) {
            this.capDS += tmpQnt;
            this.caixa -= tmpQnt*3.29;
            return true;
        } else {
            return false;
        }
    }
}
