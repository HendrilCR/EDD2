import java.util.Scanner;

class Main{
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(6);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(3);
        tree.insert(8);

        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("\nMenu:");
        System.out.println("1 - Inserir número");
        System.out.println("2 - Mostrar os nós folha");
        System.out.println("3 - Mostrar os nós ancestrais de um nó");
        System.out.println("4 - Mostrar os nós descendentes de um nó");
        System.out.println("5 - Mostrar o nó pai e os nós filhos de um nó");
        System.out.println("6 - Mostrar a subárvore da direita");
        System.out.println("7 - Mostrar a subárvore da esquerda");
        System.out.println("8 - Mostrar toda arvore");
        System.out.println("9 - Sair");
        System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();

        while (opcao != 9){

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número a ser inserido: ");
                    int numero = scanner.nextInt();
                    tree.insert(numero);
                    break;
                case 2:
                    tree.folhas(tree.root);
                    break;
                case 3:
                    System.out.print("Digite o número do nó: ");
                    int noAncestral = scanner.nextInt();
                    tree.ancestrais(tree.root,noAncestral);
                    break;
                case 4:
                    System.out.print("Digite o número do nó: ");
                    int noDescendente = scanner.nextInt();
                    tree.descendentes(tree.root,noDescendente);
                    break;
                case 5:
                    System.out.print("Digite o número do nó: ");
                    int no = scanner.nextInt();
                    tree.paiefilho(tree.root,no,null);
                    break;
                case 6:
                    System.out.print("Digite o número do nó: ");
                    no = scanner.nextInt();
                    tree.direita(tree.root,no);
                    break;
                case 7:
                    System.out.print("Digite o número do nó: ");
                    no = scanner.nextInt();
                    tree.esquerda(tree.root,no);
                    break;
                case 8:
                    tree.mostrar(tree.root);
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.print("Escolha uma opção: ");
        opcao = scanner.nextInt();
        }
        scanner.close();
    } 

    
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class BinaryTree {
    public TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return;
        }

        TreeNode current = root;
        TreeNode parent = null;

        while (current != null) {
            parent = current;
            if (val < current.val) {
                current = current.left;
            } else if (val > current.val) {
                current = current.right;
            } else {
                return;
            }
        }

        if (val < parent.val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }
    }

    public void folhas(TreeNode root) {
        if(root.left!=null){folhas(root.left);}

        if(root.right!=null){folhas(root.right);}

        if(root.left == null && root.right == null) System.out.print(root.val+" ");
    }

    public void ancestrais(TreeNode root,int n) {
        if(root.val==n){return;}
        System.out.print(root.val+" ");

        if(n<root.val){ancestrais(root.left,n);}
        if(n>root.val){ancestrais(root.right,n);}

    }

    public void descendentes(TreeNode root,int n) {
        if(root.val==n){
            if(root.left!=null){System.out.print("Left: ");mostrar(root.left);}
            if(root.right!=null){System.out.print(" Right: ");mostrar(root.right);}
            }

        else if(n<root.val){descendentes(root.left,n);}
        else if(n>root.val){descendentes(root.right,n);}

    }

    public void esquerda(TreeNode root,int n) {
        if(root.val==n){
            if(root.left!=null){System.out.print("Left: ");mostrar(root.left);}}
        else if(n<root.val){esquerda(root.left,n);}
        else if(n>root.val){esquerda(root.right,n);}
    }

    public void direita(TreeNode root,int n) {
        if(root.val==n){
            if(root.right!=null){System.out.print("Right: ");mostrar(root.right);}}
        else if(n<root.val){direita(root.left,n);}
        else if(n>root.val){direita(root.right,n);}
    }


    public void paiefilho(TreeNode root,int n,TreeNode pai) {
        if(root.val==n){
            System.out.print("Pai: "+pai.val);
            if(root.left!=null){System.out.print(" Left: ");mostrar(root.left);}
            if(root.right!=null){System.out.print(" Right: ");mostrar(root.right);}
            }

        else if(n<root.val){paiefilho(root.left,n,root);}
        else if(n>root.val){paiefilho(root.right,n,root);}

    }

    public void mostrar(TreeNode root) {
        System.out.print(root.val);
        System.out.print(" ");
        if(root.left != null | root.right != null) System.out.print("(");
        if(root.left!=null){mostrar(root.left);}

        if(root.right!=null){mostrar(root.right);}

        if(root.left != null | root.right != null) System.out.print(")");
    }
}