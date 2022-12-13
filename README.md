# FP-OOP

Nama  : Fadilla Rizky Nurhidayah

NRP   : 5025211110

PBO   : PBO B

Pada final project kelas Pemrograman Berbasis Objek kali ini, saya berencana untuk membuat suatu game yang didasari oleh bahasa pemrograman Java dengan menggunakan Graphical User Interface. Saya tertarik untuk membuat game dengan judul “Place The Box”. Game ini menceritakan sebuah pegawai toko bangunan yang ingin mengeluarkan kardus-kardus box yang berisi dari stok barang untuk dijual,box tersebut akan dipindahkan dari gudang menuju ke bangunan yang menjadi letak dari toko bangunan tersebut. Namun, dalam perjalanannya menuju ke minimarket dari gudang pegawai toko bangunan ini harus melewati sebuah labirin yang berliku-liku dan terdapat jalan buntu. Jika nantinya pegawai ini salah atau kurang tepat dalam mengambil jalan maka ia harus mengambil jalan putar balik dan mencari jalan yang tepat lagi. Permainan akan selesai begitu pegawai sudah bisa mencapai pintu menuju ke toko bangunan. Saya akan menggunakan library seperti java.awt maupun javax.swing dalam perakitan game ini nantinya.

ASPEK OOP
1. Casting/Conversion 
   System.out.println(level.toString());
2. Constructor 
   public MapLoader(String levelName, int levelNumber) {
		this.fixedElements = null;
		this.boxPositions = new ArrayList<Position>();
		this.characterPosition = null;
		this.mapHeight = 0;
		this.mapWidth = 0;
		this.levelNumber = levelNumber;
3. Overloading
   extends
4. Overriding
   @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (this.posX != other.posX)
			return false;
		if (this.posY != other.posY)
			return false;
		return true;
	}
5. Encapsulation
   public void moveBox(Position startPos, Position finalPos){
		for (int boxPos = 0; boxPos < this.boxPositions.length; boxPos++) {
			if (this.boxPositions[boxPos].equals(startPos)){
				this.boxPositions[boxPos] = finalPos;
				return;
			}
		}
	}
6. Inheritance 
   public class LevelGridPanel extends JPanel{

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 4650266191907566738L;
	
	/**
	 * Creates a new level grid panel.
	 * It generates a graphic display of the given level
	 * @param level The current level
	 */
	public LevelGridPanel(Level level) {
		super();
		
		this.setLayout(new GridLayout(level.getMapHeight(), level.getMapWidth()));
		ImageIcon ico = null;
		for (int line = 0; line < level.getMapHeight(); line++) {
			for (int column = 0; column < level.getMapWidth(); column++) {
				Position pos = new Position(line, column);
				switch (level.getFixedMapElement(pos)) {
					case FLOOR:
						ico = new ImageIcon();
						break;
					case WALL:
						ico = new ImageIcon(this.getClass().getResource("/ressources/wall.jpg"));
						break;
					case TARGET:
							ico = new ImageIcon(this.getClass().getResource("/ressources/target.png"));
						break;
					default:
						break;
				}
				
				if(pos.equals(level.getCharacterPosition()))
					ico = new ImageIcon(this.getClass().getResource("/ressources/character.gif"));
				if(level.isBoxAt(pos)){
					if(level.getFixedMapElement(pos) == FixedMapElement.TARGET)
						ico = new ImageIcon(this.getClass().getResource("/ressources/boxOnTarget.jpg"));
					else
						ico = new ImageIcon(this.getClass().getResource("/ressources/box.jpg"));
				}
				
				JLabel levelElement = new JLabel(ico);
				this.add(levelElement);
			}
		}
	}
}
7. Polymorphism
   Contohnya ada dalam polymorphism dari overloading dan overriding yang sudah saya berikan sebelumnya.
8. ArrayList
   Pada game saya, terdapat ArrayList yang mengatur banyaknya box dalam sebuah stage
9. Exception Handling
   try{
								this.fixedElements[pos.getPosX()][pos.getPosY()] = FixedMapElement.fromString(Character.toString(currentChar));
							}catch(IllegalArgumentException e){
								System.out.println(e.getMessage());
							}
10. GUI
    GUI yang saya terapkan dalam FP ini sebagian besar terdiri dari button yang digunakan untuk menjalankan playernya untuk bergerak dan juga, reset dan quit
11. Interface
    public interface PlayerInteraction{
	      public Direction askDirection();
	      public int askLevelToPlay();
	      public void askToQuit();
	  }
12. Abstract Class
    public abstract class GameWindow extends JFrame implements ActionListener, KeyListener, PlayerInteraction, Display{
        private JSplitPane mainSplitPanel;
        private JSplitPane secondSplitPane;
        private JSplitPane thirdSplitPane;
        private JButton quitButton;
        ...
13. Generics
    file
14. Collection
    Pada game saya, dapat ditemukan melalui adanya penggunakan ArrayList. ArrayList sendiri digunakan pada class Board untuk melakukan input dan output
15. Input Output
    public void askToQuit();
Link Sources : 
- https://www.youtube.com/watch?v=5W2uXgf5Km8&ab_channel=Coding-adora
- https://zetcode.com/javagames/
- https://github.com/eloyzone/sokoban-javafx-game
