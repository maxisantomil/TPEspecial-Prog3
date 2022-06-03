
import java.util.ArrayList;

public class Tree {
	
	private Genero genero;
	private Tree left;
	private Tree right;
	private int size = 0;
	
	public Tree() {
		this.genero=null;
		this.left=null;
		this.right=null;
	}
	
	public Tree(Genero g) {
		this.genero=g;
		this.left = null;
		this.right = null;
		this.size++;
	}
	
	public void addGenero(String newGenero) {
		Genero nuevo=new Genero();
		nuevo.setNombre(newGenero);
		if (this.genero == null) 
			this.genero = nuevo;
		else {
			if (this.genero.getNombre().compareTo(nuevo.getNombre())>0) {
				if (this.left == null) {
					this.left = new Tree(nuevo);
					this.size++;
				}
				else {
					this.left.addGenero(newGenero);
					this.size++;
				}
			} else if (this.genero.getNombre().compareTo(nuevo.getNombre())<0) {
				if (this.right == null) {
					this.right = new Tree(nuevo);
					this.size++;
				}
				else {
					this.right.addGenero(newGenero);
					this.size++;
				}
					
			}
		}
		 // ajustar dinámicamente la altura del árbol durante el proceso de adición
        // Si la diferencia correcta derecha del arbol actual es mayor que 1, gire a la izquierda hacia la izquierda
        if (this.getRightTreeHeight()-this.getLeftTreeHeight() > 1){
            if (this.right.getLeftTreeHeight() > this.right.getRightTreeHeight()){
                this.right.rightRotate();
                this.leftRotate();
            }else {
                this.leftRotate(); // Girar a la izquierda
            }
            return;
        }

        // Si el subárbol izquierdo del arbol actual es mayor que 1, gire a la derecha
        if (this.getLeftTreeHeight() - this.getRightTreeHeight() > 1){
            if (this.left.getRightTreeHeight() > this.left.getLeftTreeHeight()){
                this.left.leftRotate();
                this.rightRotate();
            }else {
                this.rightRotate(); // Gira a la derecha
            }
        }
	}
	
	// obtener una altura
    public int getHeight(){
    	int levelleft=0;
		int levelright=0;
		if (this.left!=null ) {
			levelleft= left.getHeight()+1;
		}
		if (this.right!=null ) {
			levelright= right.getHeight()+1;
		}
		int max= Math.max(levelleft,levelright);
	return max;
    }

    // Obtener la altura del subárbol izquierdo del arbol actual
    public int getRightTreeHeight(){
        if (this.right!=null){
            return this.right.getHeight();
        }
        return 0;
    }

    // Obtener la altura del subarbol derecho del arbol actual
    public int getLeftTreeHeight(){
        if (this.left!=null){
            return this.left.getHeight();
        }
        return 0;
    }

    // Girar a la izquierda
    public void leftRotate(){
        Tree newNode = new Tree(this.genero);
        newNode.left = this.left;
        newNode.right = this.right.left;
        this.genero = this.right.genero;
        this.right = this.right.right;
        this.left = newNode;
    }

    // Gira a la derecha
    public void rightRotate(){
        Tree newNode = new Tree(this.genero);
        newNode.right = this.right;
        newNode.left = this.left.right;
        this.genero = this.left.genero;
        this.left = this.left.left;
        this.right = newNode;
    }
	
	//Complejidad O(1) no tiene complejidad ya que devuelve la raiz del arbol.
		public Tree getRoot() {
			return this;
		}
		
		//Los árboles AVL están siempre equilibrados de tal modo que para todos los nodos, la altura de la rama izquierda no difiere en más de una unidad de la altura de la rama derecha o viceversa. 
		//Gracias a esta forma de equilibrio (o balanceo), la complejidad de una búsqueda en uno de estos árboles se mantiene siempre en orden de complejidad O(log n)
		public Genero buscarGenero(String valor) {
			Genero g=new Genero();
				if (this.genero.getNombre().equals(valor)) {
					g=genero;
					return g;
				}
				else {
					if (this.genero.getNombre().compareTo(valor)<0 && right!=null) {
						return this.right.buscarGenero(valor);
					}
					else if (this.genero.getNombre().compareTo(valor)>0 && left!=null) {
						return  this.left.buscarGenero(valor);
						}
					
					}
				return g;
		}
		
		public boolean isEmpty() {
			return this.getSize()==0;
		}

		private int getSize() {
			return this.size;
		}

		//imprime raiz despues rama izquierda y despues rama derecha
		public void printPreOrder() {
			System.out.println(this.genero + " ");
			if (this.left!=null){
				this.left.printPreOrder();
			}else
				System.out.print("- ");
			if (this.right!=null) {
				this.right.printPreOrder();
			}else 
				System.out.print("- ");
		}
		public void printPostOrder() {
			if (this.genero == null)
				System.out.print("-");
			if (this.left!=null){
				this.left.printPostOrder();
				System.out.print("-");
			}
			System.out.print("-");
			if (this.right!=null) {
				this.right.printPostOrder();
				System.out.print("-");
				
			}
			System.out.print(this.genero);
			
		}

		public void printInOrder() {
			if (this.left!=null)
				this.left.printInOrder();
			if (this.genero!=null)
				System.out.println(this.genero + " ");
			if (this.right!=null)
				this.right.printInOrder();
			}
		
		
		public ArrayList<Genero> getGeneros() {
			ArrayList<Genero>generos=new ArrayList<>();
			if (this.left!=null)
				generos.addAll(this.left.getGeneros());
			if (this.genero!=null)
				generos.add(genero);
			if (this.right!=null)
				generos.addAll(this.right.getGeneros());
			return generos;
		}
	
}
