/**
 *
 * @author Gabriel Renée da Silva (28279502)
 * @author2 Victor Christian oliveira (28280014)
 */
public class PostoVO {

    public int servicos[] = new int[6]; //0 = Ducha | 1 = Óleo | 2 = Balanceamento | 3 = Café | 4 = Salgado | 5 = Total
    public float valorCmp[] = new float[4]; // Custo: 0- etanol; 1- gasolina; 2-aditivada; 3- diesel
    public float valorVend[] = new float[4]; // Venda: 0- etanol; 1- gasolina; 2-aditivada; 3- diesel
    public float tanques[] = new float[4];//0- etanol; 1- gasolina; 2-aditivada; 3- diesel
    public float lVend[] = new float[5]; //Litros vendidos: 0- etanol; 1- gasolina; 2- aditivada; 3- diesel; 4- total
    public float lCmp[] = new float[5];//Litros comprados: 0- etanol; 1- gasolina; 2- aditivada; 3- diesel; 4- total
    public float despesas, lucros, lucroServ;

    public PostoVO() { //Inicializa os tanques com 0;
        for (int i = 0; i < 4; i++) {
            this.tanques[i] = 0;
        }
        valorCmp[0] = 1.19f; //Valor de compra etanol;
        valorCmp[1] = 2.19f; //Valor de compra gasolina;
        valorCmp[2] = 2.29f; //Valor de compra aditivada;
        valorCmp[3] = 1.39f; //Valor de compra diesel;

        valorVend[0] = 2.39f; //Valor de venda etanol;
        valorVend[1] = 4.19f; //Valor de venda gasolina;
        valorVend[2] = 4.39f; //Valor de venda aditivada;
        valorVend[3] = 3.29f; //Valor de venda diesel;
    }

    public int abastecerTanque(int tmpComb, int tmpQnt) {
        switch (tmpComb) {
            case 0:
                if (tanques[0] + tmpQnt <= 20000 && tmpQnt > 0) {
                    this.tanques[0] += tmpQnt;
                    this.lCmp[0] += tmpQnt;
                    this.lCmp[4] += tmpQnt;
                    this.despesas += tmpQnt * valorCmp[0];
                    return 1;
                } else if (this.tanques[0] == 20000 && (tmpQnt > 0)) {
                    return 2;
                } else if (tmpQnt <= 0) {
                    return 3;
                } else if ((this.tanques[0] + tmpQnt) > 2000) {
                    return 4;
                }
            case 1:
                if (tanques[1] + tmpQnt <= 20000 && tmpQnt > 0) {
                    this.tanques[1] += tmpQnt;
                    this.lCmp[1] += tmpQnt;
                    this.lCmp[4] += tmpQnt;
                    this.despesas += tmpQnt * valorCmp[1];
                    return 1;
                } else if (this.tanques[1] == 20000 && (tmpQnt > 0)) {
                    return 2;
                } else if (tmpQnt <= 0) {
                    return 3;
                } else if ((this.tanques[1] + tmpQnt) > 2000) {
                    return 4;
                }
            case 2:
                if (tanques[2] + tmpQnt <= 20000 && tmpQnt > 0) {
                    this.tanques[2] += tmpQnt;
                    this.lCmp[2] += tmpQnt;
                    this.lCmp[4] += tmpQnt;
                    this.despesas += tmpQnt * valorCmp[2];
                    return 1;
                } else if (this.tanques[2] == 20000 && (tmpQnt > 0)) {
                    return 2;
                } else if (tmpQnt <= 0) {
                    return 3;
                } else if ((this.tanques[2] + tmpQnt) > 2000) {
                    return 4;
                }
            case 3:
                if (tanques[3] + tmpQnt <= 20000 && tmpQnt > 0) {
                    this.tanques[3] += tmpQnt;
                    this.lCmp[3] += tmpQnt;
                    this.lCmp[4] += tmpQnt;
                    this.despesas += tmpQnt * valorCmp[3];
                    return 1;
                } else if (this.tanques[3] == 20000 && (tmpQnt > 0)) {
                    return 2;
                } else if (tmpQnt <= 0) {
                    return 3;
                } else if ((this.tanques[3] + tmpQnt) > 2000) {
                    return 4;
                }
            default:

                return 3;
        }
    }

    public int abastecerCarro(int tmpComb, float tmpValor) {
        float tmpLitros;
        switch (tmpComb) {
            case 0:
                tmpLitros = tmpValor / valorVend[0];
                if ((this.tanques[0] - tmpLitros) >= 0 && tmpValor > 0) {
                    this.tanques[0] -= tmpLitros;
                    this.lVend[0] += tmpLitros;
                    this.lVend[4] += tmpLitros;
                    this.lucros += tmpValor;

                    return 1;
                } else if (this.tanques[0] <= 0 && (tmpValor > 0)) {

                    return 2;
                } else if (tmpValor <= 0) {

                    return 3;
                } else if (tmpLitros > this.tanques[0]) {

                    return 4;
                }
            case 1:
                tmpLitros = tmpValor / valorVend[1];
                if ((this.tanques[1] - tmpLitros) >= 0 && tmpValor > 0) {
                    this.tanques[1] -= tmpLitros;
                    this.lVend[1] += tmpLitros;
                    this.lVend[4] += tmpLitros;
                    this.lucros += tmpValor;
                    return 1;
                } else if (this.tanques[1] == 0 && (tmpValor > 0)) {
                    return 2;
                } else if (tmpValor <= 0) {
                    return 3;
                } else if (tmpLitros > this.tanques[1]) {
                    return 4;
                }
            case 2:
                tmpLitros = tmpValor / valorVend[2];
                if ((this.tanques[2] - tmpLitros) >= 0 && tmpValor > 0) {
                    this.tanques[2] -= tmpLitros;
                    this.lVend[2] += tmpLitros;
                    this.lVend[4] += tmpLitros;
                    this.lucros += tmpValor;
                    return 1;
                } else if (this.tanques[2] == 0 && (tmpValor > 0)) {
                    return 2;
                } else if (tmpValor <= 0) {
                    return 3;
                } else if (tmpLitros > this.tanques[0]) {
                    return 4;
                }
            case 3:
                tmpLitros = tmpValor / valorVend[3];
                if ((this.tanques[3] - tmpLitros) >= 0 && tmpValor > 0) {
                    this.tanques[3] -= tmpLitros;
                    this.lVend[3] += tmpLitros;
                    this.lVend[4] += tmpLitros;
                    this.lucros += tmpValor;
                    return 1;
                } else if (this.tanques[3] == 0 && (tmpValor > 0)) {
                    return 2;
                } else if (tmpValor <= 0) {
                    return 3;
                } else if (tmpLitros > this.tanques[0]) {
                    return 4;
                }
            default:

                return 3;
        }
    }

    public void venderServiços(int tmpServ) {
        if (tmpServ == 0) {
            this.servicos[0]++;
            this.servicos[5]++;
            this.lucroServ += 2.00;

        } else if (tmpServ == 1) {
            this.servicos[1]++;
            this.servicos[5]++;
            this.lucroServ += 4.00;

        } else if (tmpServ == 2) {

            this.servicos[2]++;
            this.servicos[5]++;
            this.lucroServ += 8.00;

        } else if (tmpServ == 3) {

            this.servicos[3]++;
            this.servicos[5]++;
            this.lucroServ += 35.00;

        } else if (tmpServ == 4) {

            this.servicos[4]++;
            this.servicos[5]++;
            this.lucroServ += 50.00;
        }

    }
}
