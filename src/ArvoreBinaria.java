public class ArvoreBinaria {
    Node raiz;

    private Node inserirRec(Node atual, int valor) {
        if (atual == null) return new Node(valor);

        if (valor < atual.valor) {
            atual.esquerda = inserirRec(atual.esquerda, valor);
        } else if (valor > atual.valor) {
            atual.direita = inserirRec(atual.direita, valor);
        }
        return atual; // não insere repetidos
    }

    public void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    //Pré-Ordem
    public void preOrdem(Node n) {
        if (n == null) return;
        System.out.print(n.valor + " ");
        preOrdem(n.esquerda);
        preOrdem(n.direita);
    }

    //In-Ordem
    public void inOrdem(Node n) {
        if (n == null) return;
        inOrdem(n.esquerda);
        System.out.print(n.valor + " ");
        inOrdem(n.direita);
    }

    //Pós-Ordem
    public void posOrdem(Node n) {
        if (n == null) return;
        posOrdem(n.esquerda);
        posOrdem(n.direita);
        System.out.print(n.valor + " ");
    }

    //Remove o menor valor
    public void removerMenor() {
        raiz = removerMenorRec(raiz);
    }

    private Node removerMenorRec(Node n) {
        if (n == null) return null;
        if (n.esquerda == null) return n.direita;
        n.esquerda = removerMenorRec(n.esquerda);
        return n;
    }

    //Remove o maior valor
    public void removerMaior() {
        raiz = removerMaiorRec(raiz);
    }

    private Node removerMaiorRec(Node n) {
        if (n == null) return null;
        if (n.direita == null) return n.esquerda;
        n.direita = removerMaiorRec(n.direita);
        return n;
    }

    //Remove o valor escolhido
    public void remover(int valor) {
        raiz = removerRec(raiz, valor);
    }

    private Node removerRec(Node n, int valor) {
        if (n == null) return null;

        if (valor < n.valor) {
            n.esquerda = removerRec(n.esquerda, valor);
        } else if (valor > n.valor) {
            n.direita = removerRec(n.direita, valor);
        } else {
            //sem filhos
            if (n.esquerda == null && n.direita == null) return null;

            //1 filho
            if (n.esquerda == null) return n.direita;
            if (n.direita == null) return n.esquerda;

            //2 filhos
            Node temp = n.direita;
            while (temp.esquerda != null) temp = temp.esquerda;
            n.valor = temp.valor;
            n.direita = removerRec(n.direita, temp.valor);
        }
        return n;
    }
}
