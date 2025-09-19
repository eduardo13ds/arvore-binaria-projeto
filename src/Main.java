public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        int[] valores = {14, 15, 4, 9, 7, 18, 3, 5, 16, 20, 17};
        for (int v : valores){
            arvore.inserir(v);
        }

        //Pre-ordem
        System.out.print("Pré-ordem: ");
        arvore.preOrdem(arvore.raiz); System.out.println();

        //In-ordem
        System.out.print("In-ordem: ");
        arvore.inOrdem(arvore.raiz); System.out.println();

        //Pos-ordem
        System.out.print("Pós-ordem: ");
        arvore.posOrdem(arvore.raiz); System.out.println();

        //Remove o maior
        arvore.removerMaior();
        System.out.print("Após remover maior: ");
        arvore.inOrdem(arvore.raiz); System.out.println();

        //Remove o menor
        arvore.removerMenor();
        System.out.print("Após remover menor: ");
        arvore.inOrdem(arvore.raiz); System.out.println();

        //Remove o valor solicitado
        arvore.remover(15);
        System.out.print("Após remover 15: ");
        arvore.inOrdem(arvore.raiz); System.out.println();
    }
}