import java.util.*;

class Celula {
  int elemento;
  public Celula inf,sup,esq,dir;


  public Celula() {
    this(0);
  }

  public Celula(int elemento) {
    this(elemento,null,null,null,null);
  }

  public Celula(int elemento, Celula inf, Celula sup, Celula esq, Celula dir){
    this.elemento = elemento;
    this.sup = sup;
    this.inf = inf;
    this.esq = esq;
    this.dir = dir;
  }
}

 class MatrizDinamica {
  private Celula inicio;
  private int linha, coluna;

  public MatrizDinamica() {
    this(3,3);
  }

  public MatrizDinamica(int linha, int coluna) {
    this.linha = linha;
    this.coluna = coluna;

    if(linha > 0 && coluna > 0) {
      initMatriz();
      
    }
  }

  public void initMatriz(){
    Celula[][] temp = new Celula[linha][coluna];

    for(int i = 0;i<linha;i++) {
      for(int j = 0;j<coluna;j++) {
        temp[i][j] = new Celula();
      }
    }

    for(int i = 0;i<linha;i++) {
      for(int j = 0;j<coluna;j++) {

        if(i > 0) {
          temp[i][j].sup = temp[i - 1][j];
        }

        if(i < linha - 1) {
          temp[i][j].inf = temp[i + 1][j];
        }

        if(j > 0) {
          temp[i][j].esq = temp[i][j-1];
        }

        if(j < coluna - 1)  {
          temp[i][j].dir = temp[i][j + 1];
        }
      }
    }

    this.inicio = temp[0][0];
  }

  public Celula navega(int linha, int coluna) {
    Celula atual = inicio;

    for(int i = 0;i < linha;i++) {
      atual = atual.inf;
    }

    for(int j = 0;j<coluna;j++) {
      atual = atual.dir;
    }

    return atual;
  }

  public int obter(int linha, int coluna) {
    if(linha >= 0 && linha < this.linha && coluna >= 0 && coluna < this.coluna) {
      Celula atual = navega(linha,coluna);
      return atual.elemento;
    }
    
    return 0;

  }

    public void inserir(int linha, int coluna, int elemento) {
      if(linha >= 0 && linha < this.linha && coluna >= 0 && coluna < this.coluna) {
        Celula atual = navega(linha,coluna);
        atual.elemento = elemento;
      }
    }
  
  public MatrizDinamica soma(MatrizDinamica m){
    MatrizDinamica resp = null;
    if(this.linha == m.linha && this.coluna == m.coluna) {
      resp = new MatrizDinamica(this.linha, this.coluna);
      for(int i = 0;i<this.linha;i++) {
        for(int j = 0;j< this.coluna;j++) {
          int soma = this.obter(i,j) + m.obter(i,j);
          resp.inserir(i,j,soma);
        }
      }
    }

    return resp;
  }

  public MatrizDinamica multiplicacao(MatrizDinamica m){
    MatrizDinamica resp = null;
    if(this.coluna == this.linha) {
      resp = new MatrizDinamica(this.linha,this.coluna);

      for(int i = 0;i<this.linha;i++) {
        for(int j = 0;j<this.coluna;j++) {
          int soma = 0;
          for(int k = 0;k<this.coluna;k++) {
            soma += this.obter(i,k) * m.obter(k,j);
          }
          resp.inserir(i,j,soma);
        }
      }
    }
    return resp;
  }

  public void mostrarDiagonalPrincipal() {
    int minDiagonal = Math.min(linha,coluna);
    for(int i = 0;i< minDiagonal;i++) {
      if(i > 0) System.out.print(" ");
      System.out.print(obter(i,i));
     
    }
    System.out.print(" ");
    System.out.println();
  }

  public void mostrarDiagonalSecundaria() {
    int minDin = Math.min(linha,coluna);
    for(int i = 0; i <minDin;i++) {
      if(i > 0) System.out.print(" ");
      System.out.print(obter(i,coluna - 1 - i));
    }


    System.out.print(" ");
    System.out.println();
  }

  public void imprimir() {
    for(int i = 0;i<linha;i++) {
      for(int j = 0;j<coluna;j++) {
        if(j > 0) System.out.print(" ");
        System.out.print(obter(i,j));
      }

      System.out.print(" ");
      System.out.println();
    }
  }

  public int getLinha() {
    return linha;
  }

  public int getColuna() {
    return coluna;

  }



}

 public class Main {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      int numCasos = scanner.nextInt();

      for(int caso = 0;caso<numCasos;caso++) {
        int l1 = scanner.nextInt();
        int c1 = scanner.nextInt();

        MatrizDinamica m1 = new MatrizDinamica(l1,c1);

        for(int i = 0;i<l1;i++) {
          for(int j = 0;j<c1;j++) {
            int elemento = scanner.nextInt();
            m1.inserir(i, j, elemento);
          }
        }

        int l2 = scanner.nextInt();
        int c2 = scanner.nextInt();

        MatrizDinamica m2 = new MatrizDinamica(l2,c2);

        for(int i=0;i<l2;i++) {
          for(int j = 0;j < c2;j++) {
            int elemento = scanner.nextInt();
            m2.inserir(i, j, elemento);
          }
        }

        m1.mostrarDiagonalPrincipal();
        m1.mostrarDiagonalSecundaria();

        MatrizDinamica soma = m1.soma(m2);
        if(soma != null) {
          soma.imprimir();
        }

        MatrizDinamica mult = m1.multiplicacao(m2);
        if(mult != null) {
          mult.imprimir();
        }
      }

      scanner.close();
    }

  }
