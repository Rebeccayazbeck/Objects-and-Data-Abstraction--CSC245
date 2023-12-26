package question2;
/**
 * 
 * @author Rebecca Yazbeck 202201494
 * last modified : 10/5/2023
 *
 */
public class Vertex {
		private int info;
		private Vertex next;
		
		public Vertex(int i) {
			info = i;
			next = null;
		}
		
		public Vertex(int v, Vertex vertex) {
			info = v;
			next = vertex;
		}

		public Vertex getNext() {
			return  next;
		}
		
		public void setNext(Vertex n) {
			next = n;
		}
		
		public int getInfo() {
			return info;
		}
		
		public void setInfo(int i) {
			info = i;
		}
		
		public boolean isEqual(Vertex n) {
			return (n.getInfo()== info);
		}
}
